package com.nttdata3.services;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata3.models.Usuario;
import com.nttdata3.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;

	//buscar por email
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
		
	}
		
	public void insertarUsuario(@Valid Usuario usuario) {
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(roleService.findByNombre("ROLE_USER"));
		usuarioRepository.save(usuario);
	}
	
	public void actualizarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> obtenerListaUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuarioId(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void eliminarUsuarioObj(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}

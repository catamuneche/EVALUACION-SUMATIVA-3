package com.nttdata3.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata3.models.Usuario;
import com.nttdata3.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("") // Desplegar vista usuario
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		return "usuario/registro.jsp";
	}
	
	@RequestMapping("/registro") 	// Capturar info formulario
	public String registro(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.insertarUsuario(usuario);
		return "redirect:/usuario";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarObj(@RequestParam("id") Long id) {
		System.out.println("Id: "+ id);
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario != null) {
			usuarioService.eliminarUsuarioObj(usuario);
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping("/editar") //llama el jsp
	public String editar(@RequestParam("id") Long id, Model model) {	
		Usuario usuario = usuarioService.buscarUsuarioId(id);
		if(usuario != null) {
			model.addAttribute("usuario", usuario);
			return "usuario/editar.jsp";
		}
		return "redirect:/usuario";	
	}
	
	@RequestMapping(value="/actualizar", method = RequestMethod.POST) //realiza la actualización
	public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuario, Model model) {
		System.out.println("id " + usuario.getId());
		usuarioService.actualizarUsuario(usuario);
		return "redirect:/usuario/";
	}
	
}

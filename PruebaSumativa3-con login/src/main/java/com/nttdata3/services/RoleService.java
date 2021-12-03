package com.nttdata3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata3.models.Role;
import com.nttdata3.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository rr;
	
	
	public List<Role> findByNombre(String nombre) {
		return rr.findByNombre(nombre);
	}
}
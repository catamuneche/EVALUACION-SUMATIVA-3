package com.nttdata3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata3.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	List<Role> findByNombre(String nombre);
}
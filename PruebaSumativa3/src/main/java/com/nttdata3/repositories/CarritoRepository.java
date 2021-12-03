package com.nttdata3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nttdata3.models.Carrito;

public interface CarritoRepository extends CrudRepository<Carrito, Long>{
	List<Carrito> findAll();

}

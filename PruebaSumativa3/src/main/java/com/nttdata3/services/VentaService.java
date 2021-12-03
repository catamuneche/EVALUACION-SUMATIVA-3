package com.nttdata3.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata3.models.Producto;
import com.nttdata3.repositories.ProductoRepository;

@Service
public class VentaService {
	@Autowired
	ProductoRepository productoRepository;

	public void insertarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	
	public void actualizarProducto(@Valid Producto producto) {
		productoRepository.save(producto);
	}
	
	public List<Producto> obtenerListaProductos() {
		return productoRepository.findAll();
	}
	
	public Producto buscarProductoId(Long id) {
		return productoRepository.findById(id).get();
	}

	public void eliminarProducto(Long id) {
		productoRepository.deleteById(id);
	}

	public void eliminarProductoObj(Producto producto) {
		productoRepository.delete(producto);
	}
}

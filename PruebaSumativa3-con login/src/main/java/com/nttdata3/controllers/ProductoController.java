package com.nttdata3.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata3.models.Producto;
import com.nttdata3.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	
	@RequestMapping("") // Desplegar vista producto
	public String producto(@ModelAttribute("producto") Producto producto,
			Model model) {
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		return "producto/producto.jsp";
	}
	
	@RequestMapping("/insertar") 	// Capturar info formulario
	public String insertar(@ModelAttribute("producto") Producto producto) {
		productoService.insertarProducto(producto);
		return "redirect:/producto";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarObj(@RequestParam("id") Long id) {
		System.out.println("Id: "+ id);
		Producto producto = productoService.buscarProductoId(id);
		if(producto != null) {
			productoService.eliminarProductoObj(producto);
		}
		return "redirect:/producto";
	}
	
	@RequestMapping("/editar") //llama el jsp
	public String editar(@RequestParam("id") Long id, Model model) {	
		Producto producto = productoService.buscarProductoId(id);
		if(producto != null) {
			model.addAttribute("producto", producto);
			return "producto/editar.jsp";
		}
		return "redirect:/producto";	
	}
	
	@RequestMapping(value="/actualizar", method = RequestMethod.POST) //realiza la actualización
	public String actualizar(@Valid @ModelAttribute("producto") Producto producto, Model model) {
		System.out.println("id " + producto.getId());
		productoService.actualizarProducto(producto);
		return "redirect:/producto/";
	}
}

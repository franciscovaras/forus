package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Producto;
import com.bolsadeideas.springboot.backend.apirest.models.services.IProductoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Api(tags = "producto")
public class ProductoRestController {

	@Autowired
	private IProductoService productoService;

	@GetMapping("/producto")
	public List<Producto> index() {
		return productoService.findAll();
	}

	@GetMapping("/producto/{id}")
	public Producto show(@PathVariable Long id) {
		return productoService.findById(id);
	}

	@PostMapping("/producto")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto create(@RequestBody Producto cliente) {
		return productoService.save(cliente);
	}

	@PutMapping("producto/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {

		Producto productoActual = productoService.findById(id);

		productoActual.setProductoNombre(producto.getProductoNombre());
		productoActual.setProductoDescripcion(producto.getProductoDescripcion());
		productoActual.setProductoCantidad(producto.getProductoCantidad());
		productoActual.setProductoUbicacion(producto.getProductoUbicacion());

		return productoService.save(productoActual);
	}

	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		productoService.delete(id);
	}
}

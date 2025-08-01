package com.piero.crud_usuarios.controller;

import com.piero.crud_usuarios.dto.ProductoDTO;
import com.piero.crud_usuarios.service.ProductoDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/cliente/productos")
public class ProductoDTOController {

    @Autowired
    private ProductoDTOService productoDTOService;

    // GET - Listar todos los productos (versión cliente)
    @GetMapping
    public List<ProductoDTO> listarTodos() {
        return productoDTOService.listarTodos();
    }

    // GET - Obtener producto por ID
    @GetMapping("/{id}")
    public ProductoDTO obtenerPorId(@PathVariable Long id) {
        return productoDTOService.obtenerPorId(id);
    }

    // GET - Buscar productos por categoría
    @GetMapping("/categoria/{categoria}")
    public List<ProductoDTO> buscarPorCategoria(@PathVariable String categoria) {
        return productoDTOService.buscarPorCategoria(categoria);
    }

    // GET - Buscar productos por nombre
    @GetMapping("/nombre/{nombre}")
    public List<ProductoDTO> buscarPorNombre(@PathVariable String nombre) {
        return productoDTOService.buscarPorNombre(nombre);
    }

}

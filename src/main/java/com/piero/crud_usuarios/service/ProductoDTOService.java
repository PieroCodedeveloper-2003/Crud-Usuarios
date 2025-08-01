package com.piero.crud_usuarios.service;

import com.piero.crud_usuarios.dto.ProductoDTO;

import java.util.List;

public interface ProductoDTOService {

    List<ProductoDTO> listarTodos();
    ProductoDTO obtenerPorId(Long id);
    List<ProductoDTO> buscarPorCategoria(String categoria);
    List<ProductoDTO> buscarPorNombre(String nombre);

}

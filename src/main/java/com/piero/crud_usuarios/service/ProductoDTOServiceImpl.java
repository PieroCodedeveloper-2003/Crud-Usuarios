package com.piero.crud_usuarios.service;

import com.piero.crud_usuarios.dto.ProductoDTO;
import com.piero.crud_usuarios.model.Producto;
import com.piero.crud_usuarios.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoDTOServiceImpl implements ProductoDTOService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarTodos() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto producto : productos) {
            listaDTO.add(convertirAProductoDTO(producto));
        }

        return listaDTO;
    }

    @Override
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        return convertirAProductoDTO(producto);
    }

    @Override
    public List<ProductoDTO> buscarPorCategoria(String categoria) {
        List<Producto> productos = productoRepository.findByCategoriaContainingIgnoreCase(categoria);
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto producto : productos) {
            listaDTO.add(convertirAProductoDTO(producto));
        }

        return listaDTO;
    }

    @Override
    public List<ProductoDTO> buscarPorNombre(String nombre) {
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto producto : productos) {
            listaDTO.add(convertirAProductoDTO(producto));
        }

        return listaDTO;
    }

    private ProductoDTO convertirAProductoDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setIdProducto(producto.getIdProducto());
        dto.setNombre(producto.getNombre());
        dto.setCategoria(producto.getCategoria());
        return dto;
    }

}

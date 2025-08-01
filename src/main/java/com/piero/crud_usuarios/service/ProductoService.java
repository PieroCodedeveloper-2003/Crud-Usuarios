package com.piero.crud_usuarios.service;

import com.piero.crud_usuarios.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listarProductos();
    Optional<Producto> obtenerPorId(Long id);
    Producto guardarProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto product_update);
    void eliminarProducto(Long id);

}

package com.piero.crud_usuarios.service;

import com.piero.crud_usuarios.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> listarUsuarios();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long id, Usuario user_update);
    void eliminarUsuario(Long id);

}

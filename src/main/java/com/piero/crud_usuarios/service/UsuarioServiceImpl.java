package com.piero.crud_usuarios.service;

import com.piero.crud_usuarios.model.Usuario;
import com.piero.crud_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario user_update) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        user.setNombre(user_update.getNombre());
        user.setCorreo(user_update.getCorreo());
        user.setEdad(user_update.getEdad());
        return usuarioRepository.save(user);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}

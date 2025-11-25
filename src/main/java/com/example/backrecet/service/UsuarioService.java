package com.example.backrecet.service;

import com.example.backrecet.model.Usuario;
import com.example.backrecet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> actualizarParcial(Integer id, Usuario cambios) {
        return usuarioRepository.findById(id).map(usuario -> {
            if (cambios.getNombre() != null) usuario.setNombre(cambios.getNombre());
            if (cambios.getEmail() != null) usuario.setEmail(cambios.getEmail());
            if (cambios.getPassword() != null) usuario.setPassword(cambios.getPassword());
            return usuarioRepository.save(usuario);
        });
    }
}

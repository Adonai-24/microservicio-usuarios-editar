package com.microservicio.usuarios.microservicio_usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.usuarios.microservicio_usuarios.repository.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Historia de usuario Eliminar Usuario - Erwin Javier Martinez Morales
    public boolean deleteUsuarios(Long id) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setEstatus(!usuario.getEstatus());
                    usuariosRepository.save(usuario);
                    return true;
                })
                .orElse(false);
    }

}

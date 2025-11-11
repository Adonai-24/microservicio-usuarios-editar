package com.microservicio.usuarios.microservicio_usuarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosAddDto;
import com.microservicio.usuarios.microservicio_usuarios.entity.Usuarios;
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

    public Usuarios agregarUsuario(UsuariosAddDto dto) {
        Usuarios usuario = new Usuarios();
        usuario.setMatricula(dto.getMatricula());
        usuario.setNombre(dto.getNom());
        usuario.setRol(dto.getRol());
        usuario.setEmail(dto.getEmail());
        usuario.setEstatus(dto.getEstatus() == 1);

        return usuariosRepository.save(usuario);
    }
}

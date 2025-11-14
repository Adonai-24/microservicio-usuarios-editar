/*****************************************************************************
 * @Author                : adolnb<loro.lorenzonunez@gmail.com>              *
 * @CreatedDate           : 2025-11-10 18:42:02                              *
 * @LastEditors           : adolnb<loro.lorenzonunez@gmail.com>              *
 * @LastEditDate          : 2025-11-13 18:20:10                              *
 * @FilePath              : UsuariosService.java                             *
 * @CopyRight             : © 2025 Adonai LN - B0MB0                         *
 ****************************************************************************/

package com.microservicio.usuarios.microservicio_usuarios.service;

import com.microservicio.usuarios.microservicio_usuarios.repository.UsuariosRepository;
import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosListDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosAddDto;
import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosEditDto;
import com.microservicio.usuarios.microservicio_usuarios.entity.Usuarios;
import com.microservicio.usuarios.microservicio_usuarios.repository.UsuariosRepository;


@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    
    // Historia de usuario Listar usuarios - Jonathan Molina De Jesús
    public List<UsuariosListDto> listarUsuarios(){
        return usuariosRepository.findAll()
                .stream()
                .map(usuario -> {
                    UsuariosListDto dto = new UsuariosListDto();
                    dto.setId(usuario.getId());
                    dto.setMatricula(usuario.getMatricula());
                    dto.setNom(usuario.getNombre());
                    dto.setRol(usuario.getRol());
                    dto.setEmail(usuario.getEmail());
                    return dto;
                })
                .collect(Collectors.toList());
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

    // Editar Usuario - Adonai Lorenzo BMB
    public Usuarios editarUsuario(Long id, UsuariosEditDto dto) {
        Usuarios usuario = usuariosRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setMatricula(dto.getMatricula());
        usuario.setNombre(dto.getNom());
        usuario.setRol(dto.getRol());
        usuario.setEmail(dto.getEmail());

        return usuariosRepository.save(usuario);
    }

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
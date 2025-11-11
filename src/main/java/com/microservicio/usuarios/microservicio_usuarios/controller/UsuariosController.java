package com.microservicio.usuarios.microservicio_usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosAddDto;
import com.microservicio.usuarios.microservicio_usuarios.entity.Usuarios;
import com.microservicio.usuarios.microservicio_usuarios.service.UsuariosService;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/agregar")
    public Usuarios agregarUsuario(@RequestBody UsuariosAddDto dto) {
        return usuariosService.agregarUsuario(dto);
    }    

    // Historia de usuario Eliminar Usuario - Erwin Javier Martinez Morales
    @DeleteMapping("/eliminar-usuario/{id}")
    public boolean deleteUsuarios(@PathVariable Long id) {
        return usuariosService.deleteUsuarios(id);
    }

}

/*
 * 
 * INSERT INTO t_usuarios (matricula, nombre, email, rol, estatus)
 * VALUES ('A01234567', 'Carlos Hernández', 'carlos.hernandez@example.com',
 * 'ADMIN', true);
 * 
 * INSERT INTO t_usuarios (matricula, nombre, email, rol, estatus)
 * VALUES ('A01234999', 'María López', 'maria.lopez@example.com', 'USER', true);
 * 
 * INSERT INTO t_usuarios (matricula, nombre, email, rol, estatus)
 * VALUES ('A01233001', 'Javier Ruiz', 'javier.ruiz@example.com', 'SUPERVISOR',
 * false);
 */

/*****************************************************************************
 * @Author                : adolnb<loro.lorenzonunez@gmail.com>              *
 * @CreatedDate           : 2025-11-10 18:20:55                              *
 * @LastEditors           : adolnb<loro.lorenzonunez@gmail.com>              *
 * @LastEditDate          : 2025-11-13 18:19:58                              *
 * @FilePath              : UsuariosController.java                          *
 * @CopyRight             : © 2025 Adonai LN - B0MB0                         *
 ****************************************************************************/

package com.microservicio.usuarios.microservicio_usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosAddDto;
import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosEditDto;
import com.microservicio.usuarios.microservicio_usuarios.entity.Usuarios;
import com.microservicio.usuarios.microservicio_usuarios.service.UsuariosService;


import com.microservicio.usuarios.microservicio_usuarios.service.UsuariosService;
import com.microservicio.usuarios.microservicio_usuarios.dto.UsuariosListDto;
import java.util.List;

@RestController

@RequestMapping("api/usuarios")
@CrossOrigin(origins = "*")

public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    // Historia de usuario Listar usuarios - Jonathan Molina De Jesús
    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<UsuariosListDto>> listarUsuarios(){
        List<UsuariosListDto> usuarios = usuariosService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }


    @PostMapping("/agregar")
    public Usuarios agregarUsuario(@RequestBody UsuariosAddDto dto) {
        return usuariosService.agregarUsuario(dto);
    }

    // Editar Usuario - Adonai Lorenzo BMB
    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuarios> editarUsuario(@PathVariable Long id, @RequestBody UsuariosEditDto dto) {
        try {
            Usuarios userUpdate = usuariosService.editarUsuario(id, dto);
            return ResponseEntity.ok(userUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Historia de usuario Eliminar Usuario - Erwin Javier Martinez Morales
    @DeleteMapping("/eliminar-usuario/{id}")
    public boolean deleteUsuarios(@PathVariable Long id) {
        return usuariosService.deleteUsuarios(id);
    }
}

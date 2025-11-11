/*****************************************************************************
 * @Author                : adolnb<loro.lorenzonunez@gmail.com>              *
 * @CreatedDate           : 2025-11-10 18:20:55                              *
 * @LastEditors           : adolnb<loro.lorenzonunez@gmail.com>              *
 * @LastEditDate          : 2025-11-10 18:43:08                              *
 * @FilePath              : UsuariosController.java                          *
 * @CopyRight             : © 2025 Adonai LN - B0MB0                         *
 ****************************************************************************/

package com.microservicio.usuarios.microservicio_usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PutMapping("/editar/{id}")
    public ResponseEntity<Usuarios> editarUsuario(@PathVariable Long id, @RequestBody UsuariosEditDto dto) {
        try {
            Usuarios userUpdate = usuariosService.editarUsuario(id, dto);
            return ResponseEntity.ok(userUpdate);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

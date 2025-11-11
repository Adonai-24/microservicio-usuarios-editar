package com.microservicio.usuarios.microservicio_usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

}

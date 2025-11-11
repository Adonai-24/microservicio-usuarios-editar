/*****************************************************************************
 * @Author                : adolnb<loro.lorenzonunez@gmail.com>              *
 * @CreatedDate           : 2025-11-10 18:33:19                              *
 * @LastEditors           : adolnb<loro.lorenzonunez@gmail.com>              *
 * @LastEditDate          : 2025-11-10 18:33:34                              *
 * @FilePath              : UsuariosEditDto.java                             *
 * @CopyRight             : © 2025 Adonai LN - B0MB0                         *
 ****************************************************************************/

package com.microservicio.usuarios.microservicio_usuarios.dto;

import lombok.Data;


@Data
public class UsuariosEditDto {
    private String matricula;
    private String nom;
    private String rol;
    private String email;
    private int estatus;
}

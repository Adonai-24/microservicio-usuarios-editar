/*****************************************************************************
 * @Author                : adolnb<loro.lorenzonunez@gmail.com>              *
 * @CreatedDate           : 2025-11-10 18:23:42                              *
 * @LastEditors           : adolnb<loro.lorenzonunez@gmail.com>              *
 * @LastEditDate          : 2025-11-10 18:29:20                              *
 * @FilePath              : Usuarios.java                                    *
 * @CopyRight             : © 2025 Adonai LN - B0MB0                         *
 ****************************************************************************/

package com.microservicio.usuarios.microservicio_usuarios.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "t_usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "rol", nullable = false)
    private String rol;
    
    @Column(name = "estatus", nullable = false)
    private Boolean estatus;
}

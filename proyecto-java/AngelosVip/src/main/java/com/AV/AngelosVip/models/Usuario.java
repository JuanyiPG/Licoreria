package com.AV.AngelosVip.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
private Integer idUsuarios;
    @Column(name="nombre_usuario")
private String nombreUsuarios;
private String email;
private String password;
private String telefono;
private String direccion;
    @DateTimeFormat(pattern = "YYYY/MM/DD")
@Column(name = "fecha_inicio")
private Date fechaInicio;
@Column(name = "estado_usuario")
private String estadoUsuario;
@OneToOne
@JoinColumn(name = "id_roles", referencedColumnName = "id_roles")
private Rol rol;
}

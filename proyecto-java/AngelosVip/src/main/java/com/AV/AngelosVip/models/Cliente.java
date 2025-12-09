package com.AV.AngelosVip.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "cliente")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    private String direccion;
    @Column(name = "numerto_tel")
    private String tel;
    @Column(name = "tipo_id")
    private String tipoId;
    @Column(name = "num_id")
    private String numId;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    private String correo;
    private String contraseña;
}

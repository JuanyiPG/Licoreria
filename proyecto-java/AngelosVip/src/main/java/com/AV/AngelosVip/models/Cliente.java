package com.AV.AngelosVip.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "id_cliente")
    private Integer idCliente;
    @DateTimeFormat(pattern = "YYYY/MM/DD")
    private Date fechaNacimiento;
    private String direccion;
    private String tel;
    private String tipoId;
    private String numId;
    private String nombreUsuario;
    private String corro;
    private String contraseña;
}

package com.AV.AngelosVip.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="licor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Licor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_licor")
    private Integer idLicor;
    @Column(name="nombre_licor")
    private String nombreLicor;
    private String marca;
    private BigDecimal precio;
    private Integer stockmin;
    private Integer stockmax;
}

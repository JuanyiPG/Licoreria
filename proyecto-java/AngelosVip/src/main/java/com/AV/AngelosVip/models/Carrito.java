package com.AV.AngelosVip.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name="Carrito")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCar;

    @OneToMany
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario facturaVenta;
}

package com.AV.AngelosVip.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CarritoItems")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int cantidad;
    @ManyToMany
    @JoinColumn(name = "licor_id", referencedColumnName = "id_lico")
    private Integer licor_id;

    @ManyToMany
    @JoinColumn(name="idCar", referencedColumnName = "idCar")
    private Integer idCar;


}

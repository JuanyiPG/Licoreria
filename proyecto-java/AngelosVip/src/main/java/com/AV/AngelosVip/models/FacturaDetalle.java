package com.AV.AngelosVip.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="FacturaDetalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalle {
    @Id
    @Column(name = "id_facdet")
    private Integer idFactDet;

    @ManyToOne
    @JoinColumn(name = "factura_id", referencedColumnName = "id_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "licor_id", referencedColumnName = "id_licor")
    private Licor licor;

}

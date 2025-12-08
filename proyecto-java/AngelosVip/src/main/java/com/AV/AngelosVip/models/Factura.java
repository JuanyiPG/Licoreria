package com.AV.AngelosVip.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="factura")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    @id
    private Integer id;
    private Date fecha;
    private String metodo_pago;
    private BigDecimal total;
    private Integer cantidad;
    private Boolean estado;
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;
}

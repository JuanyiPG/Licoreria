<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class DetalleVenta extends Model
{
    // Nombre de la tabla
    protected $table = 'detalle_ventas';

    // Columnas que se pueden llenar
    protected $fillable = ['venta_id', 'producto_id', 'cantidad', 'precio_unitario'];

    // Relación: cada detalle pertenece a una venta
    public function venta()
    {
        return $this->belongsTo(Venta::class, 'venta_id');
    }
}

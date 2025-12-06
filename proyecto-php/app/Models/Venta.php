<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Venta extends Model
{
    // Nombre de la tabla en la base de datos
    protected $table = 'ventas';

    // Columnas que Laravel puede rellenar
    protected $fillable = ['usuario_id', 'total', 'metodo_pago', 'estado'];

    // Relación: una venta tiene muchos detalles
    public function detalles()
    {
        return $this->hasMany(DetalleVenta::class, 'venta_id');
    }
}

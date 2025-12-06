<?php

namespace App\Http\Controllers;

use App\Models\Venta;
use App\Models\DetalleVenta;
use Illuminate\Http\Request;

class VentaController extends Controller
{
    public function guardarVenta(Request $request)
    {
        // El carrito llega desde tu frontend en formato JSON
        $carrito = $request->input('carrito');

        // ID del usuario (si no tienes login, por ahora lo dejamos en 1)
        $usuarioId = auth()->id() ?? 1;

        // Calcular el total sumando precio * cantidad
        $total = collect($carrito)->sum(fn($item) => $item['precio'] * $item['cantidad']);

        // Crear la venta
        $venta = Venta::create([
            'usuario_id' => $usuarioId,
            'total' => $total,
            'metodo_pago' => 'efectivo', // puedes cambiarlo más adelante
            'estado' => 'pagado'
        ]);

        // Guardar cada producto en detalle_ventas
        foreach ($carrito as $item) {
            DetalleVenta::create([
                'venta_id' => $venta->id,
                'producto_id' => $item['id'], // el ID del producto
                'cantidad' => $item['cantidad'],
                'precio_unitario' => $item['precio'],
            ]);
        }

        // Respuesta al frontend
        return response()->json([
            'success' => true,
            'message' => 'Compra registrada con éxito',
            'venta_id' => $venta->id
        ]);
    }
}

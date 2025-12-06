<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;

class User extends Authenticatable
{
    use HasFactory, Notifiable;

    // 👇 Esto hace que Laravel use tu tabla "usuarios"
    protected $table = 'usuarios';

    /**
     * Los atributos que se pueden asignar masivamente
     *
     * @var array<int, string>
     */
    protected $fillable = [
        'nombre',       // <- usamos "nombre" en lugar de "name"
        'email',
        'password',
        'rol',
        'telefono',
        'direccion',
    ];

    /**
     * Los atributos que deben ocultarse al serializar
     *
     * @var array<int, string>
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * Los atributos que deben castearse
     *
     * @var array<string, string>
     */
    protected function casts(): array
    {
        return [
            'fecha_registro' => 'datetime',
            'password' => 'hashed',
        ];
    }
}

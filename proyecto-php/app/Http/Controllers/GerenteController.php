<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class GerenteController extends Controller
{
    /**
     * Mostrar la página principal del gerente.
     */
    public function index()
    {
        return view('gerente.index'); // cargará la vista resources/views/gerente/index.blade.php
    }
}

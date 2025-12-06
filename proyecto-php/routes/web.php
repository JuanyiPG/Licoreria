<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;

// Página de login
Route::get('/', function () {
    return view('welcome');
})->name('login');

// Página de registro
Route::get('/registro', function () {
    return view('registro');
})->name('registro');

// Página principal de usuario
Route::get('/index', function () {
    return view('index');
})->name('index');

// Página principal de administrador
Route::get('/inicio', function () {
    return view('inicio');
})->name('inicio');

// Catálogo
Route::get('/catalogo', function () {
    return view('principal');
})->name('catalogo');

// Logout
Route::post('/logout', function (Request $request) {
    Auth::logout();
    $request->session()->invalidate();
    $request->session()->regenerateToken();
    return redirect()->route('login');
})->name('logout');
use App\Http\Controllers\GerenteController;

Route::get('/gerente', [GerenteController::class, 'index'])->name('gerente');
Route::get('/gerente', function () {
    return view('gerente');
})->name('gerente');
Route::get('/dashboard', [GerenteController::class, 'dashboard'])->name('dashboard');
Route::get('/ventas', [GerenteController::class, 'ventas'])->name('ventas');
Route::get('/productos', [GerenteController::class, 'productos'])->name('productos');
Route::get('/usuarios', [GerenteController::class, 'usuarios'])->name('usuarios');
Route::get('/reportes', [GerenteController::class, 'reportes'])->name('reportes');
Route::get('/configuracion', [GerenteController::class, 'configuracion'])->name('configuracion');

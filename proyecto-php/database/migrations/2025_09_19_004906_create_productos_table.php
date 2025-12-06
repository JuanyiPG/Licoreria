<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::table('productos', function (Blueprint $table) {
            // Aquí agregas columnas si quieres modificar después
        });
    }

    public function down(): void
    {
        Schema::table('productos', function (Blueprint $table) {
            // Aquí podrías eliminar las columnas que agregaste
        });
    }
};

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Dashboard | Angelos V.I.P</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap 5 CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Iconos -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

  <!--Style for dashboard-->
  <link href="CSS/Dashboard.css" rel="stylesheet">
</head>
<body>

  <!-- Sidebar -->
  <div class="sidebar">
    <h2>Angelos V.I.P</h2>
    <a href="index.html"><i class="bi bi-house"></i> Inicio</a>
    <a href="Usuarios.html"><i class="bi bi-people"></i> Usuarios</a>
    <a href="Productos.html"><i class="bi bi-box-seam"></i> Productos</a>
    <a href="#"><i class="bi bi-cash-stack"></i> Ventas</a>
    <a href="Estadisticas.html"><i class="bi bi-graph-up"></i> Estadísticas</a>
   <a href="login.html" onclick="cerrarSesion()"><i class="bi bi-door-closed"></i> Cerrar sesión</a>
  </div>

  <!-- Contenido principal -->
  <div class="main-content">
    <h1 class="mb-4">Panel de Control</h1>
     <!-- Sección Empleados -->
  <section id="seccion-empleados" class="seccion-dashboard">
    <h2>Gestión de Empleados</h2>
    <p>Acá va el formulario, tabla o lista de empleados.</p>
  </section>

  <!-- Sección Productos -->
  <section id="seccion-productos" class="seccion-dashboard" style="display: none;">
    <h2>Gestión de Productos</h2>
    <p>Aquí se pueden agregar o ver productos.</p>
  </section>

  <!-- Sección Ventas -->
  <section id="seccion-ventas" class="seccion-dashboard" style="display: none;">
    <h2>Historial de Ventas</h2>
    <p>Aquí van las ventas realizadas.</p>
  </section>

  <!-- Sección Estadísticas -->
  <section id="seccion-estadisticas" class="seccion-dashboard" style="display: none;">
    <h2>Estadísticas del negocio</h2>
    <p>Gráficos, ingresos, rendimiento, etc.</p>
  </section>
    <h5 id="bienvenidaDashboard" class="mb-4 text-warning"></h5>
    <div class="row g-4">
      <div class="col-md-4">
        <div class="card p-3">
          <h5 class="card-title"><i class="bi bi-people-fill"></i> Empleados</h5>
          <p class="card-text fs-4">25 activos</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card p-3">
          <h5 class="card-title"><i class="bi bi-box-seam"></i> Productos</h5>
          <p class="card-text fs-4">180 en stock</p>
        </div>
      </div>
      <div class="col-md-4">
        <div class="card p-3">
          <h5 class="card-title"><i class="bi bi-currency-dollar"></i> Ventas Hoy</h5>
          <p class="card-text fs-4">$1.200.000</p>
        </div>
      </div>
    </div>

    <div class="mt-5">
      <h4>Resumen Semanal</h4>
      <div class="card p-4 mt-3">
        <p>Ventas totales: <strong>$7.500.000</strong></p>
        <p>Productos vendidos: <strong>320</strong></p>
        <p>Clientes nuevos: <strong>12</strong></p>
        <a href="#" class="btn btn-gold mt-3">Ver más detalles</a>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="JS/dashboard.js"></script>
</body>
</html>
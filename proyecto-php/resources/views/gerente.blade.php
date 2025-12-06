<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Panel Gerente | Angelos V.I.P</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">

  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: 'Montserrat', sans-serif;
      display: flex;
      min-height: 100vh;
      background: linear-gradient(135deg, #1e0c5a, #3a0ca3, #7209b7, #4361ee);
      background-size: 400% 400%;
      animation: gradientMove 12s ease infinite;
      color: #fff;
    }

    @keyframes gradientMove {
      0% {background-position: 0% 50%;}
      50% {background-position: 100% 50%;}
      100% {background-position: 0% 50%;}
    }

    /* Sidebar */
    .sidebar {
      width: 240px;
      background: rgba(0, 0, 0, 0.8);
      backdrop-filter: blur(10px);
      padding: 25px;
      display: flex;
      flex-direction: column;
      gap: 18px;
      box-shadow: 4px 0 15px rgba(0,0,0,0.6);
    }

    .sidebar h2 {
      color: #00f5d4;
      margin-bottom: 25px;
      font-size: 24px;
      text-align: center;
      font-weight: 700;
      text-shadow: 0 0 10px rgba(0,245,212,0.9);
    }

    .sidebar a {
      text-decoration: none;
      color: #fff;
      font-size: 16px;
      padding: 12px;
      border-radius: 10px;
      transition: all 0.3s ease;
      display: flex;
      align-items: center;
      gap: 8px;
      background: rgba(255,255,255,0.05);
    }

    .sidebar a:hover {
      background: linear-gradient(135deg, #00f5d4, #06d6a0);
      color: #000;
      font-weight: bold;
      box-shadow: 0 0 15px rgba(0,245,212,0.7);
      transform: translateX(5px);
    }

    /* Contenido principal */
    .main {
      flex: 1;
      padding: 40px;
      animation: fadeIn 1s ease-in-out;
    }

    header {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 40px;
      border-bottom: 2px solid rgba(255,255,255,0.2);
      padding-bottom: 15px;
    }

    header img {
      width: 150px;
      height: auto;
      filter: drop-shadow(0 0 12px rgba(0,245,212,0.8));
    }

    header h1 {
      font-size: 30px;
      color: #00f5d4;
      text-shadow: 0 0 15px rgba(0,245,212,1);
    }

    /* Tarjetas */
    .cards {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
      gap: 25px;
    }

    .card {
      background: rgba(255,255,255,0.1);
      backdrop-filter: blur(12px);
      padding: 25px;
      border-radius: 18px;
      box-shadow: 0 4px 20px rgba(0,0,0,0.5);
      transition: all 0.4s ease;
      cursor: pointer;
      position: relative;
      overflow: hidden;
    }

    .card:hover {
      transform: translateY(-10px) scale(1.05);
      box-shadow: 0 8px 30px rgba(0,245,212,0.6);
    }

    .card::before {
      content: "";
      position: absolute;
      top: -50%;
      left: -50%;
      width: 200%;
      height: 200%;
      background: radial-gradient(circle, rgba(0,245,212,0.3) 0%, transparent 70%);
      transform: rotate(25deg);
      transition: opacity 0.4s;
      opacity: 0;
    }

    .card:hover::before {
      opacity: 1;
    }

    .card h3 {
      margin-bottom: 12px;
      font-size: 20px;
      color: #00f5d4;
      font-weight: 700;
      text-shadow: 0 0 10px rgba(0,245,212,0.8);
    }

    .card p {
      font-size: 18px;
      color: #fff;
      font-weight: 500;
    }

    /* Botón salir */
    .btn-salir {
      background: linear-gradient(135deg, #ff4d6d, #d90429);
      color: #fff;
      border: none;
      padding: 12px 18px;
      border-radius: 10px;
      cursor: pointer;
      transition: all 0.3s ease;
      font-weight: bold;
      font-size: 15px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.5);
    }

    .btn-salir:hover {
      background: linear-gradient(135deg, #ff758f, #ef233c);
      transform: scale(1.05);
      box-shadow: 0 6px 18px rgba(255,77,109,0.8);
    }

    /* Animaciones */
    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>

  <!-- Sidebar -->
  <aside class="sidebar">
    <h2>Menú Gerente</h2>
    <a href="#">📊 Dashboard</a>
    <a href="#">🛒 Ventas</a>
    <a href="#">📦 Productos</a>
    <a href="#">👥 Usuarios</a>
    <a href="#">📈 Reportes</a>
    <a href="#">⚙ Configuración</a>
  </aside>

  <!-- Main -->
  <main class="main">
    <header>
      <h1>Panel de Gerente</h1>
      <img src="https://angelos.com.co/wp-content/uploads/2025/04/Logo.png" alt="Logo Angelos V.I.P">
      <form action="{{ route('logout') }}" method="POST" style="margin:0;">
        @csrf
        <button type="submit" class="btn-salir">Salir</button>
      </form>
    </header>

    <!-- Tarjetas de resumen -->
    <section class="cards">
      <div class="card">
        <h3>Ventas Hoy</h3>
        <p>$1,250,000</p>
      </div>
      <div class="card">
        <h3>Productos en Stock</h3>
        <p>320</p>
      </div>
      <div class="card">
        <h3>Usuarios Registrados</h3>
        <p>540</p>
      </div>
      <div class="card">
        <h3>Pedidos Pendientes</h3>
        <p>18</p>
      </div>
    </section>
  </main>

</body>
</html>

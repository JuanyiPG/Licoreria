<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Login | Angelos V.I.P</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">

  <!-- Estilos -->
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: 'Montserrat', sans-serif;
      background: #000;
      height: 100vh;
      display: flex;
      justify-content: space-between;
      align-items: center;
      color: #fff;
      padding: 40px;
      overflow: hidden;
    }

    .container {
      display: flex;
      width: 100%;
      justify-content: space-between;
      align-items: center;
    }

    form {
      width: 100%;
      max-width: 350px;
      text-align: left;
    }

    h2 {
      margin-bottom: 25px;
      color: #1DB954;
      font-size: 28px;
      font-weight: 700;
      display: flex;
      align-items: center;
      gap: 10px;
    }

    h2 img {
      width: 95px;
      height: auto;
    }

    label {
      font-weight: 600;
      display: block;
      margin: 10px 0 5px;
      color: #b3b3b3;
      font-size: 14px;
    }

    input, select {
      width: 100%;
      padding: 12px;
      margin-bottom: 15px;
      border: none;
      border-radius: 8px;
      background-color: #121212;
      color: #fff;
      font-size: 15px;
    }

    input::placeholder {
      color: #888;
    }

    input:focus, select:focus {
      outline: 2px solid #1DB954;
      background-color: #181818;
    }

    .btn-login {
      width: 100%;
      padding: 12px;
      background-color: #1DB954;
      color: #fff;
      border: none;
      border-radius: 30px;
      font-weight: bold;
      font-size: 16px;
      cursor: pointer;
      transition: all 0.3s ease;
      margin-top: 10px;
    }

    .btn-login:hover {
      background-color: #1ed760;
      transform: scale(1.03);
    }

    .register-link {
      display: block;
      margin-top: 20px;
      color: #b3b3b3;
      font-size: 14px;
      text-decoration: none;
      transition: color 0.3s;
    }

    .register-link:hover {
      color: #1DB954;
    }

    .carrusel {
      width: 60%;
      height: 400px;
      overflow: hidden;
      position: relative;
      border-radius: 12px;
    }

    .carrusel-track {
      display: flex;
      transition: transform 0.8s ease-in-out;
    }

    .carrusel img {
      width: 100%;
      height: 400px;
      object-fit: cover;
      flex-shrink: 0;
    }

    .carrusel button {
      position: absolute;
      top: 50%;
      transform: translateY(-50%);
      background: rgba(0,0,0,0.6);
      color: #fff;
      border: none;
      font-size: 28px;
      cursor: pointer;
      padding: 10px 15px;
      border-radius: 50%;
      transition: background 0.3s;
    }

    .carrusel button:hover {
      background: rgba(29,185,84,0.8);
    }

    .prev { left: 10px; }
    .next { right: 10px; }
  </style>
</head>
<body>

  <div class="container">

    <!-- Formulario -->
    <form id="loginForm">
      <h2>
        <img src="https://angelos.com.co/wp-content/uploads/2025/04/Logo.png" alt="Logo Angelos V.I.P">
        Angelos V.I.P
      </h2>

      <!-- Selector de rol -->
      <label for="rol">Iniciar como</label>
      <select id="rol" name="rol" required>
        <option value="">-- Selecciona una opción --</option>
        <option value="usuario">Usuario</option>
        <option value="admin">Administrador</option>
        <option value="gerente">Gerente</option> <!-- ✅ agregado -->
      </select>

      <label for="usuario">Usuario</label>
      <input type="text" id="usuario" required placeholder="Ingresa tu usuario">

      <label for="email">Correo electrónico</label>
      <input type="email" id="email" required placeholder="ejemplo@correo.com">

      <label for="password">Contraseña</label>
      <input type="password" id="password" required placeholder="Tu contraseña">

      <button type="submit" class="btn-login">Iniciar Sesión</button>
      <a href="{{ route('registro') }}" class="register-link">¿No tienes cuenta? Regístrate</a>
    </form>

    <!-- Carrusel de imágenes -->
    <div class="carrusel">
      <div class="carrusel-track">
        <img src="https://angelos.com.co/wp-content/uploads/2022/04/DSC_0154.jpg" alt="Licorera 1">
        <img src="https://angelos.com.co/wp-content/uploads/2022/04/DSC_0007-1.jpg" alt="Licorera 2">
        <img src="https://angelos.com.co/wp-content/uploads/2022/04/DSC0098.jpg" alt="Licorera 3">
        <img src="https://st.depositphotos.com/3226333/4843/i/450/depositphotos_48430357-stock-photo-cocktail-at-bar.jpg" alt="Licorera 4">
      </div>
      <button class="prev">&#10094;</button>
      <button class="next">&#10095;</button>
    </div>

  </div>

  <script>
    const track = document.querySelector('.carrusel-track');
    const images = document.querySelectorAll('.carrusel img');
    const prevBtn = document.querySelector('.prev');
    const nextBtn = document.querySelector('.next');

    let index = 0;
    function showSlide(i) {
      index = (i + images.length) % images.length;
      track.style.transform = `translateX(${-index * 100}%)`;
    }
    nextBtn.addEventListener('click', () => showSlide(index + 1));
    prevBtn.addEventListener('click', () => showSlide(index - 1));
    setInterval(() => { showSlide(index + 1); }, 6000);

    // ✅ Redirigir según el rol
    document.getElementById('loginForm').addEventListener('submit', function(e) {
      e.preventDefault();
      const rol = document.getElementById('rol').value;

      if (rol === 'admin') {
        window.location.href = "{{ route('inicio') }}";
      } else if (rol === 'usuario') {
        window.location.href = "{{ route('index') }}";
      } else if (rol === 'gerente') {   // ✅ Aquí añadimos el rol gerente
        window.location.href = "{{ route('gerente') }}";
      } else {
        alert("Por favor selecciona un rol válido.");
      }
    });
  </script>

</body>
</html>

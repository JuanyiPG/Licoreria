<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Registro | Angelos V.I.P</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">

  <!-- Estilo inline tipo Spotify -->
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Montserrat', sans-serif;
    }

    body {
      background-color: #000; /* Fondo negro */
      color: #fff; /* Texto blanco */
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      padding: 20px;
    }

    .register-box {
      width: 100%;
      max-width: 400px;
    }

    h2 {
      font-size: 28px;
      font-weight: 700;
      margin-bottom: 20px;
      text-align: center;
      color: #1DB954; /* Verde Spotify */
    }

    form {
      display: flex;
      flex-direction: column;
      gap: 15px;
    }

    label {
      font-size: 14px;
      font-weight: 600;
      color: #b3b3b3; /* Gris claro */
      margin-bottom: 5px;
    }

    input, select {
      padding: 12px;
      border: none;
      border-radius: 25px;
      outline: none;
      background-color: #121212;
      color: #fff;
      font-size: 14px;
      transition: all 0.3s ease;
    }

    input:focus, select:focus {
      border: 1px solid #1DB954;
      background-color: #181818;
    }

    .btn-register {
      background-color: #1DB954;
      border: none;
      border-radius: 25px;
      padding: 14px;
      font-size: 16px;
      font-weight: 700;
      color: #fff;
      cursor: pointer;
      transition: background 0.3s ease;
      margin-top: 10px;
    }

    .btn-register:hover {
      background-color: #1ed760;
    }

    .login-link {
      display: block;
      text-align: center;
      margin-top: 15px;
      color: #b3b3b3;
      font-size: 14px;
      text-decoration: none;
      transition: color 0.3s ease;
    }

    .login-link:hover {
      color: #fff;
      text-decoration: underline;
    }

    .error-message {
      color: #ff4c4c;
      font-size: 13px;
      margin-top: -10px;
      margin-bottom: 10px;
    }
  </style>
</head>
<body>

  <div class="register-box">
    <h2>Registro Angelos V.I.P</h2>
    <form id="registroForm">
      <label for="fecha">Fecha de nacimiento</label>
      <input type="date" id="fecha" required>
      <div id="fechaError" class="error-message"></div>

      <label for="direccion">Dirección</label>
      <input type="text" id="direccion" name="direccion" required>

      <!-- Número de teléfono -->
      <label for="telefono">Número de Teléfono</label>
      <input type="number" id="telefono" name="telefono" pattern="[0-9]{10}" maxlength="10" required placeholder="Ej: 3001234567">

      <!-- Cédula / Tarjeta de Identidad -->
      <label for="cedula">Cédula / Tarjeta de Identidad</label>
      <input type="number" id="cedula" name="cedula" pattern="[0-9]{10}" maxlength="10" required placeholder="Ej: 1234567890">

      <!-- Género -->
      <label for="genero">Género</label>
      <select id="genero" name="genero" required>
        <option value="">Seleccione</option>
        <option value="masculino">Masculino</option>
        <option value="femenino">Femenino</option>
        <option value="otro">Otro</option>
      </select>

      <label for="usuario">Nombre de Usuario</label>
      <input type="text" id="usuario" required placeholder="Ej: angelos_vip">

      <label for="email">Correo electrónico</label>
      <input type="email" id="email" required placeholder="ejemplo@correo.com">

      <label for="password">Contraseña</label>
      <input type="password" id="password" required placeholder="Tu contraseña segura">
      <div id="passwordError" class="error-message"></div>

      <button type="submit" class="btn-register">Registrarme</button>
      <a href="{{ route('login') }}" class="login-link">¿Ya tienes cuenta? Inicia sesión</a>

    </form>
  </div>

  <script>
    function registrarUsuario(event) {
      event.preventDefault();

      const fecha = document.getElementById('fecha').value;
      const password = document.getElementById('password').value;
      const fechaError = document.getElementById('fechaError');
      const passwordError = document.getElementById('passwordError');

      fechaError.textContent = '';
      passwordError.textContent = '';

      // Validar edad
      const hoy = new Date();
      const nacimiento = new Date(fecha);
      const edad = hoy.getFullYear() - nacimiento.getFullYear();
      const mes = hoy.getMonth() - nacimiento.getMonth();
      const dia = hoy.getDate() - nacimiento.getDate();
      if (mes < 0 || (mes === 0 && dia < 0)) {
        edad--;
      }

      if (edad < 18) {
        fechaError.textContent = 'Debes tener al menos 18 años para registrarte.';
        return;
      }

      // Validar contraseña (mínimo 8 caracteres, al menos una mayúscula y un número)
      const regexPassword = /^(?=.*[A-Z])(?=.*\d).{8,}$/;
      if (!regexPassword.test(password)) {
        passwordError.textContent = 'La contraseña debe tener al menos 8 caracteres, una letra mayúscula y un número.';
        return;
      }

      // Si pasa todas las validaciones, enviar datos o mostrar mensaje de éxito
      alert('¡Registro exitoso!');
      document.getElementById('registroForm').reset();
    }

    document.getElementById('registroForm').addEventListener('submit', registrarUsuario);
  </script>
</body>
</html>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Catálogo - Angelos V.I.P</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

  <style>
    body {
      font-family: 'Montserrat', sans-serif;
      background-color: #fff;
      color: #111;
      margin: 0;
      padding: 0;
    }

    /* NAVBAR */
    .navbar {
      background-color: #000 !important;
      padding: 15px 30px;
    }

    .navbar-brand img {
      height: 70px;
    }

    .nav-link {
      color: #fff !important;
      font-weight: 500;
      margin-left: 20px;
      transition: color 0.3s;
    }

    .nav-link:hover {
      color: #FF63F9 !important;
    }

    /* CATALOGO */
    .catalogo {
      padding: 60px 0;
    }

    .catalogo h2 {
      text-align: center;
      font-weight: 700;
      margin-bottom: 40px;
      color: #000;
    }

    .producto-card {
      background: #f9f9f9;
      border-radius: 12px;
      overflow: hidden;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
      border: 1px solid #eee;
    }

    .producto-card:hover {
      transform: translateY(-6px);
      box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.15);
    }

    .producto-card img {
      width: 100%;
      height: 250px;
      object-fit: cover;
    }

    .producto-info {
      padding: 20px;
      text-align: center;
    }

    .producto-info h5 {
      font-weight: 600;
      margin-bottom: 10px;
      color: #000;
    }

    .producto-info p {
      margin: 0;
      font-size: 14px;
      color: #555;
    }

    .producto-precio {
      font-size: 18px;
      font-weight: 700;
      color: #FF63F9;
      margin: 10px 0;
    }

    .btn-agregar {
      background-color: #FF63F9;
      color: #fff;
      border-radius: 25px;
      padding: 8px 20px;
      font-weight: 600;
      transition: background 0.3s;
      border: none;
    }

    .btn-agregar:hover {
      background-color: #d052c9;
    }

    /* FOOTER */
    footer {
      background-color: #000;
      text-align: center;
      padding: 20px;
      font-size: 14px;
      color: #aaa;
      margin-top: 40px;
    }

    /* Carrito */
    .cart-icon {
      font-size: 24px;
      color: #fff;
      cursor: pointer;
      position: relative;
    }

    .cart-count {
      background: #FF63F9;
      color: #fff;
      font-size: 12px;
      font-weight: bold;
      border-radius: 50%;
      padding: 2px 6px;
      position: absolute;
      top: -5px;
      right: -10px;
    }

    .modal-header {
      border-bottom: none;
    }

    .modal-footer {
      border-top: none;
    }
  </style>
</head>
<body>

  <!-- NAVBAR -->
  <nav class="navbar navbar-expand-lg">
    <div class="container">
      <a class="navbar-brand" href="{{ route('index') }}">
        <img src="https://angelos.com.co/wp-content/uploads/2025/04/Logo.png" alt="Logo"> Angelos V.I.P
      </a>
      <div class="ms-auto">
        <i class="bi bi-cart cart-icon" data-bs-toggle="modal" data-bs-target="#cartModal">
          <span class="cart-count" id="cart-count">0</span>
        </i>
      </div>
    </div>
  </nav>

  <!-- CATALOGO -->
  <section id="catalogo" class="catalogo">
    <div class="container">
      <h2>Nuestro Catálogo</h2>
      <div class="row g-4" id="productos-container">
        <!-- Los productos se cargarán con JS -->
      </div>
    </div>
  </section>

  <!-- FOOTER -->
  <footer>
    &copy; 2025 Angelos V.I.P. Todos los derechos reservados.
  </footer>

  <!-- MODAL CARRITO -->
  <div class="modal fade" id="cartModal" tabindex="-1">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">🛒 Tu Carrito</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <div class="modal-body" id="cart-items">
          <p>Tu carrito está vacío.</p>
        </div>
        <div class="modal-footer">
          <h5 class="me-auto">Total: <span id="cart-total">$0</span></h5>
          <button class="btn btn-success" onclick="finalizarCompra()">Finalizar compra</button>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

  <script>
    // Lista de productos
    const productos = [
      {id:1, nombre:"Whisky Johnnie Walker", desc:"Etiqueta Negra 750ml", precio:180000, img:"https://dislicoresqa.vtexassets.com/arquivos/ids/369339/2340-JW-BLACK-LABEL-0.7L_3.png?v=638894829431100000"},
      {id:2, nombre:"Vino Tinto Casillero", desc:"Cabernet Sauvignon", precio:70000, img:"https://http2.mlstatic.com/D_NQ_NP_804433-MCO72271699479_102023-O.webp"},
      {id:3, nombre:"Tequila Don Julio", desc:"Reposado 750ml", precio:220000, img:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ2Bn7lkwU8lyybP1ev8RhLtkoy3rW9goj7Xg&s"},
      {id:4, nombre:"Cerveza Corona", desc:"Six Pack 355ml", precio:35000, img:"https://eurosuper.vtexassets.com/arquivos/ids/173067/7501064191398.png?v=638316182087670000"},
      {id:5, nombre:"Ron Medellín Añejo", desc:"750ml", precio:65000, img:"https://dislicoresqa.vtexassets.com/arquivos/ids/344732/220076-Ron-Medellin-Anejo-3-Media-750ml.png?v=638188587195300000"},
      {id:6, nombre:"Vodka Absolut", desc:"Botella 1L", precio:95000, img:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLiqutTZY2K4ChNSs103wonXWBpHMyU_fxEw&s"},
      {id:7, nombre:"Ginebra Tanqueray", desc:"London Dry 700ml", precio:110000, img:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtV96UlwfYOH-ZP-8h0ML9XhHn_Y_8eqkHLg&s"},
      {id:8, nombre:"Whisky Buchanan's", desc:"12 años 750ml", precio:210000, img:"https://supertiendascomunal.com/8528-large_default/whisky-buchanans-12-anos-750-ml.jpg"},
      {id:9, nombre:"Cerveza Heineken", desc:"Six Pack", precio:34000, img:"https://dislicoresqa.vtexassets.com/arquivos/ids/366241-300-300?v=638484075126200000&width=300&height=300&aspect=true"},
      {id:10, nombre:"Champagne Moët", desc:"750ml", precio:480000, img:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIJypYV2mKjMsKhwIsKYQCp9cTKvbQFmBbzQ&s"},
      {id:11, nombre:"Tequila José Cuervo", desc:"Especial 750ml", precio:89000, img:"https://dislicoresqa.vtexassets.com/arquivos/ids/369768/137020-TEQUILA-JOSE-CUERVO-ESPECIAL-REPOSADO750.png?v=638696969162970000"},
      {id:12, nombre:"Whisky Chivas Regal", desc:"12 años 750ml", precio:175000, img:"https://eliasacostaycia.com.co/wp-content/uploads/2020/09/WHISKY-CHIVAS-REGAL-12-AN%CC%83OS-X-750-ML.jpg"},
      {id:13, nombre:"Vino Blanco Gato Negro", desc:"Sauvignon Blanc", precio:45000, img:"https://lacaretalicores.com/cdn/shop/products/unnamed_20.jpg?v=1623274989"},
      {id:14, nombre:"Ron Zacapa", desc:"23 años 750ml", precio:250000, img:"https://www.merkadea.co/web/upload/imagen/producto/producto_312_1901454980_1117641886.png"},
      {id:15, nombre:"Cerveza Poker", desc:"Six Pack", precio:25000, img:"https://flashgoapp.com/wp-content/uploads/2025/04/15.jpg"},
      {id:16, nombre:"Vodka Smirnoff", desc:"Botella 750ml", precio:60000, img:"https://dislicoresqa.vtexassets.com/arquivos/ids/311617-800-1733?v=638893179267600000&width=800&height=1733&aspect=true"},
    ];

    const productosContainer = document.getElementById("productos-container");
    let carrito = JSON.parse(localStorage.getItem("carrito")) || [];

    function guardarCarrito() {
      localStorage.setItem("carrito", JSON.stringify(carrito));
    }

    function agregarAlCarrito(id) {
      const producto = productos.find(p => p.id === id);
      const item = carrito.find(p => p.id === id);
      if (item) {
        item.cantidad++;
      } else {
        carrito.push({...producto, cantidad:1});
      }
      actualizarCarrito();
      guardarCarrito();
    }

    function actualizarCarrito() {
      const cartItems = document.getElementById("cart-items");
      const cartCount = document.getElementById("cart-count");
      const cartTotal = document.getElementById("cart-total");

      if (carrito.length === 0) {
        cartItems.innerHTML = "<p>Tu carrito está vacío.</p>";
        cartCount.textContent = 0;
        cartTotal.textContent = "$0";
        return;
      }

      cartItems.innerHTML = carrito.map(item => `
        <div class="d-flex justify-content-between align-items-center mb-2">
          <div>
            <strong>${item.nombre}</strong> (x${item.cantidad})
          </div>
          <div>$${(item.precio * item.cantidad).toLocaleString()}</div>
        </div>
      `).join("");

      const total = carrito.reduce((sum, item) => sum + item.precio * item.cantidad, 0);
      cartCount.textContent = carrito.reduce((sum, item) => sum + item.cantidad, 0);
      cartTotal.textContent = "$" + total.toLocaleString();
    }

    function finalizarCompra() {
      if (carrito.length === 0) {
        alert("Tu carrito está vacío.");
        return;
      }

      // Simulación de compra exitosa
      setTimeout(() => {
        const order_id = Math.floor(Math.random() * 1000000);
        alert("Compra registrada con éxito. ID Pedido: " + order_id);
        carrito = [];
        actualizarCarrito();
        guardarCarrito();
      }, 500);
    }

    // Cargar productos en el DOM
    productos.forEach(p => {
      productosContainer.innerHTML += `
        <div class="col-md-3">
          <div class="producto-card">
            <img src="${p.img}" alt="${p.nombre}">
            <div class="producto-info">
              <h5>${p.nombre}</h5>
              <p>${p.desc}</p>
              <div class="producto-precio">$${p.precio.toLocaleString()}</div>
              <button class="btn-agregar" onclick="agregarAlCarrito(${p.id})">Agregar al carrito</button>
            </div>
          </div>
        </div>
      `;
    });

    actualizarCarrito();
  </script>
</body>
</html>

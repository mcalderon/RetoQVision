# language: es
Característica: Validación del Cálculo del carrito de compras
  Como cliente de la tienda Toolshop
  Quiero agregar diferentes cantidades de productos al carrito
  Para comprar las herramientas que necesito

  Escenario: Agregar un producto al carrito y validar sus valores
    Dado que Miguel está en la tienda Toolshop
    Cuando agrega 2 unidades del producto "Combination Pliers" al carrito
    Entonces el carrito debería mostrar el producto con su precio unitario, cantidad y total correctos
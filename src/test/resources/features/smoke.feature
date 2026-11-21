# language: es
Característica: Verificar la conexión del framework
  Como usuario de la tienda Toolshop
  Quiero abrir la página principal
  Para confirmar que el framework está bien configurado

  @smoke
  Escenario: Abrir la página principal de Toolshop
    Dado que Miguel abre la página de Toolshop
    Entonces debería ver el título "Practice Software Testing"
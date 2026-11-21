package com.qvision.models;

import java.math.BigDecimal;

public record Producto(String nombre, BigDecimal precioUnitario, int cantidad) {
    // El total de la línea: precio unitario × cantidad
    public BigDecimal total() {
        return precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }
}

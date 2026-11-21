package com.qvision.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {

    private ProductPage(){}

    public static final Target NOMBRE_PRODUCTO = Target.the("Nombre del producto")
            .located(By.cssSelector("[data-test='product-name']"));

    public static final Target PRECIO_UNIDAD = Target.the("Precio de unidad")
            .located(By.cssSelector("[data-test='unit-price']"));

    public static final Target BTN_ANADIR_CARRITO = Target.the("Botón añadir al carrito")
            .located(By.cssSelector("[data-test='add-to-cart']"));

    public static final Target CANTIDAD_PRODUCTO = Target.the("Cantidad del producto")
            .located(By.cssSelector("[data-test='quantity']"));

    public static final Target BTN_AGREGAR_UNIDAD = Target.the("Botón agregar unidad")
            .located(By.cssSelector("[data-test='increase-quantity']"));

    public static final Target BTN_REDUCIR_UNIDAD = Target.the("Botón reducir unidad")
            .located(By.cssSelector("[data-test='decrease-quantity']"));

}

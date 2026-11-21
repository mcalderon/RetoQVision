package com.qvision.tasks;

import com.qvision.models.Producto;
import com.qvision.userinterfaces.HomePage;
import com.qvision.userinterfaces.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.math.BigDecimal;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarAlCarrito implements Task {

    private final int cantidad;

    public AgregarAlCarrito (int cantidad) {
        this.cantidad = cantidad;
    }

    // "Metodo fábrica": hace que la Task se lea como una frase
    public static AgregarAlCarrito laCantidadDe (int cantidad) {
        return Tasks.instrumented(AgregarAlCarrito.class, cantidad);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        // 1. Abrir el producto y esperar a que cargue su detalle
        actor.attemptsTo(
                Click.on(HomePage.PRODUCT),
                WaitUntil.the(ProductPage.PRECIO_UNIDAD, isVisible()).forNoMoreThan(10).seconds()
        );

        // 2. Capturar nombre y precio AL MOMENTO de agregarlo (lo pide el reto)
        String nombre = Text.of(ProductPage.NOMBRE_PRODUCTO).answeredBy(actor);
        String precioTexto = Text.of(ProductPage.PRECIO_UNIDAD).answeredBy(actor);
        BigDecimal precio = new BigDecimal(precioTexto.replaceAll("[^0-9.]", ""));

        // 3. El actor RECUERDA el producto para validarlo después en el carrito
        actor.remember("producto", new Producto(nombre, precio, cantidad));

        // 4. Poner la cantidad y agregar al carrito
        actor.attemptsTo(
                Enter.theValue(String.valueOf(cantidad)).into(ProductPage.CANTIDAD_PRODUCTO),
                Click.on(ProductPage.BTN_ANADIR_CARRITO)
        );

    }
}

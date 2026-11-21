package com.qvision.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class SmokeStepDefinitions {

    // Se ejecuta ANTES de cada escenario: prepara el "teatro" con actores que pueden usar navegador
    @Before
    public void prepararEscenario() {

        OnStage.setTheStage(new OnlineCast());
    }

    // {word} captura una palabra del Gherkin → aquí será "Miguel"
    @Dado("que {word} abre la página de Toolshop")
    public void abreLaPagina(String nombreActor) {
        theActorCalled(nombreActor).attemptsTo(
                Open.relativeUrl("/")   // abre base.url (definida en serenity.conf) + "/"
        );
    }

    // {string} captura el texto entre comillas → "Practice Software Testing"
    @Entonces("debería ver el título {string}")
    public void deberiaVerElTitulo(String tituloEsperado) {
        theActorInTheSpotlight().should(
                seeThat(TheWebPage.title(), containsString(tituloEsperado))
        );
    }

}

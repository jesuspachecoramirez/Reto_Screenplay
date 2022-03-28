package co.com.sofka.questions.common;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ResponseCode implements Question {
    private static final Logger LOGGER = Logger.getLogger(ResponseCode.class);


    public static void checkResponseOk(Actor actor) {
        actor.should(
                seeThatResponse("El código de respuesta debe ser: " + HttpStatus.SC_OK,
                        Response -> Response.statusCode(HttpStatus.SC_OK)
                )
        );

    }
    public static void PrintResponse(Actor actor) {
        LOGGER.info("Respuesta a la peticion :");
        LastResponse.received().answeredBy(actor).prettyPrint();
    }




    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}

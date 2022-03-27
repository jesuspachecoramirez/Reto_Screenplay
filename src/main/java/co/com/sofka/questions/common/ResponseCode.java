package co.com.sofka.questions.common;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ResponseCode implements Question {
    private Actor actor;

    public static Question<Object> was(){
        return new ResponseCode();
    }

    public void ResponseState(){
        actor.should(
                seeThatResponse("El codigo de respuesta debe ser" + HttpStatus.SC_OK,
                        validatableResponse -> validatableResponse.statusCode(HttpStatus.SC_OK))
        );

    }


    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }
}

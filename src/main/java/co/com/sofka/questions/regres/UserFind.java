package co.com.sofka.questions.regres;

import co.com.sofka.Models.regres.Data;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class UserFind implements Question {
    @Override
    public Data answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Data.class);
    }
}

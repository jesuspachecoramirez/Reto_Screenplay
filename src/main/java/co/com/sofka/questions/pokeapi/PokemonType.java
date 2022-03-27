package co.com.sofka.questions.pokeapi;

import co.com.sofka.Models.pokeapi.PokemonTypes;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PokemonType implements Question {

    @Override
    public PokemonTypes answeredBy(Actor actor) {

        return SerenityRest.lastResponse().as(PokemonTypes.class);
    }
}

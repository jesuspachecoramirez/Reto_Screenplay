package co.com.sofka.questions.pokeapi;

import co.com.sofka.Models.pokeapi.DoubleDamageFrom;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PokemonType2 implements Question {

    public static PokemonType pokemonType2() {
        return new PokemonType();
    }

    @Override
    public DoubleDamageFrom answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(DoubleDamageFrom.class);
    }
}

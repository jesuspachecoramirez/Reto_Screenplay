package co.com.sofka.Stepdefinition.pokeApi;


import co.com.sofka.Models.pokeapi.PokemonTypes;
import co.com.sofka.Stepdefinition.common.ServiceSetup;
import co.com.sofka.questions.pokeapi.PokemonType;
import co.com.sofka.tasks.pokeapi.GetTypeClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TypeClassStepDefinition extends ServiceSetup {

    private static final String POKEAPI_BASE_URI = "https://pokeapi.co";
    private static final String RESOURCE ="/api/v2/type/";
    private static final Logger LOGGER = Logger.getLogger(TypeClassStepDefinition.class);
    private final Actor actor = new Actor("Jugador");



     @Given("El jugador se encuentra dentro de la pagina adecuada para realizar la consulta")
      public void ElJugadorSeEncuentraDentroDeLaPaginaAdecuadaParaRealizarLaConsulta(){

         actor.can(CallAnApi.at(POKEAPI_BASE_URI));


     }

    @When("El jugador consulta el tipo {string},para conocer un tipo contra cual es fuerte")
    public void elJugadorConsultaElTipoParaConocerUnTipoContraCualEsFuerte(String NumOrName) {

         actor.attemptsTo(
                        GetTypeClass.getTypeClass().usingTheUserType(RESOURCE),
                 GetTypeClass.searchbyusertype(NumOrName)
         );


    }


    @Then("El jugador recibe el tipo contra cual es fuerte {string}")
    public void elJugadorRecibeElTipoContraCualEsFuerte(String type) {
        LastResponse.received().answeredBy(actor).statusCode();

        PokemonTypes pokemontype= new PokemonType().answeredBy(actor).getDamageRelations().getDoubleDamageTo()
                .stream().filter(t -> t.getName().equals(type)).findFirst().get();

        actor.should(
               seeThat("no es nulo",actor1 -> pokemontype, notNullValue())
        );

        actor.should(
                seeThat("El tipo contra cual es fuerte",actor1 -> pokemontype.getName(),equalTo(type))
        );
        LOGGER.info(pokemontype);


    }




    @Given("El jugador desea realizar otro tipo de consulta")
    public void elJugadorDeseaRealizarOtroTipoDeConsulta() {

         actor.can(CallAnApi.at(POKEAPI_BASE_URI));
    }


    @When("El jugador consulta el tipo {string}, para conocer un tipo contra cual es debil")
    public void elJugadorConsultaElTipoParaConocerUnTipoContraCualEsDebil(String NumOrName) {
        actor.attemptsTo(
                GetTypeClass.getTypeClass().usingTheUserType(RESOURCE),
                GetTypeClass.searchbyusertype(NumOrName)
        );
    }


    @Then("El jugador recibe el tipo contra cual es debil {string}")
    public void elJugadorRecibeElTipoContraCualEsDebil(String type) {
        LastResponse.received().answeredBy(actor).statusCode();

        PokemonTypes pokemontype= new PokemonType().answeredBy(actor).getDamageRelations().getDoubleDamageTo()
                .stream().filter(t -> t.getName().equals(type)).findFirst().get();

        actor.should(
                seeThat("no es nulo",actor1 -> pokemontype, notNullValue())
        );

        actor.should(
                seeThat("El tipo contra cual es fuerte",actor1 -> pokemontype.getName(),equalTo(type))
        );
        LOGGER.info(pokemontype);

    }

}




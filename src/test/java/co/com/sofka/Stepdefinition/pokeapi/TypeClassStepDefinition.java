package co.com.sofka.Stepdefinition.pokeapi;


import co.com.sofka.Models.pokeapi.DoubleDamageFrom;
import co.com.sofka.Models.pokeapi.PokemonTypes;
import co.com.sofka.Stepdefinition.common.ServiceSetup;
import co.com.sofka.questions.pokeapi.PokemonType;
import co.com.sofka.questions.pokeapi.PokemonType2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;

import java.util.Objects;

import static co.com.sofka.questions.common.ResponseCode.PrintResponse;
import static co.com.sofka.questions.common.ResponseCode.checkResponseOk;
import static co.com.sofka.tasks.pokeapi.GetTypeClass.searchbyusertype;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class TypeClassStepDefinition extends ServiceSetup {


    private static final Logger LOGGER = Logger.getLogger(TypeClassStepDefinition.class);
    private final Actor jugador = new Actor("Jugador");



     @Given("El jugador se encuentra dentro de la pagina adecuada para realizar la consulta")
      public void ElJugadorSeEncuentraDentroDeLaPaginaAdecuadaParaRealizarLaConsulta(){
         try{
             generalSetUp();
             jugador.can(CallAnApi.at(POKEAPI_BASE_URI));

         }catch (Exception e){
             LOGGER.error("Error al ingresar a la pagina", e);
         }

     }
    @When("El jugador consulta el tipo {string},para conocer un tipo contra cual es fuerte")
    public void elJugadorConsultaElTipoParaConocerUnTipoContraCualEsFuerte(String NumOrName) {
         try {
             jugador.attemptsTo(
                     searchbyusertype(NumOrName)
             );

         }catch (Exception e){
             LOGGER.error("Error recibiendo el tipo", e);
         }

    }

    @Then("El jugador recibe el tipo contra cual es fuerte {string}")
    public void elJugadorRecibeElTipoContraCualEsFuerte(String type) {
        PrintResponse(jugador);
        checkResponseOk(jugador);

        PokemonTypes pokemonTypes =PokemonType.pokemonType().answeredBy(jugador)
                .getDamageRelations().getDoubleDamageTo().stream()
                .filter(doubleDamageTo -> doubleDamageTo.getName().equals(type)).findFirst().orElse(null);


        jugador.should(
                seeThat("la busqueda del tipo es no nula", search -> pokemonTypes, CoreMatchers.notNullValue())
        );

        jugador.should(
                seeThat("el nombre del tipo si coincide",
                        search -> Objects.requireNonNull(pokemonTypes).getName(), CoreMatchers.equalTo(type))

        );

    }


    @Given("El jugador desea realizar otro tipo de consulta")
    public void elJugadorDeseaRealizarOtroTipoDeConsulta() {
        try{
            generalSetUp();
            jugador.can(CallAnApi.at(POKEAPI_BASE_URI));

        }catch (Exception e){
            LOGGER.error("Error al ingresar a la pagina", e);
        }
    }


    @When("El jugador consulta el tipo {string}, para conocer un tipo contra cual es debil")
    public void elJugadorConsultaElTipoParaConocerUnTipoContraCualEsDebil(String NumOrName) {
        try {
            jugador.attemptsTo(
                    searchbyusertype(NumOrName)
            );

        }catch (Exception e){
            LOGGER.error("Error recibiendo el tipo", e);
        }
    }


    @Then("El jugador recibe el tipo contra cual es debil {string}")
    public void elJugadorRecibeElTipoContraCualEsDebil(String type) {
        PrintResponse(jugador);
        checkResponseOk(jugador);
        DoubleDamageFrom pokemonTypes2 = PokemonType2.pokemonType2().answeredBy(jugador)
                .getDamageRelations().getDoubleDamageFrom().stream()
                .filter(doubleDamageFrom -> doubleDamageFrom.getName().equals(type)).findFirst().orElse(null);


        jugador.should(
                seeThat("la busqueda del tipo es no nula", search -> pokemonTypes2, CoreMatchers.notNullValue())
        );

        jugador.should(
                seeThat("el nombre del tipo si coincide",
                        search -> Objects.requireNonNull(pokemonTypes2).getName(), CoreMatchers.equalTo(type))

        );

    }

}




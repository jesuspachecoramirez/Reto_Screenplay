package co.com.sofka.Stepdefinition.regres;

import co.com.sofka.Models.regres.UpdateUserInfo;
import co.com.sofka.Stepdefinition.pokeApi.TypeClassStepDefinition;
import co.com.sofka.questions.regres.UserFind;
import co.com.sofka.tasks.regress.ListUser;
import co.com.sofka.tasks.regress.UpdateUser;
import co.com.sofka.tasks.regress.UserName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.log4j.Logger;



public class UserRegresStepDefinition {

    private static final String REQRES_BASE_URI = "https://reqres.in";
    private static final String RESOURCE ="/api/users/2";
    private static final Logger LOGGER = Logger.getLogger(TypeClassStepDefinition.class);
    private final Actor actor = new Actor("usuario");


    @Given("se necesita verificar la existencia del usuario con id = <numId>")
    public void seNecesitaVerificarLaExistenciaDelUsuarioConIdNumId() {
        actor.can(CallAnApi.at(REQRES_BASE_URI));
        actor.attemptsTo(
                ListUser.searchId(2)
        );


    }

    @When("el cliente recibe la informacion solicitada si se encuentra")
    public void elClienteRecibeLaInformacionSolicitadaSiSeEncuentra() {
        LastResponse.received().answeredBy(actor).statusCode();

        String data = new UserFind().answeredBy(actor).toString();


    }

    @Given("un cliente previamente registrado desea actualizar los datos")
    public void unClientePreviamenteRegistradoDeseaActualizarLosDatos() {
        actor.can(CallAnApi.at(REQRES_BASE_URI));

    }

    @When("cliente ingresa el nombre {string}, para actualizar")
    public void clienteIngresaElNombreParaActualizar(String userName) {

        actor.attemptsTo(
                UserName.whitName(userName)
        );

    }

    @Then("cliente ingresa los datos a actualizar")
    public void clienteIngresaLosDatosAActualizar() {
        UpdateUserInfo updateUserInfo = new UpdateUserInfo();
        updateUserInfo.setName("morpheus");
        updateUserInfo.setJob("zion resident");
        updateUserInfo.setUpdatedAt("2022-03-27T19:20:15.130Z");
        actor.attemptsTo(
                UpdateUser.whitInfo(updateUserInfo));

    }



}

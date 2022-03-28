package co.com.sofka.Stepdefinition.regres;

import co.com.sofka.Models.regres.UpdateUserInfo;
import co.com.sofka.Stepdefinition.common.ServiceSetup;
import co.com.sofka.Stepdefinition.pokeapi.TypeClassStepDefinition;
import co.com.sofka.questions.regres.UserFind;
import co.com.sofka.tasks.regress.UpdateUser;
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
import static co.com.sofka.tasks.regress.ListUser.searchId;
import static co.com.sofka.tasks.regress.UserName.whitName;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class UserRegresStepDefinition extends ServiceSetup {


    private static final Logger LOGGER = Logger.getLogger(TypeClassStepDefinition.class);
    private final Actor usuario = new Actor("usuario");


    @Given("se necesita verificar la existencia del usuario con id = {int}")
    public void seNecesitaVerificarLaExistenciaDelUsuarioConId(int userid) {
        try{
            generalSetUp();
            usuario.can(CallAnApi.at(REQRES_BASE_URI));
            usuario.attemptsTo(
                    searchId(userid)
            );

        }catch (Exception e){
            LOGGER.error("Error al ingresar a la pagina", e);
            LOGGER.error("Error encontrando el usuario", e);

        }
    }

    @When("el cliente recibe la informacion solicitada si se encuentra")
    public void elClienteRecibeLaInformacionSolicitadaSiSeEncuentra() {
        PrintResponse(usuario);
        checkResponseOk(usuario);

        String data = UserFind.userFind().answeredBy(usuario).toString();
        usuario.should(
                seeThat("la busqueda del usuario es no nula", search -> data, CoreMatchers.notNullValue())
        );

        usuario.should(
                seeThat("el id del usuario si coincide",
                        search -> Objects.requireNonNull(data).toCharArray().toString(), CoreMatchers.notNullValue())

        );



    }

    @Given("un cliente previamente registrado desea actualizar los datos")
    public void unClientePreviamenteRegistradoDeseaActualizarLosDatos() {
        try{
            generalSetUp();
            usuario.can(CallAnApi.at(REQRES_BASE_URI));

        }catch (Exception e){
            LOGGER.error("Error al ingresar a la pagina", e);
        }


    }

    @When("cliente ingresa el nombre {string}, para actualizar")
    public void clienteIngresaElNombreParaActualizar(String userName) {
       try{
           usuario.attemptsTo(
                   whitName(userName)
           );

       }catch (Exception e){
           LOGGER.error("Nombre no encontrado", e);
       }



    }

    @Then("cliente ingresa los datos a actualizar")
    public void clienteIngresaLosDatosAActualizar() {
        UpdateUserInfo updateUserInfo = new UpdateUserInfo();
        updateUserInfo.setName("morpheus");
        updateUserInfo.setJob("zion resident");
        updateUserInfo.setUpdatedAt("2022-03-27T19:20:15.130Z");
        usuario.attemptsTo(
                UpdateUser.updateUserbyName(updateUserInfo));

    }



}

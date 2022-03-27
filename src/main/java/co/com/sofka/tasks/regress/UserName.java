package co.com.sofka.tasks.regress;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UserName implements Task {

    private final String username;


    public UserName(String username) {
        this.username = username;
    }

    public static Performable whitName(String username){

        return instrumented(UserName.class, username);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/api/users/2")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
                        .with(search -> search.pathParams("userName", username) )
                        .with(requestSpecification -> requestSpecification.body(username))

        );
    }
}

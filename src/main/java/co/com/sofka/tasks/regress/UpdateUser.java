package co.com.sofka.tasks.regress;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private final Object userinfo;


    public UpdateUser(Object userinfo) {
        this.userinfo = userinfo;
    }

    public static Performable whitInfo(Object userinfo){

        return instrumented(UpdateUser.class, userinfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("/api/users/2")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
                        .with(update -> update.body(userinfo) )
        );

    }
}

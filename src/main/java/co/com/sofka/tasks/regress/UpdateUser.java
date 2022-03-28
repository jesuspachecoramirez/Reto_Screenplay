package co.com.sofka.tasks.regress;

import co.com.sofka.util.UserRegresKey;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.nio.charset.StandardCharsets;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUser implements Task {

    private final Object userinfo;


    public UpdateUser(Object userinfo) {
        this.userinfo = userinfo;
    }

    public static Performable updateUserbyName(Object userinfo){

        return instrumented(UpdateUser.class, userinfo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(UserRegresKey.UPDATE_USER_RESOURCE.getValue())
                        .with(requestSpecification -> requestSpecification
                                .pathParams("userName", userinfo)
                                .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8)))

        );

    }
}

package co.com.sofka.tasks.regress;

import co.com.sofka.util.UserRegresKey;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.nio.charset.StandardCharsets;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class ListUser implements Task {

    private final Integer userid;

    public ListUser(Integer userid) {
        this.userid = userid;
    }

    public static Performable searchId(Integer userid){
       return instrumented(ListUser.class, userid);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(UserRegresKey.UPDATE_USER_RESOURCE.getValue())
                        .with(searchid -> searchid.pathParams("userid", userid)
                                .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                        )
        );
    }
}

package co.com.sofka.tasks.regress;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
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
                Get.resource("/api/users/2")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
                        .with(search -> search.pathParams("numId", userid) )
                        .with(requestSpecification -> requestSpecification.body(userid))

        );
    }
}

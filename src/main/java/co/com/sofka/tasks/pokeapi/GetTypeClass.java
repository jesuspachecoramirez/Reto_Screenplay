package co.com.sofka.tasks.pokeapi;

import co.com.sofka.util.PokeApiKey;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.nio.charset.StandardCharsets;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetTypeClass implements Task {

    private String usertype;

    public GetTypeClass(String usertype) {
        this.usertype = usertype;
    }

   public static Performable searchbyusertype(String usertype){
       return instrumented(GetTypeClass.class, usertype);
   }

    @Override
    public <T extends Actor> void performAs(T actor) {
         actor.attemptsTo(
                Get.resource(PokeApiKey.TYPE_CLASS_RESOURCE.getValue())
                        .with(
                                searchtype -> searchtype.pathParam("NumOrName", usertype)
                                        .contentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
                        )




        );

    }




}

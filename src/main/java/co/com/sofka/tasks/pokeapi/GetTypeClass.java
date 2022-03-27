package co.com.sofka.tasks.pokeapi;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetTypeClass implements Task {

    private String usertype;

    public GetTypeClass usingTheUserType(String usertype){
        this.usertype = usertype;
        return this;

    }

   public static Performable searchbyusertype(String usertype){
       return instrumented(GetTypeClass.class, usertype);
   }

    @Override
    public <T extends Actor> void performAs(T actor) {
         actor.attemptsTo(
                Get.resource("/api/v2/type/"+ usertype)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
                        .with(search -> search.pathParams("NumOrName", usertype) )




        );

    }

    public static GetTypeClass getTypeClass(){
        return new GetTypeClass();
    }


}

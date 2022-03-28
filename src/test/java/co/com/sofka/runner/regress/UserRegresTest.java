package co.com.sofka.runner.regress;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/regres/UserRegres.feature"},
        glue = {"co.com.sofka.stepdefinition.regres"}
)
public class UserRegresTest {
}

package co.com.sofka.Stepdefinition.common;


import org.apache.log4j.PropertyConfigurator;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;

public class ServiceSetup {

    protected static final String POKEAPI_BASE_URI = "https://pokeapi.co";
    protected static final String REQRES_BASE_URI = "https://reqres.in";

    private static final String POKEAPI_BASE_PATH = "/api/v2";
    private static final String REQRES_BASE_PATH = "/api";


    protected void generalSetUp() {
        setUpLog4j2();
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}

package helpers;

import io.restassured.specification.RequestSpecification;
import properties.PropertyManager;

import static io.restassured.RestAssured.given;

public class LoginHelper {
    private static final String API_KEY = PropertyManager.getProperty(PropertyManager.Props.API_KEY);

    public static RequestSpecification getAccess() {
        return given().param("access_key", API_KEY);
    }
}

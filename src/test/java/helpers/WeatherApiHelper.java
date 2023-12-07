package helpers;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import models.WeatherstackResponseBody;
import properties.PropertyManager;
import utils.Logger;

public class WeatherApiHelper {

    private static final String BASE_URL = PropertyManager.getProperty(PropertyManager.Props.BASE_URL);

    public static Response getCurrentWeatherForCity(String city) {
        Logger.info("Sending request to get current weather for city: " + city);
        return LoginHelper.getAccess()
            .param("query", city)
            .get(BASE_URL);
    }

    public static void assertStatusCode(Response response, int statusCode) {
        Logger.info("Asserting status code: " + statusCode);
        response.then().statusCode(statusCode);
    }

    public static void assertWeatherType(WeatherstackResponseBody weatherstackResponseBody, String expectedType) {
        String actualType = weatherstackResponseBody.getRequest().getType();
        Logger.info("Verifying location type. Expected: {%s}, Actual: {%s}", expectedType, actualType);
        if (!actualType.equals(expectedType)) {
            Logger.error("Mismatch in location type. Expected: {%s}, Actual: {%s}", expectedType, actualType);
            Allure.addAttachment("Weather Type",
                "Mismatch in weather type. Expected: " + expectedType + ", Actual: " + actualType);
            throw new AssertionError("Mismatch in weather type. Expected: " + expectedType + ", Actual: " + actualType);
        } else Logger.info("Verifying success");
    }
}

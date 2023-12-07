package helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.errors.WeatherApiError;
import properties.PropertyManager;

import static io.restassured.RestAssured.given;

public class ApiErrorsHelper {
    private static final String BASE_URL = PropertyManager.getProperty(PropertyManager.Props.BASE_URL);
    private static final String HTTPS_URL = PropertyManager.getProperty(PropertyManager.Props.HTTPS_URL);
    private static final String INVALID_URL = PropertyManager.getProperty(PropertyManager.Props.INVALID_URL);
    private static final String API_KEY = PropertyManager.getProperty(PropertyManager.Props.API_KEY);
    private static final String WRONG_API_KEY = PropertyManager.getProperty(PropertyManager.Props.WRONG_API_KEY);

    private static RequestSpecification baseRequest(String apiKey) {
        return given().param("access_key", apiKey).log().all();
    }

    private static Response makeApiRequest(int errorCode, String city, String url, String apiKey) {
        return baseRequest(apiKey)
            .param("error_code", errorCode)
            .param("query", city)
            .when()
            .get(url)
            .then()
            .log().all()
            .extract()
            .response();
    }

    public static Response makeApiRequestWithWrongKeyError(int errorCode, String city) {
        return makeApiRequest(errorCode, city, BASE_URL, WRONG_API_KEY);
    }

    public static Response makeApiRequestWithWrongUrlError(int errorCode, String city) {
        return makeApiRequest(errorCode, city, HTTPS_URL, API_KEY);
    }

    public static Response makeApiRequestWithRequestFailedError(int errorCode, String city) {
        return makeApiRequest(errorCode, city, BASE_URL, API_KEY);
    }

    public static Response makeApiRequestWithApiFunctionError(int errorCode, String city) {
        return makeApiRequest(errorCode, city, INVALID_URL, API_KEY);
    }

    public static void assertRequestStatusCode(Response response, int expectedRequestStatusCode) {
        int actualStatusCode = response.getStatusCode();
        if (actualStatusCode != expectedRequestStatusCode) {
            throw new AssertionError("Mismatch in status code. Expected: " + expectedRequestStatusCode + ", Actual: " + actualStatusCode);
        }
    }

    public static WeatherApiError extractErrorFromResponse(Response response) throws JsonProcessingException {
        String responseBody = response.getBody().asString();
        return new ObjectMapper().readValue(responseBody, WeatherApiError.class);
    }
}

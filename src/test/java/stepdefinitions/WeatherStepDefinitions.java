package stepdefinitions;

import helpers.CurrentBodyHelper;
import helpers.LocationHelper;
import helpers.LoginHelper;
import helpers.WeatherApiHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.WeatherstackResponseBody;

public class WeatherStepDefinitions {
    private Response response;

    @Given("I have a Weatherstack API key")
    public void getAccessToWeatherstack() {
        LoginHelper.getAccess();
    }

    @When("I request current weather for city {string}")
    public void getWeatherForCity(String city) {
        response = WeatherApiHelper.getCurrentWeatherForCity(city);
        response.prettyPrint();
    }

    @Then("the response status code should be {int}")
    public void responseStatusCodeCheck(int statusCode) {
        WeatherApiHelper.assertStatusCode(response, statusCode);
    }

    @And("the type should be {string}")
    public void responseSTypeCheck(String expectedType) {
        WeatherApiHelper.assertWeatherType(response.as(WeatherstackResponseBody.class), expectedType);
    }

    @And("the country should be {string}")
    public void responseCountryCheck(String expectedCountry) {
        LocationHelper.assertWeatherCountry(response.as(WeatherstackResponseBody.class), expectedCountry);
    }

    @And("the temperature should be between {int} and {int}")
    public void responseTemperatureCheck(Integer minTemperature, Integer maxTemperature) {
        CurrentBodyHelper.assertWeatherTemperature(response.as(WeatherstackResponseBody.class),
            minTemperature, maxTemperature);
    }
}

package stepdefinitions;

import helpers.ApiErrorsHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.errors.ErrorDetails;
import models.errors.WeatherApiError;
import properties.PropertyManager;
import utils.Logger;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ApiErrorStepDefinitions {
    private static final String CITY = PropertyManager.getProperty(PropertyManager.Props.CITY);
    private static final String WRONG_CITY = PropertyManager.getProperty(PropertyManager.Props.WRONG_CITY);
    private static final String REQUEST_FAILED_INFO = PropertyManager.getProperty(PropertyManager.Props.REQUEST_FAILED_INFO);
    private static final String WRONG_URL_INFO = PropertyManager.getProperty(PropertyManager.Props.WRONG_URL_INFO);
    private static final String WRONG_API_KEY_INFO = PropertyManager.getProperty(PropertyManager.Props.WRONG_API_KEY_INFO);
    private static final String INVALID_API_FUNCTION_INFO = PropertyManager.getProperty(PropertyManager.Props.INVALID_API_FUNCTION_INFO);
    private static final String ERROR_TYPE_REQUEST_FAILED = PropertyManager.getProperty(PropertyManager.Props.ERROR_TYPE_REQUEST_FAILED);
    private static final String ERROR_TYPE_WRONG_URL = PropertyManager.getProperty(PropertyManager.Props.ERROR_TYPE_WRONG_URL);
    private static final String ERROR_TYPE_WRONG_API_KEY = PropertyManager.getProperty(PropertyManager.Props.ERROR_TYPE_WRONG_API_KEY);
    private static final String ERROR_TYPE_INVALID_API_FUNCTION = PropertyManager.getProperty(PropertyManager.Props.ERROR_TYPE_INVALID_API_FUNCTION);

    private Response apiResponse;

    @When("I make an API request with error request failed code and wrong city")
    public void makeApiRequestWithRequestFailedError() {
        apiResponse = ApiErrorsHelper.makeApiRequestWithRequestFailedError(615, WRONG_CITY);
    }

    @Then("the response should contain the correct error details due to wrong city")
    public void verifyRequestFailedErrorDetails() {
        ApiErrorsHelper.assertRequestStatusCode(apiResponse, 200);
        verifyErrorDetails(615, ERROR_TYPE_REQUEST_FAILED, REQUEST_FAILED_INFO);
    }

    @When("I make an API request with invalid access key")
    public void makeApiRequestWithInvalidAccessKey() {
        apiResponse = ApiErrorsHelper.makeApiRequestWithWrongKeyError(101, CITY);
    }

    @Then("the response should contain the correct invalid access key error details")
    public void verifyInvalidAccessKeyErrorDetails() {
        ApiErrorsHelper.assertRequestStatusCode(apiResponse, 200);
        verifyErrorDetails(101, ERROR_TYPE_WRONG_API_KEY, WRONG_API_KEY_INFO);
    }

    @When("I make an API request with HTTPS access restricted")
    public void makeApiRequestWithHttpsAccessRestricted() {
        apiResponse = ApiErrorsHelper.makeApiRequestWithWrongUrlError(105, CITY);
    }

    @Then("the response should contain the correct HTTPS access restricted error details")
    public void verifyHttpsAccessRestrictedErrorDetails() {
        ApiErrorsHelper.assertRequestStatusCode(apiResponse, 200);
        verifyErrorDetails(105, ERROR_TYPE_WRONG_URL, WRONG_URL_INFO);
    }

    @When("I make an API request with error API function does not exist")
    public void makeApiRequestWithApiFunctionErrorCode() {
        apiResponse = ApiErrorsHelper.makeApiRequestWithApiFunctionError(103, CITY);
    }

    @Then("the response should contain the correct not found resource error details")
    public void verifyApiFunctionErrorDetails() {
        ApiErrorsHelper.assertRequestStatusCode(apiResponse, 200);
        verifyErrorDetails(103, ERROR_TYPE_INVALID_API_FUNCTION, INVALID_API_FUNCTION_INFO);
    }

    private void verifyErrorDetails(Integer expectedResponseErrorCode, String expectedResponseErrorType, String expectedResponseErrorInfo) {
        try {
            WeatherApiError weatherApiError = ApiErrorsHelper.extractErrorFromResponse(apiResponse);
            assertFalse("Expected API call to be unsuccessful", weatherApiError.isSuccess());
            Logger.info("Expected API call successful: %s", weatherApiError.isSuccess());
            ErrorDetails errorDetails = weatherApiError.getError();
            assertNotNull("Expected error details is null", errorDetails);
            assertEquals("Expected error code not matched", expectedResponseErrorCode, errorDetails.getCode());
            Logger.info("Expected error code {%s} and actual error code {%s}", expectedResponseErrorCode, errorDetails.getCode());
            assertEquals("Expected error type not matched", expectedResponseErrorType, errorDetails.getType());
            Logger.info("Expected error type {%s} and actual error type {%s}", expectedResponseErrorType, errorDetails.getType());
            assertTrue("Expected error info not matched", errorDetails.getInfo().startsWith(expectedResponseErrorInfo));
            Logger.info("Error info is: %s", errorDetails.getInfo());
        } catch (IOException e) {
            fail("Failed to parse API response: " + e.getMessage());
        }
    }
}

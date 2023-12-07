package utils;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import org.apache.logging.log4j.LogManager;

public class Logger {
    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Logger.class);

    private Logger() {}

    public static void info(String message){
        Allure.step(message);
        LOGGER.info(message);
    }

    public static void info(String message, Object... arguments) {
        String formattedMessage = String.format(message, arguments);
        Allure.step(formattedMessage);
        LOGGER.info(formattedMessage);
    }

    public static void debug(String message){
        LOGGER.debug(message);
    }

    public static void debug(String message, Object... arguments){
        String formattedMessage = String.format(message, arguments);
        Allure.step(formattedMessage);
        LOGGER.debug(formattedMessage);
    }

    public static void warn(String message){
        LOGGER.warn(message);
    }

    public static void warn(String message, Throwable error){
        LOGGER.warn(message, error);
    }

    public static void error(String message){
        LOGGER.error(message);
    }

    public static void error(String message, Object... arguments) {
        String formattedMessage = String.format(message, arguments);
        Allure.step(formattedMessage);
        LOGGER.error(formattedMessage);
    }

    public static void error(String message, Throwable error){
        LOGGER.error(message, error);
    }

    public static void trace(String message){
        LOGGER.trace(message);
    }

    public static void logRequest(FilterableRequestSpecification requestSpec) {
        String requestInfo = String.format("Request: %s %s", requestSpec.getMethod(), requestSpec.getURI());
        info(requestInfo);
        if (requestSpec.getBody() != null) {
            info("Request Body: {}", requestSpec.getBody().toString());
        }
    }

    public static void logResponse(Response response) {
        String responseInfo = String.format("Response: %d", response.getStatusCode());
        info(responseInfo);
        if (response.getBody() != null) {
            info("Response Body: {}", response.getBody().asString());
        }
    }
}

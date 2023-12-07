package helpers;

import io.qameta.allure.Allure;
import models.WeatherstackResponseBody;
import utils.Logger;

public class CurrentBodyHelper {
    public static void assertWeatherTemperature(WeatherstackResponseBody weatherstackResponseBody,
                                                Integer minTemperature, Integer maxTemperature) {
        Logger.info("Asserting weather details. Expected temperature range: [" + minTemperature + " - " + maxTemperature + "]");
        int actualTemperature = weatherstackResponseBody.getCurrent().getTemperature();
        if (actualTemperature < minTemperature || actualTemperature > maxTemperature) {
            Logger.error("Temperature is not within the expected range. Expected range: ["
                + minTemperature + " - " + maxTemperature + "], Actual: " + actualTemperature);
            Allure.addAttachment("Weather Details",
                "Temperature is not within the expected range. Expected range: ["
                    + minTemperature + " - " + maxTemperature + "], Actual: " + actualTemperature);
            throw new AssertionError("Temperature is not within the expected range. Expected range: ["
                + minTemperature + " - " + maxTemperature + "], Actual: " + actualTemperature);
        } else Logger.info("Verifying success");
    }
}

package helpers;

import io.qameta.allure.Allure;
import models.WeatherstackResponseBody;
import utils.Logger;

public class LocationHelper {
    public static void assertWeatherCountry(WeatherstackResponseBody weatherstackResponseBody, String expectedCountry) {
        String actualCountry = weatherstackResponseBody.getLocation().getCountry();
        Logger.info("Verifying weather country. Expected: {%s}, Actual: {%s}", expectedCountry, actualCountry);
        if (!actualCountry.equals(expectedCountry)) {
            Logger.error("Mismatch in weather country. Expected: {%s}, Actual: {%s}", expectedCountry, actualCountry);
            Allure.addAttachment("Weather Country",
                "Mismatch in weather country. Expected: " + expectedCountry + ", Actual: " + actualCountry);
            throw new AssertionError("Mismatch in weather country. Expected: " + expectedCountry + ", Actual: " + actualCountry);
        } else Logger.info("Verifying success");
    }
}

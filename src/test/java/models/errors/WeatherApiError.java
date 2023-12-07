package models.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherApiError {
    private boolean success;
    private ErrorDetails error;

    public boolean isSuccess() {
        return success;
    }

    public ErrorDetails getError() {
        return error;
    }
}

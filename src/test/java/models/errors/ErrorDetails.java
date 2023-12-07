package models.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDetails {
    private Integer code;
    private String type;
    private String info;

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }
}

package models;

public class Request {
    public String type;
    public String query;
    public String language;
    public String unit;

    public Request() {
    }

    public Request(String type, String query, String language, String unit) {
        this.type = type;
        this.query = query;
        this.language = language;
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public String getQuery() {
        return query;
    }

    public String getLanguage() {
        return language;
    }

    public String getUnit() {
        return unit;
    }
}

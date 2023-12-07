package models;

public class Location {
    public String name;
    public String country;
    public String region;
    public String lat;
    public String lon;
    public String timezone_id;
    public String localtime;
    public Integer localtime_epoch;
    public String utc_offset;

    public Location() {
    }

    public Location(String name, String country, String region, String lat, String lon,
                    String timezone_id, String localtime, Integer localtime_epoch, String utc_offset) {
        this.name = name;
        this.country = country;
        this.region = region;
        this.lat = lat;
        this.lon = lon;
        this.timezone_id = timezone_id;
        this.localtime = localtime;
        this.localtime_epoch = localtime_epoch;
        this.utc_offset = utc_offset;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTimezone_id() {
        return timezone_id;
    }

    public String getLocaltime() {
        return localtime;
    }

    public Integer getLocaltime_epoch() {
        return localtime_epoch;
    }

    public String getUtc_offset() {
        return utc_offset;
    }
}

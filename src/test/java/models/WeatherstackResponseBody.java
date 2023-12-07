package models;

public class WeatherstackResponseBody {
    public Request request;
    public Location location;
    public Current current;

    public WeatherstackResponseBody() {
    }

    public WeatherstackResponseBody(Request request, Location location, Current current) {
        this.request = request;
        this.location = location;
        this.current = current;
    }

    public Request getRequest() {
        return request;
    }

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }
}

package ru.netology.geo;

import ru.netology.entity.Location;

public class GeoServiceMock implements GeoService {

    private Location location;

    @Override
    public Location byIp(String ip) {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public Location byCoordinates(double latitude, double longitude) {
        return null;
    }
}

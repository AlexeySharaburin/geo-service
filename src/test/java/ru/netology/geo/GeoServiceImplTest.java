package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplTest {

    @Test
    void test_byIp_success_NULL() {

        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();

        String testIp = "0.0.0.0";

        Location expectedLocation = null;

        Location resultLocation = geoServiceImpl.byIp(testIp);

        Assertions.assertEquals(expectedLocation, resultLocation);

    }

    @Test
    void test_byIp_USA_unsaccess() {

        Location expectedLocation = new Location("New York", Country.USA, null, 0);

        GeoServiceImpl geoService = new GeoServiceImpl();

        String ipUsa = "172.0.0.0";

        Location resultlocation = geoService.byIp(ipUsa);

        Assertions.assertEquals(expectedLocation, resultlocation);
    }

    @Test
    void test_byIp_MOSCOW_success() {

        GeoServiceImpl geoServiceImpl = new GeoServiceImpl();

        String testIp = GeoServiceImpl.MOSCOW_IP;

        Location expectedLocation = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Location resultLocation = geoServiceImpl.byIp(testIp);

        Assertions.assertEquals(expectedLocation, resultLocation);

    }

    @Test
    void test_byIp_NEW_YORK_success() {

        GeoServiceImpl geoService = new GeoServiceImpl();

        String ipUsa = GeoServiceImpl.NEW_YORK_IP;

        Location expectedLocation = new Location("New York", Country.USA, " 10th Avenue", 32);

        Location resultlocation = geoService.byIp(ipUsa);

        Assertions.assertEquals(expectedLocation, resultlocation);
    }

    @Test
    void test_byIp_RUSSIA_saccess() {

        Location expectedLocation = new Location("Moscow", Country.RUSSIA, null, 0);

        GeoServiceImpl geoService = new GeoServiceImpl();

        String ipUsa = "172.0.0.0";

        Location resultlocation = geoService.byIp(ipUsa);

        Assertions.assertEquals(expectedLocation, resultlocation);
    }
}
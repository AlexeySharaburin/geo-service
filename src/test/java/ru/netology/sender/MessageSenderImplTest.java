package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceMock;
import ru.netology.i18n.LocalizationServiceMock;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void test_send_USA_success() {

        GeoServiceMock geoService = new GeoServiceMock();
        Location locationUSA = new Location("New York", Country.USA, " 10th Avenue", 32);
        geoService.setLocation(locationUSA);

        LocalizationServiceMock localizationService = new LocalizationServiceMock();
        localizationService.setLocale("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");
        String resultWelcome = messageSender.send(headers);

        String expectedWelcome = "Welcome";

        Assertions.assertEquals(expectedWelcome, resultWelcome);
    }

    @Test
    void test_send_RUSSIA_success() {

        GeoServiceMock geoService = new GeoServiceMock();
        Location locationRussia = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        geoService.setLocation(locationRussia);

        LocalizationServiceMock localizationService = new LocalizationServiceMock();
        localizationService.setLocale("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        String resultWelcome = messageSender.send(headers);

        String expectedWelcome = "Добро пожаловать";

        Assertions.assertEquals(expectedWelcome, resultWelcome);
    }


}


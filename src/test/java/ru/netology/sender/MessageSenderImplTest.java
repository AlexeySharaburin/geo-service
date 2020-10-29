package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import java.util.HashMap;
import java.util.Map;
import ru.netology.i18n.LocalizationService;
//import ru.netology.i18n.LocalizationServiceMock;
//import ru.netology.geo.GeoServiceMock;



class MessageSenderImplTest {

    @Test
    void test_send_USA_success() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String resultWelcome = messageSender.send(headers);

        String expectedWelcome = "Welcome";

        Assertions.assertEquals(expectedWelcome, resultWelcome);
    }

    @Test
    void test_send_RUSSIA_success() {
        GeoService geoService = Mockito.mock(GeoService.class);
        Mockito.when(geoService.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String resultWelcome = messageSender.send(headers);

        String expectedWelcome = "Добро пожаловать";

        Assertions.assertEquals(expectedWelcome, resultWelcome);
    }

//    @Test
//    void test_send_USA_success() {
//
//        GeoServiceMock geoService = new GeoServiceMock();
//        Location locationUSA = new Location("New York", Country.USA, " 10th Avenue", 32);
//        geoService.setLocation(locationUSA);
//
//        LocalizationServiceMock localizationService = new LocalizationServiceMock();
//        localizationService.setLocale("Welcome");
//
//        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");
//        String resultWelcome = messageSender.send(headers);
//
//        String expectedWelcome = "Welcome";
//
//        Assertions.assertEquals(expectedWelcome, resultWelcome);
//    }
//
//    @Test
//    void test_send_RUSSIA_success() {
//
//        GeoServiceMock geoService = new GeoServiceMock();
//        Location locationRussia = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
//        geoService.setLocation(locationRussia);
//
//        LocalizationServiceMock localizationService = new LocalizationServiceMock();
//        localizationService.setLocale("Добро пожаловать");
//
//        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
//
//        Map<String, String> headers = new HashMap<>();
//        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
//        String resultWelcome = messageSender.send(headers);
//
//        String expectedWelcome = "Добро пожаловать";
//
//        Assertions.assertEquals(expectedWelcome, resultWelcome);
//    }

}


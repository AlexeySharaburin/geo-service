package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {

    @Test
    void test_locale_USA_success() {

        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();

        Country testCountry = Country.USA;

        String expectedWelcome = "Welcome";

        String resultWelcome = localizationServiceImpl.locale(testCountry);

        Assertions.assertEquals(expectedWelcome, resultWelcome);

    }

    @Test
    void test_locale_RUSSIA_success() {

        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();

        Country testCountry = Country.RUSSIA;

        String expectedWelcome = "Добро пожаловать";

        String resultWelcome = localizationServiceImpl.locale(testCountry);

        Assertions.assertEquals(expectedWelcome, resultWelcome);

    }

    @Test
    void test_locale_BRAZIL_unsuccess() {

        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();

        Country testCountry = Country.BRAZIL;

        String expectedWelcome = "Добро пожаловать";

        String resultWelcome = localizationServiceImpl.locale(testCountry);

        Assertions.assertEquals(expectedWelcome, resultWelcome);

    }



}
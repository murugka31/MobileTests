package com.emurugova.tests;

import com.codeborne.selenide.Configuration;
import com.emurugova.drivers.BrowserstackMobileDriver;
import com.emurugova.drivers.EmulatorMobileDriver;
import com.emurugova.drivers.LocalMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class TestBase {

   public static String deviceHost = System.getProperty("deviceHost","emulation");

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "emulation":
                Configuration.browser = EmulatorMobileDriver.class.getName();
                break;
            case "real":
               Configuration.browser = LocalMobileDriver.class.getName();
                break;
        }

        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}

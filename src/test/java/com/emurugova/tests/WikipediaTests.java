package com.emurugova.tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class WikipediaTests extends TestBase {

    @Test
    @DisplayName("Check tabs test")
    void checkTabsTest() {
        back();

        step("Check Saved page", () -> {
        $(MobileBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists"))
                .click();
        $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"))
                .shouldHave(text("Saved"));
        });

        step("Check Search page", () -> {
        $(MobileBy.id("org.wikipedia.alpha:id/nav_tab_search"))
                 .click();
        $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"))
                .shouldHave(text("Search"));
        });

        step("Check Edits page", () -> {
        $(MobileBy.id("org.wikipedia.alpha:id/nav_tab_edits"))
                .click();
        $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView"))
                .shouldHave(text("Edits"));
        });

        step("Check More page", () -> {
        $(MobileBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
        $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView"))
                .shouldHave(text("Settings"));
        $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView"))
                .shouldHave(text("Donate"));
        });

        step("Check Setting page", () -> {
        $(MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
        $(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView"))
                 .shouldHave(text("Settings"));
        });
    }
}

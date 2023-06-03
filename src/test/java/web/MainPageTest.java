package web;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPageTest extends TestBase {

    @Test
    void openAboutCompanyPageTest() {

        mainPage.openPage();
        $("#block-views-specialone-latest-news-block").shouldHave(text("Последние новости"));
        $(".navbar-inner").$(byText("О Компании")).click();
        $("#main-content").shouldHave(text("О компании"));
    }

    @Test
    void searchTextTest() {
        mainPage.openPage();
        $("#mission0").shouldHave(text("Наша миссия – создание условий для повышения качества жизни граждан " +
                "Российской Федерации путем реализации инновационного потенциала личности, трудового коллектива и общества в сферах"));
    }

    @Test
    void changeLanguageTest() {
        mainPage.openPage();
        $(".language-switcher-locale-url").$(byText("EN")).click();
        $(".navbar-inner").shouldHave(text("News"), text("About"), text("Customers"), text("Partners"), text("Products"), text("Download"));
    }
}
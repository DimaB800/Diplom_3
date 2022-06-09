import PageObject.PageAuthorization;
import PageObject.PageMainStellarBurgers;
import PageObject.PageRegistration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class TransferFromYourPersonalAccountTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;
    private static Map<String, String> map;


    @BeforeClass
    public static void precondition() {
        PageRegistration pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        map = pageRegistration.registrationUser();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка перехода по клику на Конструктор")
    public void goToConstructorTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageMainStellarBurgers.clickButtonConstructor();
        assertTrue("Ожидаемый результат не соответствует фактическому", pageMainStellarBurgers.checkTextAssembleTheBurger());
    }

    @Test
    @DisplayName("Проверка перехода по клику на логотип")
    public void goToLogoTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageMainStellarBurgers.clickButtonLogoStellarBurgers();
        assertTrue("Ожидаемый результат не соответствует фактическому", pageMainStellarBurgers.checkTextAssembleTheBurger());
    }


}

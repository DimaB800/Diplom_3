import PageObject.*;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TransferToYourPersonalAccountTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;
    private static PageRegistration pageRegistration;
    private static Map<String, String> map;


    @BeforeClass
    public static void precondition() {
        pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        map = pageRegistration.registrationUser();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка перехода по клику на личный кабинет")
    public void goToYourPersonalAccountTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", pagePersonalAccount.getInputAccountName(), map.get("name"));
    }

}

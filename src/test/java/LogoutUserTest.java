import PageObject.*;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class LogoutUserTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;
    private static PageRegistration pageRegistration;
    private static Map<String, String> map;

    @BeforeClass
    public static void precondition() {
        //настройка для запуска тестов в Safari
        //System.setProperty("selenide.browser", "safari");

        pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        map = pageRegistration.registrationUser();
    }

    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void logoutUserTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        pagePersonalAccount.clickExitButton();
        pageAuthorization.checkLoginPage();
        Assert.assertTrue("Ожидаемый результат не соответствует фактическому",pageAuthorization.displayedButtonLoginPage());
    }


}

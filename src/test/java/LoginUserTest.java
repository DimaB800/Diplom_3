import PageObject.*;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import static com.codeborne.selenide.Selenide.open;

public class LoginUserTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;
    private static PageRegistration pageRegistration;
    private static PagePasswordRecovery pagePasswordRecovery;
    private static Map<String, String> map;

    @BeforeClass
    public static void precondition() {
        //настройка для запуска тестов в Safari
        //System.setProperty("selenide.browser", "safari");

        pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        map = pageRegistration.registrationUser();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку в личном кабинете")
    public void authorizationThroughPersonalAccountButtonTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        Assert.assertEquals("Имя пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountName(), map.get("name"));
        Assert.assertEquals("Email пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountLogin(), map.get("email"));
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку на главной странице")
    public void authorizationOnTheMainPage() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonGetAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        pageMainStellarBurgers.clickButtonPersonalAccount();
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        Assert.assertEquals("Имя пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountName(), map.get("name"));
        Assert.assertEquals("Email пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountLogin(), map.get("email"));
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку в форме регистрации")
    public void authorizationOnTheRegisterPage() {
        pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        pageRegistration.clickButtonGoToTheAuthorizationForm();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        PageMainStellarBurgers pageMainStellarBurgers = Selenide.page(PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        Assert.assertEquals("Имя пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountName(), map.get("name"));
        Assert.assertEquals("Email пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountLogin(), map.get("email"));
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку в форме восстановления пароля")
    public void authorizationInThePasswordRecoveryForm() {
        pagePasswordRecovery = open("https://stellarburgers.nomoreparties.site/forgot-password", PagePasswordRecovery.class);
        pagePasswordRecovery.clickLinkLogIn();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.checkLoginPage();
        pageAuthorization.setInputEmail(map.get("email"));
        pageAuthorization.setInputPassword(map.get("password"));
        pageAuthorization.clickButtonLogIn();
        PageMainStellarBurgers pageMainStellarBurgers = Selenide.page(PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        PagePersonalAccount pagePersonalAccount = Selenide.page(PagePersonalAccount.class);
        Assert.assertEquals("Имя пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountName(), map.get("name"));
        Assert.assertEquals("Email пользователя в личном кабинете не соответствует ожидаемому", pagePersonalAccount.getInputAccountLogin(), map.get("email"));
    }

}

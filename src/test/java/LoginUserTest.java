import PageObject.*;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;


import static com.codeborne.selenide.Selenide.open;

public class LoginUserTest extends Preregister {

    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Before
    public void openSite() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
    }

    @Test
    @DisplayName("Проверка авторизации пользователя через кнопку в личном кабинете")
    public void authorizationThroughPersonalAccountButtonTest() {
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
        pageMainStellarBurgers.clickButtonGetAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.clickButtonGoToTheRegistrationForm();
        PageRegistration pageRegistration = Selenide.page(PageRegistration.class);
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
        pageMainStellarBurgers.clickButtonGetAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.clickButtonRecoverPassword();
        PagePasswordRecovery pagePasswordRecovery = Selenide.page(PagePasswordRecovery.class);
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

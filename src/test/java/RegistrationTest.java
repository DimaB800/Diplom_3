import PageObject.PageAuthorization;
import PageObject.PageMainStellarBurgers;
import PageObject.PagePersonalAccount;
import PageObject.PageRegistration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;
    private static PageAuthorization pageAuthorization;

    @Before
    public void precondition() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonPersonalAccount();
        pageAuthorization = Selenide.page(PageAuthorization.class);
        pageAuthorization.clickButtonGoToTheRegistrationForm();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Проверка регистрации пользователя")
    public void registrationUserTest() {
        PageRegistration pageRegistration = Selenide.page(PageRegistration.class);
        Map<String, String> map = pageRegistration.registrationUser();
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
    @DisplayName("Проверка регистрации пользователя с коротким поролем")
    public void registrationIncorrectPasswordTest() {
        PageRegistration pageRegistration = Selenide.page(PageRegistration.class);
        pageRegistration.registrationUserIncorrectPassword();
        assertTrue("Ожидаемая ошибка некорректного пароля не выводится", pageRegistration.checkErrorPasswordText());
    }

}

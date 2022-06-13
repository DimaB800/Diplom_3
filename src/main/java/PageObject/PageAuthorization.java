package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageAuthorization {
    //Строка для ввода email
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Email']]")
    private SelenideElement inputEmail;

    //Строка для ввода пароля
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Пароль']]")
    private SelenideElement inputPassword;

    //Кнопка Войти
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Войти')]")
    private SelenideElement buttonLogIn;

    //Кнопка Восстановить пароль
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Восстановить пароль')]")
    private SelenideElement buttonRecoverPassword;

    //Кнопка перехода на форму регистрации
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement buttonGoToTheRegistrationForm;

    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    protected SelenideElement loginText;

    public void checkLoginPage() {
        loginText.shouldHave(Condition.text("Вход"));
    }

    public boolean displayedButtonLoginPage() {
        return buttonLogIn.isDisplayed();
    }

    public void setInputEmail(String email) {

        inputEmail.setValue(email);
    }

    public void setInputPassword(String password) {
        inputPassword.setValue(password);
    }

    public void clickButtonRecoverPassword() {
        buttonRecoverPassword.click();
    }

    public void clickButtonLogIn() {
        buttonLogIn.click();
    }

    public void clickButtonGoToTheRegistrationForm() {
        buttonGoToTheRegistrationForm.click();
    }


}

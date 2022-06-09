package PageObject;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.Map;

public class PageRegistration {
    //Строка для ввода имени
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Имя']]")
    private SelenideElement inputName;

    //Строка для ввода email
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Email']]")
    private SelenideElement inputEmail;

    //Строка для ввода пароля
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Пароль']]")
    private SelenideElement inputPassword;

    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Зарегистрироваться')]")
    private SelenideElement buttonRegistration;

    //Текст ошибки
    @FindBy(how = How.XPATH, using = ".//p[text() = 'Некорректный пароль']")
    private SelenideElement errorPasswordText;

    //Кнопка перехода на форму авторизации
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement buttonGoToTheAuthorizationForm;

    public void clickButtonGoToTheAuthorizationForm() {
        buttonGoToTheAuthorizationForm.click();
    }

    public boolean checkErrorPasswordText() {
        return errorPasswordText.isDisplayed();
    }


    public void setInputName(String name) {
        inputName.setValue(name);
    }

    public void setInputEmail(String email) {
        inputEmail.setValue(email);
    }

    public void setInputPassword(String password) {
        inputPassword.setValue(password);
    }

    public void clickButtonRegistration() {
        buttonRegistration.click();
    }

    public Map<String, String> registrationUser() {
        Faker faker = new Faker();
        Map <String, String> map = new HashMap();
        map.put("name",faker.name().firstName());
        map.put("email",faker.internet().emailAddress());
        map.put("password",faker.internet().password());
        setInputName(map.get("name"));
        setInputEmail(map.get("email"));
        setInputPassword(map.get("password"));
        clickButtonRegistration();
        return map;
    }
    public void registrationUserIncorrectPassword() {
        Faker faker = new Faker();
        setInputName(faker.name().firstName());
        setInputEmail(faker.internet().emailAddress());
        setInputPassword("qwert");
        clickButtonRegistration();
    }

}

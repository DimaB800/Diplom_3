package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagePersonalAccount {

    //поле имя пользователя
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Имя']]")
    private SelenideElement inputAccountName;

    //поле Логин пользователя
    @FindBy(how = How.XPATH, using = ".//input [preceding-sibling::label [text() = 'Логин']]")
    private SelenideElement inputAccountLogin;

    //кнопка выход
    @FindBy(how = How.XPATH, using = ".//button[text() ='Выход']")
    private SelenideElement exitButton;

    public void clickExitButton() {
        exitButton.click();
    }

    public String getInputAccountName() {
        String name = inputAccountName.getValue();
        return name;
    }

    public String getInputAccountLogin() {
        String login = inputAccountLogin.getValue();
        return login;
    }

}

package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PagePasswordRecovery {

    //Строка для ввода email
    @FindBy(how = How.XPATH, using = ".//label[contains(text(),'Email')]")
    private SelenideElement inputEmail;

    //Кнопка Восстановить
    @FindBy(how = How.XPATH, using = ".//button[contains(text(),'Восстановить')]")
    private SelenideElement buttonRecover;

    //Кнопка перехода на страницу входа
    @FindBy(how = How.XPATH, using = ".//a[contains(text(),'Войти')]")
    private SelenideElement linkLogIn;

    public void setInputEmail(String email) {
        inputEmail.setValue(email);
    }

    public void clickButtonRecover() {
        buttonRecover.click();
    }

    public void clickLinkLogIn() {
        linkLogIn.click();
    }

}

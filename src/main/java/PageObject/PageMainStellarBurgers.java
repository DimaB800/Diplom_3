package PageObject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageMainStellarBurgers {

    //Кнопка Личный кабинет
    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX']/p[contains(text(),'Личный Кабинет')]")
    private SelenideElement buttonPersonalAccount;

    //Кнопка Лента заказов
    @FindBy(how = How.XPATH, using = ".//a[@class='AppHeader_header__link__3D_hX']/p[contains(text(),'Лента Заказов')]")
    private SelenideElement buttonOrderFeed;

    //Кнопка Конструктор
    @FindBy(how = How.XPATH, using = ".//p[text() = 'Конструктор']")
    private SelenideElement buttonConstructor;

    //Кнопка Логотип
    @FindBy(how = How.CLASS_NAME, using = "AppHeader_header__logo__2D0X2")
    private SelenideElement buttonLogoStellarBurgers;

    //Кнопка войти в аккаунт
    @FindBy(how = How.XPATH, using = ".//button[text() = 'Войти в аккаунт']")
    private SelenideElement buttonGetAccount;

    //Кнопка Булки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Булки']")
    private SelenideElement buttonRolls;

    //Кнопка Соусы
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Соусы']")
    private SelenideElement buttonSauces;

    //Кнопка Начинки
    @FindBy(how = How.XPATH, using = ".//span[text() = 'Начинки']")
    private SelenideElement buttonFillings;

    //Текст Соберите бургер
    @FindBy(how = How.XPATH, using = ".//h1[text() = 'Соберите бургер']")
    private SelenideElement textAssembleTheBurger;

    //Локатор активной кнопки ингредиентов
    @FindBy(how = How.CSS, using = ".tab_tab_type_current__2BEPc")
    private SelenideElement activeButton;

    public String getTextActiveButton() {
        return  activeButton.getText();
    }

    public boolean checkTextAssembleTheBurger() {
        return textAssembleTheBurger.isDisplayed();
    }


    public void clickButtonPersonalAccount() {
        buttonPersonalAccount.click();
    }

    public void clickButtonOrderFeed() {
        buttonOrderFeed.click();
    }

    public void clickButtonConstructor() {
        buttonConstructor.click();
    }

    public void clickButtonLogoStellarBurgers() {
        buttonLogoStellarBurgers.click();
    }

    public void clickButtonGetAccount() {
        buttonGetAccount.click();
    }

    public void clickButtonRolls() {
        buttonRolls.click();
    }

    public void clickButtonSauces() {
        buttonSauces.click();
    }

    public void clickButtonFillings() {
        buttonFillings.click();
    }

}

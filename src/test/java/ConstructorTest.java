import PageObject.PageMainStellarBurgers;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    public void clickToRollsButtonTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonFillings();
        pageMainStellarBurgers.clickButtonRolls();
        String actual = pageMainStellarBurgers.getTextActiveButton();
        String expected = "Булки";
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void clickToSaucesButtonTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonFillings();
        pageMainStellarBurgers.clickButtonSauces();
        String actual = pageMainStellarBurgers.getTextActiveButton();
        String expected = "Соусы";
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void clickToFillingsButtonTest() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
        pageMainStellarBurgers.clickButtonSauces();
        pageMainStellarBurgers.clickButtonFillings();
        String actual = pageMainStellarBurgers.getTextActiveButton();
        String expected = "Начинки";
        Assert.assertEquals("Ожидаемый результат не соответствует фактическому", actual, expected);
    }


}

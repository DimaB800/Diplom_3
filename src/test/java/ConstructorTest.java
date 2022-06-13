import PageObject.PageMainStellarBurgers;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    private static PageMainStellarBurgers pageMainStellarBurgers;

    @Before
    public void openSite() {
        pageMainStellarBurgers = open("https://stellarburgers.nomoreparties.site/", PageMainStellarBurgers.class);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    public void clickToRollsButtonTest() {
        pageMainStellarBurgers.clickButtonFillings();
        pageMainStellarBurgers.clickButtonRolls();
        String actual = pageMainStellarBurgers.getTextActiveButton();
        String expected = "Булки";
        Assert.assertEquals("Не удалось перейти на вкладку Булки", actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void clickToSaucesButtonTest() {
        pageMainStellarBurgers.clickButtonFillings();
        pageMainStellarBurgers.clickButtonSauces();
        String actual = pageMainStellarBurgers.getTextActiveButton();
        String expected = "Соусы";
        Assert.assertEquals("Не удалось перейти на вкладку Соусы", actual, expected);
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void clickToFillingsButtonTest() {
        pageMainStellarBurgers.clickButtonSauces();
        pageMainStellarBurgers.clickButtonFillings();
        String actual = pageMainStellarBurgers.getTextActiveButton();
        String expected = "Начинки";
        Assert.assertEquals("Не удалось перейти на вкладку Начинки", actual, expected);
    }

}

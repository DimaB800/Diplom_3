import PageObject.PageRegistration;
import org.junit.BeforeClass;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class Preregister {

    protected static Map<String, String> map;

    @BeforeClass
    public static void precondition() {
        //настройка для запуска тестов в Safari
        //System.setProperty("selenide.browser", "safari");

        PageRegistration pageRegistration = open("http://stellarburgers.nomoreparties.site/register", PageRegistration.class);
        map = pageRegistration.registrationUser();
    }
}

import io.qameta.allure.junit4.DisplayName;
import org.example.UserData;
import org.example.WebDriverFactory;
import org.example.pageObject.LoginPage;
import org.example.pageObject.MainPage;
import org.example.pageObject.SignupPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class SignupTest {
    public MainPage mainPage;
    public WebDriver driver;

    @Before
    public void startUp() {
//        driver = new WebDriverFactory().getWebDriver("chrome");
        driver = new WebDriverFactory().getWebDriver("yandex");
        driver.get("https://stellarburgers.nomoreparties.site/register");
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void testSignup(){
        UserData userData = new UserData("filya1@gmail.com", "123456", "Ivan");
        LoginPage loginPage = new SignupPage(driver)
                .typeName(userData.getEmail())
                .typePassword(userData.getPassword())
                .signUpButtonClick();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        boolean actual = loginPage.isLoginFormVisible();
        assertTrue("Успешная регистрация", actual);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов.")
    public void testSignupError(){
        UserData userData = new UserData("filya2@gmail.com", "12345", "Ivan");
        LoginPage loginPage = new SignupPage(driver)
                .typeName(userData.getEmail())
                .typePassword(userData.getPassword())
                .signUpButtonClick();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        boolean actual = loginPage.isValidationLabelVisible();
        assertTrue("Введен некорректный пароль", actual);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

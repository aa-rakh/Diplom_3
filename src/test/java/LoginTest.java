import io.qameta.allure.junit4.DisplayName;
import org.example.pageObject.*;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void testLoginLoginButton(){
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage = new MainPage(driver);
        mainPage.clickLoginButton();
        MainPage mainPage = new LoginPage(driver)
                .typeLogin(newUser.getEmail())
                .typePassword(newUser.getPassword())
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean actual = mainPage.isBurgerIngredientsSectionVisible();
        assertTrue("Успешная авторизация", actual);
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void testLoginPersonalAreaButton(){
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage = new MainPage(driver);
        mainPage.clickPersonalAreaButton();
        MainPage mainPage = new LoginPage(driver)
                .typeLogin(newUser.getEmail())
                .typePassword(newUser.getPassword())
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean actual = mainPage.isBurgerIngredientsSectionVisible();
        assertTrue("Успешная авторизация", actual);
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void testLoginFromSignUpForm(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        new SignupPage(driver).signInLinkClick();
        MainPage mainPage = new LoginPage(driver)
                .typeLogin(newUser.getEmail())
                .typePassword(newUser.getPassword())
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean actual = mainPage.isBurgerIngredientsSectionVisible();
        assertTrue("Успешная авторизация", actual);
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void testLoginFromPasswordRecoveryForm(){
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        new PasswordRecoveryPage(driver).signInLinkClick();
        MainPage mainPage = new LoginPage(driver)
                .typeLogin(newUser.getEmail())
                .typePassword(newUser.getPassword())
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        boolean actual = mainPage.isBurgerIngredientsSectionVisible();
        assertTrue("Успешная авторизация", actual);
    }

}

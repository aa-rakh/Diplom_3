import io.qameta.allure.junit4.DisplayName;
import org.example.pageObject.LoginPage;
import org.example.pageObject.MainPage;
import org.example.pageObject.PersonalAreaPage;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;

public class LogoutTest extends BaseTest{

    @Before
    public void startUp() {
        super.startUp();
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("выход по кнопке «Выйти» в личном кабинете")
    public void testTransitionToProfile(){
        mainPage.clickPersonalAreaButton();
        MainPage mainPage = new LoginPage(driver)
                .typeLogin(newUser.getEmail())
                .typePassword(newUser.getPassword())
                .clickLoginButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        PersonalAreaPage personalAreaPage = mainPage.clickPersonalAreaButtonSignUpUser();
        LoginPage loginPage = personalAreaPage.clickLogoutButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assertTrue(loginPage.isLoginFormVisible());
    }

}

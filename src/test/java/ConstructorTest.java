import io.qameta.allure.junit4.DisplayName;
import org.example.WebDriverFactory;
import org.example.pageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    public MainPage mainPage;
    public WebDriver driver;

    @Before
    public void startUp() {
        driver = new WebDriverFactory().getWebDriver("chrome");
//        driver = new WebDriverFactory().getWebDriver("yandex");
        driver.get("https://stellarburgers.nomoreparties.site");
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("переход к разделу «Соусы»")
    public void testConstructorSauces(){
        mainPage.clickSaucesLabel();
        assertTrue(mainPage.isSaucesTabSelected());
    }

    @Test
    @DisplayName("переход к разделу «Булки»")
    public void testConstructorBuns(){
        mainPage.clickSaucesLabel();
        mainPage.clickBunsLabel();
        assertTrue(mainPage.isBunsTabSelected());
    }

    @Test
    @DisplayName("переход к разделу «Начинки»")
    public void testConstructorFillings(){
        mainPage.clickFillingsLabel();
        assertTrue(mainPage.isFillingsTabSelected());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

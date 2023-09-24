import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.example.ReturnedUserDataJson;
import org.example.UserData;
import org.example.WebDriverFactory;
import org.example.pageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.equalTo;

abstract class BaseTest {
    public MainPage mainPage;
    public WebDriver driver;
    private String accessToken;
    Faker faker = new Faker();
    private String login = faker.internet().emailAddress();
    private String password = faker.internet().password(6, 7);
    private String name = faker.name().firstName();
    UserData newUser = new UserData(login, password, name);

    @Before
    public void startUp() {
        Response responseCreate = newUser.sendRequestCreate(newUser);
        accessToken = responseCreate.getBody().as(ReturnedUserDataJson.class).getAccessToken();
        //        driver = new WebDriverFactory().getWebDriver("yandex");
        driver = new WebDriverFactory().getWebDriver("chrome");
    }

    @After
    public void tearDown(){
        Response responseDelete = newUser.sendRequestDelete(accessToken);
        responseDelete.then().assertThat()
                .body("message", equalTo("User successfully removed"));
        driver.quit();
    }
}

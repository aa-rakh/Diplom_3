package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private final By assembleBurgerHeader = By.xpath(".//h1[text()='Соберите бургер']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAreaLink = By.xpath(".//a[@href='/account']");
    private final By bunsLabel = By.xpath(".//*[text()='Булки']");
    private final By saucesLabel = By.xpath(".//*[text()='Соусы']");
    private final By fillingsLabel = By.xpath(".//*[text()='Начинки']");
    private final By bunsCurrentTab = By.xpath(".//*[contains(text(),'Булки')]/parent::*[contains(@class,'tab_type_current')]");
    private final By saucesCurrentTab = By.xpath(".//*[contains(text(),'Соусы')]/parent::*[contains(@class,'tab_type_current')]");
    private final By fillingsCurrentTab = By.xpath(".//*[contains(text(),'Начинки')]/parent::*[contains(@class,'tab_type_current')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage clickBunsLabel(){
        driver.findElement(bunsLabel).click();
        return new MainPage(driver);
    }

    public MainPage clickSaucesLabel(){
        driver.findElement(saucesLabel).click();
        return new MainPage(driver);
    }

    public MainPage clickFillingsLabel(){
        driver.findElement(fillingsLabel).click();
        return new MainPage(driver);
    }

    public LoginPage clickPersonalAreaButton(){
        driver.findElement(personalAreaLink).click();
        return new LoginPage(driver);
    }

    public PersonalAreaPage clickPersonalAreaButtonSignUpUser(){
        driver.findElement(personalAreaLink).click();
        return new PersonalAreaPage(driver);
    }

    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public boolean isBurgerIngredientsSectionVisible() {
        return driver.findElement(assembleBurgerHeader).isDisplayed();
    }

    public boolean isBunsTabSelected() {
        return driver.findElement(bunsCurrentTab).isDisplayed();
    }


    public boolean isSaucesTabSelected() {
        return driver.findElement(saucesCurrentTab).isDisplayed();
    }

    public boolean isFillingsTabSelected() {
        return driver.findElement(fillingsCurrentTab).isDisplayed();
    }
}

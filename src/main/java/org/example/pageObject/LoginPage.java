package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginForm = By.xpath(".//form[contains(@class,'Auth_form')]");
    private final By loginInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    private final By validationLabel = By.xpath(".//*[text()='Некорректный пароль']");


    public boolean isLoginFormVisible() {
        return driver.findElement(loginForm).isDisplayed();
    }
    public boolean isValidationLabelVisible() {
        return driver.findElement(validationLabel).isDisplayed();
    }

    public LoginPage typeLogin(String login){
        driver.findElement(loginInput).sendKeys(login);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public MainPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new MainPage(driver);
    }

}

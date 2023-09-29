package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    private WebDriver driver;
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By signInLink = By.xpath(".//a[text()='Войти']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public SignupPage typeName(String name){
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public SignupPage typePassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage signUpButtonClick() {
        driver.findElement(signUpButton).click();
        return new LoginPage(driver);
    }

    public LoginPage signInLinkClick() {
        driver.findElement(signInLink).click();
        return new LoginPage(driver);
    }
}

package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By signInLink = By.xpath(".//a[text()='Войти']");

    public LoginPage signInLinkClick() {
        driver.findElement(signInLink).click();
        return new LoginPage(driver);
    }
}

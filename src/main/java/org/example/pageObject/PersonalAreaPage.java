package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAreaPage {
    private WebDriver driver;
    private final By logoutButton = By.xpath(".//button[text()='Выход']");
    private final By constructorHeader = By.xpath(".//*[text()='Конструктор']");
    private final By logoHeader = By.xpath("//div[contains(@class, 'AppHeader_header__logo')]");

    public PersonalAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoutButtonVisible() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public MainPage clickConstructorHeader(){
        driver.findElement(constructorHeader).click();
        return new MainPage(driver);
    }

    public MainPage clickLogoHeader(){
        driver.findElement(logoHeader).click();
        return new MainPage(driver);
    }

    public LoginPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}

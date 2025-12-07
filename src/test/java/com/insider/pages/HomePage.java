package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By companyMenu = By.xpath("//a[@id='navbarDropdownMenuLink' and contains(text(),'Company')]");
    private By careersLink = By.xpath("//a[@class='dropdown-sub' and contains(text(),'Careers')]");
    private By homePageLogo = By.cssSelector(".navbar-brand img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
    }

    public boolean isHomePageOpened() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLogo)).isDisplayed();
    }

    public void clickCompanyMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(companyMenu)).click();
    }

    public void clickCareersLink() {
        wait.until(ExpectedConditions.elementToBeClickable(careersLink)).click();
    }
}

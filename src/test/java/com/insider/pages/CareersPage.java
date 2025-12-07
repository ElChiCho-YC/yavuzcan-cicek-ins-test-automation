package com.insider.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By locationsBlock = By.xpath("//h3[@class='category-title-media ml-0' and contains(text(), 'Our Locations')]");
    private By teamsBlock = By.xpath("//a[@class='btn btn-outline-secondary rounded text-medium mt-5 mx-auto py-3 loadmore' and contains(text(), 'See all teams')]");
    private By lifeAtInsiderBlock = By.xpath("//h2[@class='elementor-heading-title elementor-size-default' and contains(text(), 'Life at Insider')]");

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isLocationsBlockDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locationsBlock)).isDisplayed();
    }

    public boolean isTeamsBlockDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(teamsBlock)).isDisplayed();
    }

    public boolean isLifeAtInsiderBlockDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lifeAtInsiderBlock)).isDisplayed();
    }
}

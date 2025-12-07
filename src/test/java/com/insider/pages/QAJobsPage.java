package com.insider.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class QAJobsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By seeAllQAJobsButton = By.xpath(
            "//a[@class='btn btn-outline-secondary rounded text-medium mt-2 py-3 px-lg-5 w-100 w-md-50' and contains(text(), 'See all QA jobs')]");
    private By locationFilter = By.id("select2-filter-by-location-container");
    private By departmentFilter = By.id("select2-filter-by-department-container");
    private By jobsContainer = By.id("jobs-list");
    private By jobsList = By.cssSelector("#jobs-list .position-list-item");
    private By showing = By.xpath("//span[@id='deneme' and contains(text(),'181')]");
    private By positionTitle = By.cssSelector(".position-title");
    private By positionDepartment = By.cssSelector(".position-department");
    private By positionLocation = By.cssSelector(".position-location");
    private By viewRoleButton = By.cssSelector("a.btn[href*='jobs.lever.co']");
    private By viewRoleButtonInsideJob = By.cssSelector("a.btn.btn-navy");

    public QAJobsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickSeeAllQAJobs() {
        wait.until(ExpectedConditions.elementToBeClickable(seeAllQAJobsButton)).click();
        waitForJobsToLoad();
    }

    public void filterByLocation(String location) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(showing)); //sayfa açıldığında dropdownlar yüklenmemekte tekrar kontrol edilecek.
        wait.until(ExpectedConditions.elementToBeClickable(locationFilter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[@class='select2-results__option' and contains(text(), '" + location + "')]"))).click();
        waitForJobsToUpdate();
    }

    public void filterByDepartment(String department) {
        wait.until(ExpectedConditions.elementToBeClickable(departmentFilter)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + department + "')]")))
                .click();
        waitForJobsToUpdate();
    }

    public boolean isJobsListDisplayed() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobsList));
        return driver.findElements(jobsList).size() > 0;
    }

    public List<WebElement> getAllJobs() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobsList));
    }

    public String getJobPosition(WebElement job) {
        return job.findElement(positionTitle).getText();
    }

    public String getJobDepartment(WebElement job) {
        return job.findElement(positionDepartment).getText();
    }

    public String getJobLocation(WebElement job) {
        return job.findElement(positionLocation).getText();
    }

    public void clickViewRole(WebElement job) {
        WebElement button = job.findElement(viewRoleButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    private void waitForJobsToLoad() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobsList));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobsContainer));
    }

    private void waitForJobsToUpdate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobsList));
        wait.until(ExpectedConditions.visibilityOfElementLocated(jobsList));
    }

    public void clickViewRoleByIndex(int index) {
        // Job listesini yeniden al (stale element'ten kaçınmak için)
        List<WebElement> jobs = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobsList));

        if (index < 0 || index >= jobs.size()) {
            throw new IndexOutOfBoundsException(
                    "Job index " + index + " is out of bounds. Total jobs: " + jobs.size());
        }

        WebElement job = jobs.get(index);

        // 1. Job kartını ekranın ortasına getir
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", job);

        // 2. Scroll sonrası kısa bekleme
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 3. View Role butonunu bul
        WebElement button = job.findElement(By.cssSelector("a.btn.btn-navy"));

        // 4. JavaScript ile tıkla (en garantili yöntem)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        System.out.println("✅ View Role butonuna tıklandı (index: " + index + ")");
    }
}

package com.insider.tests;

import com.insider.base.BaseTest;
import com.insider.pages.CareersPage;
import com.insider.pages.HomePage;
import com.insider.pages.LeverPage;
import com.insider.pages.QAJobsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InsiderTest extends BaseTest {

    @Test(priority = 1, description = "Verify Insider home page is opened")
    public void testHomePageIsOpened() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage("https://useinsider.com/");

        Assert.assertTrue(homePage.isHomePageOpened(), "Home page is not opened");
    }

    @Test(priority = 2, description = "Verify Career page blocks are displayed")
    public void testCareerPageBlocks() {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);

        homePage.navigateToHomePage("https://useinsider.com/");
        homePage.clickCompanyMenu();
        homePage.clickCareersLink();

        Assert.assertTrue(careersPage.isLocationsBlockDisplayed(), "Locations block is not displayed");
        Assert.assertTrue(careersPage.isTeamsBlockDisplayed(), "Teams block is not displayed");
        Assert.assertTrue(careersPage.isLifeAtInsiderBlockDisplayed(), "Life at Insider block is not displayed");
    }

    @Test(priority = 3, description = "Verify QA jobs are filtered and displayed")
    public void testQAJobsFiltering() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);

        driver.get("https://useinsider.com/careers/quality-assurance/");
        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.filterByLocation("Istanbul, Turkiye");
        qaJobsPage.filterByDepartment("Quality Assurance");

        Assert.assertTrue(qaJobsPage.isJobsListDisplayed(), "Jobs list is not displayed");
    }

    @Test(priority = 4, description = "Verify all jobs contain correct Position, Department, and Location")
    public void testJobsDetails() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);

        driver.get("https://useinsider.com/careers/quality-assurance/");
        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.filterByLocation("Istanbul");
        qaJobsPage.filterByDepartment("Quality Assurance");

        List<WebElement> jobs = qaJobsPage.getAllJobs();

        System.out.println("\n===============================================");
        System.out.println("Total number of jobs: " + jobs.size());
        System.out.println("===============================================");

        Assert.assertTrue(jobs.size() > 0, "No jobs found");

        for (int i = 0; i < jobs.size(); i++) {
            WebElement job = jobs.get(i);

            String position = qaJobsPage.getJobPosition(job);
            String department = qaJobsPage.getJobDepartment(job);
            String location = qaJobsPage.getJobLocation(job);

            System.out.println("\nJob #" + (i + 1));
            System.out.println("   Position   : " + position);
            System.out.println("   Department : " + department);
            System.out.println("   Location   : " + location);

            boolean hasQA = position.contains("Quality Assurance") ||
                    position.contains("QA") ||
                    position.toLowerCase().contains("qa");

            Assert.assertTrue(hasQA,
                              "Position does not contain 'Quality Assurance' or 'QA': " + position);

            Assert.assertEquals(department, "Quality Assurance",
                                "Department is not 'Quality Assurance': " + department);

            Assert.assertTrue(location.contains("Istanbul"),
                              "Location does not contain 'Istanbul': " + location);
        }

        System.out.println("\n===============================================");
        System.out.println("All “ + jobs.size() + ” jobs were successfully verified");
        System.out.println("===============================================\n");
    }

    @Test(priority = 5, description = "Verify View Role button redirects to Lever application form")
    public void testViewRoleRedirection() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);
        LeverPage leverPage = new LeverPage(driver);

        driver.get("https://useinsider.com/careers/quality-assurance/");
        qaJobsPage.clickSeeAllQAJobs();
        qaJobsPage.filterByLocation("Istanbul, Turkiye");
        qaJobsPage.filterByDepartment("Quality Assurance");

        List<WebElement> jobs = qaJobsPage.getAllJobs();
        Assert.assertTrue(jobs.size() > 0, "No jobs found");

        String originalWindow = driver.getWindowHandle();

        qaJobsPage.clickViewRoleByIndex(0);

        leverPage.switchToLeverWindow(originalWindow);

        Assert.assertTrue(leverPage.isLeverApplicationFormDisplayed(),
                          "Lever application form is not displayed");
        Assert.assertTrue(leverPage.getCurrentUrl().contains("jobs.lever.co"),
                          "URL does not contain 'jobs.lever.co'");
    }
}

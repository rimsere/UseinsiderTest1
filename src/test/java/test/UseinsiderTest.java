package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UseinsiderTest {

    private WebDriver driver;

    @Test
    public void testInsiderJobApplication() {
        // Step 1: Open Insider home page
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://useinsider.com/");

        // Step 2: Navigate to Career page and verify blocks are present
        WebElement moreMenu = driver.findElement(By.xpath("//span[contains(text(),'More')]"));
        moreMenu.click();
        WebElement careersLink = driver.findElement(By.xpath("//a[contains(text(),'Careers')]"));
        careersLink.click();
        WebElement seeAllTeamsButton = driver.findElement(By.xpath("//button[contains(text(),'See All Teams')]"));
        seeAllTeamsButton.click();
        WebElement qaTeamLink = driver.findElement(By.xpath("//a[contains(text(),'Quality Assurance')]"));
        qaTeamLink.click();
        WebElement seeAllJobsButton = driver.findElement(By.xpath("//a[contains(text(),'See all QA jobs')]"));
        seeAllJobsButton.click();
        WebElement locationDropdown = driver.findElement(By.xpath("//label[contains(text(),'Location')]/following-sibling::div//div[@role='combobox']"));
        locationDropdown.click();
        WebElement istanbulOption = driver.findElement(By.xpath("//li[@data-value='Istanbul, Turkey']"));
        istanbulOption.click();
        WebElement departmentDropdown = driver.findElement(By.xpath("//label[contains(text(),'Department')]/following-sibling::div//div[@role='combobox']"));
        departmentDropdown.click();
        WebElement qaOption = driver.findElement(By.xpath("//li[@data-value='Quality Assurance']"));
        qaOption.click();
        WebElement jobsList = driver.findElement(By.xpath("//div[@class='jobs-list']/div"));
        Assert.assertTrue(jobsList.isDisplayed());

        // Step 4: Check job details and apply
        WebElement jobDetails = driver.findElement(By.xpath("//div[@class='jobs-list']/div[1]"));
        WebElement jobPosition = jobDetails.findElement(By.xpath(".//h3[contains(text(),'Quality Assurance')]"));
        Assert.assertTrue(jobPosition.isDisplayed());
        WebElement jobDepartment = jobDetails.findElement(By.xpath(".//div[contains(text(),'Quality Assurance')]"));
        Assert.assertTrue(jobDepartment.isDisplayed());
        WebElement jobLocation = jobDetails.findElement(By.xpath(".//div[contains(text(),'Istanbul, Turkey')]"));
        Assert.assertTrue(jobLocation.isDisplayed());
        WebElement applyButton = jobDetails.findElement(By.xpath(".//a[contains(text(),'Apply Now')]"));
        applyButton.click();

        // Step 5: Verify application form is opened
        WebElement applicationForm = driver.findElement(By.xpath("//div[@class='lever-modal']"));
    }
}

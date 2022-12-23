package com.test.scenarios;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.test.model.LoginPage;
import org.apache.commons.io.FileUtils;

import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Scenario_01 {

    private static WebDriver webDriver;
    private LoginPage loginPage = new LoginPage();
    private TakesScreenshot screenshot;
    private File sourceFile;
    private static ExtentReports extentReports;
    private ExtentTest extentTest;

    private static int increment = 0;


    @BeforeAll
    public static void setup() {
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
        extentReports
                .addSystemInfo("Host Name", "Software Testing")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Francis");
        extentReports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
        webDriver = new ChromeDriver();
    }

    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dataName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/FailedTestScreenshots/" + screenshotName + dataName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    @BeforeEach
    public void launch() throws InterruptedException {
        webDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }

    @Test
    @Order(1)
    public void testC() {
        loginPage.setPageHeader(findElement(webDriver, "//*[text()='Login']").isDisplayed());
        loginPage.setPasswordLabel(findElement(webDriver, "//*[text()='Username']").isDisplayed());
        loginPage.setUsernameLabel(findElement(webDriver, "//*[text()='Password']").isDisplayed());

        Assert.assertEquals(true, loginPage.isPageHeader());
        Assert.assertEquals(true, loginPage.isUsernameLabel());
        Assert.assertEquals(true, loginPage.isPasswordLabel());
    }

    @Test
    @Order(2)
    public void testB() {
        findElement(webDriver, "//input[@placeholder='Username']").sendKeys("Admin");
        findElement(webDriver, "//input[@placeholder='Password']").sendKeys("admin123");
        findElement(webDriver, "//button").click();
    }

    @Test
    @Order(3)
    public void testA() {
        loginPage.setTitle(findElement(webDriver, "//p[text()='Paul Collings']").getText());
        Assert.assertEquals("Paul Collings", loginPage.getTitle());
    }

    @AfterEach
    public void screenshot() throws IOException {
        screenshot = ((TakesScreenshot) webDriver);
        sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File("C:\\Users\\Navis\\Desktop\\TakeScreenshot\\Screenshot" + ++increment + ".png"));
    }

    @AfterAll
    public static void close() {
        webDriver.quit();
    }

    public WebElement findElement(WebDriver webDriver, String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }
}
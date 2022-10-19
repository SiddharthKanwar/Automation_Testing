package com.carviatech;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CSVRead {

    WebDriver driver;


    @BeforeEach
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @ParameterizedTest(name = "{index} {0}")
    @CsvFileSource(resources = "/Sample.csv", numLinesToSkip = 1)
    public void testWebsitesNew(String link, String xpath, String assertionValue) throws IOException {
        driver.get(link);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,950);");
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));


//                WebElement element = driver.findElement(By.xpath(xpath));
//                String text = element.getText();
//                System.out.println(text);
//                Assertions.assertEquals(assertionValue, text, "website assertions did not match");

        WebElement p1 = driver.findElement(By.xpath(xpath));
        String s1 = p1.getText();
        System.out.println("Text content is : " + s1);
        Assertions.assertEquals(assertionValue, s1);
        Assertions.assertEquals(assertionValue, s1, "website assertions did not match");


        //System.out.println("Record No - " + csvRecord.getRecordNumber());
        System.out.println("---------------");
        System.out.println("Link : " + link);
        System.out.println("XPath : " + xpath);
        System.out.println("Assertion Value : " + assertionValue);
//                System.out.println("url : " + assertionValue);
        System.out.println("---------------\n\n");

    }


}

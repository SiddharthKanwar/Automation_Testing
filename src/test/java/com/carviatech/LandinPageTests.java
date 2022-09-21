package com.carviatech;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LandinPageTests {

    @Test
    public void testQuerySubmitFlow() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.listingfy.in/preview/b59ec962-bad4-4eb3-82d2-9f46f9b500c5");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement nameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("name")));
        nameElement.sendKeys("XYZ");
        driver.findElement(By.name("mobile")).sendKeys("6525654769");
        driver.findElement(By.name("email")).sendKeys("xyz@gmail.com");
        driver.findElement(By.name("subject")).sendKeys("xyz");
        driver.findElement(By.name("message")).sendKeys("zxcvbnm");

        driver.findElement(By.xpath("//button[@type=\"submit\"]")).submit();


        WebElement messageBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-form-box")));
        String actualTitle = messageBox.getText();
        String expectedTitle = "Query submitted successfully";
        System.out.println("Expected: " + expectedTitle);
        System.out.println("Actual: " + actualTitle);
        assertEquals(expectedTitle, actualTitle);
        driver.close();

        // System.out.println("Query submitted successfully");
        //Assert.assertTrue("Title does not match", expectedTitle.equals(driver.getTitle()));

        //System.out.println("Assert equals method validation");
        //Assert.assertEquals(expectedText, driver.getTitle());

    }
}


// Query submitted successfully
// Thread.sleep(2000);
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

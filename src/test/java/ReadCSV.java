import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.time.Duration;


public class ReadCSV {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/jyoti/Desktop/Sample.csv";

    @Test

    //  public void testReadCSV () throws Exception {
    public static void main(String[] args) throws IOException {


        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                WebDriver driver = new ChromeDriver();
                String link = csvRecord.get(0);
                String xpath = csvRecord.get(1);
                String assertionValue = csvRecord.get(2);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get(link);
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("window.scrollBy(0,1550);");

//                WebElement element = driver.findElement(By.xpath(xpath));
//                String text = element.getText();
//                System.out.println(text);
//                Assertions.assertEquals(assertionValue, text, "website assertions did not match");

                WebElement p1 = driver.findElement(By.xpath(xpath));
                String s1 = p1.getText();
                System.out.println("Text content is : " + s1);
                Assertions.assertEquals(assertionValue, s1);
                Assertions.assertEquals(assertionValue, s1, "website assertions did not match");

                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Link : " + link);
                System.out.println("XPath : " + xpath);
                System.out.println("Assertion Value : " + assertionValue);
//                System.out.println("url : " + assertionValue);
                System.out.println("---------------\n\n");

//                @AfterTest
//                public void terminateBrowser (){
//                    driver.close();
//                }
            }

            }
        }
    }


                    // Assertions.assertEquals(assertionValue, s1);

                    //  driver.close();

//                List<String> expectedTitlesList = Arrays.asList(expectedTitles);
//                assertTrue(expectedTitlesList.contains((expectedTitles)));

//                List<WebElement> rows1 = driver.findElements(By.linkText("csvRecord.get(2)"));
//                for (int i = 0; rows1.size() > i; i++) {
//                    List<WebElement> text = driver.findElements(By.xpath(csvRecord.get(2)));
//                    for (int j = 0; j < text.size(); j++) {
//                        String actualValue = "csvRecord.get(2)";
//                        String expectedValue = "limit.get(i).[j]";
//
//                        assertEquals(actualValue, expectedValue);


//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//                JavascriptExecutor jse = (JavascriptExecutor)driver;
//                jse.executeScript("window.scrollBy(0,1550);");
//
//                WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/footer/div/div[1]/div[1]/div/div/h2")));
//                WebElement p1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/footer/div/div[1]/div[1]/div/div/h2"));
//                String s1 = text.getText();
//                System.out.println("Text content is : " + s1);
//                Assertions.assertEquals("ListingFy", s1);



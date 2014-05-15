package examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 29/03/14
 * Time: 22:44
 * To change this template use File | Settings | File Templates.
 */
public class WaitMechanism {

    @Test
    public void testWithImplicitWait() {
        //Go to the Demo AJAX Application
        WebDriver driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/AjaxDemo.html");
        //Set the Implicit Wait time Out to 10 Seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            //Get link for Page 4 and click on it
            WebElement page4button = driver.findElement(By.linkText("Page 4"));
            page4button.click();
            //Get an element with id page4 and verify it's text
            WebElement message = driver.findElement(By.id("page4"));
            assertTrue(message.getText().contains("Nunc nibh tortor"));
        } catch (NoSuchElementException e) {
            fail("Element not found!!");
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }

    @Test
    public void testExplcitWaitTitleContains() {
        //Go to the Google Home Page
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");
        //Enter a term to search and submit
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("selenium");
        query.click();
        //Create Wait using WebDriverWait.
        //This will wait for 10 seconds for timeout before title is
        //updated with search term
        //If title is updated in specified time limit test will move to
        //the text step
        //instead of waiting for 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("selenium"));
        //Verify Title
        assertTrue(driver.getTitle().toLowerCase().startsWith("selenium"));
        driver.quit();
    }

    //TRY TO GET A NETWORK LATENCY INDUCER

    @Test
    public void testUntitled() throws Exception {
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.wikipedia.org/";
        driver.get(baseUrl + "/wiki/Main_Page");

        //explicit wait for search field
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));

        driver.findElement(By.id("searchInput")).clear();
        driver.findElement(By.id("searchInput")).sendKeys("India");

        driver.findElement(By.id("searchButton")).click();

    }
}

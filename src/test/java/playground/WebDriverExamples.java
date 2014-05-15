package playground;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 30/03/14
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverExamples {

    WebDriver driver;

    @After
    public void tearDown(){
        driver.quit();
    }

    @Before
    public void setup(){
        driver = new HtmlUnitDriver();
        driver.get("http://travel.agileway.net");
    }

    @Category(SmokeTests.class)
    @Test
    public void loginTest() {
        login("agileway", "testwise");
        assertEquals("Signed in", driver.findElement(By.id("flash_notice")).getText());
    }

    private void login(String uName, String pwd) {
        driver.findElement(By.id("username")).sendKeys(uName);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.name("commit")).submit();
        // Explicit
        WebElement element = driver.findElement(By.id("flash_notice"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    @Test
    public void loginAndBuy(){

    }
}

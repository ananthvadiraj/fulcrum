package examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 29/03/14
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
public class DoubleClick {

    @Test
    public void testDoubleClick() throws Exception
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://dl.dropbox.com/u/55228056/DoubleClickDemo.html");
        WebElement message = driver.findElement(By.id("message"));
        //Verify color is Blue
//        assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color").toString());
//        assertEquals("rgb(0, 0, 255)", message.getCssValue("background-color").toString());
        Actions builder = new Actions(driver);
        builder.doubleClick(message).build().perform();
        //Verify Color is Yellow
//        assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color").toString());
        driver.close();
    }
}

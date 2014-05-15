package examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertTrue;

public class MyFirstTest {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = new HtmlUnitDriver();
    }

    @Test
    public void shouldLoadGoogleHomePage() {
        driver.get("http://www.google.co.uk");
        assertTrue(driver.getTitle().contains("Google1"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

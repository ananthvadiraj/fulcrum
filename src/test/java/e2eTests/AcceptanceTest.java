package e2eTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 30/03/14
 * Time: 15:11
 * To change this template use File | Settings | File Templates.
 */
public class AcceptanceTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("http://travel.agileway.net");
    }

    @Test
    public void e2eTest(){
       // login page
        LoginPage loginPage = new LoginPage(driver);
       //login action returns Homepage
        HomePage homePage = loginPage.login("agileway","testwise");
        homePage.logOutFromHomePage();
    }

    @After
    public void tearDown(){
//        driver.quit();
    }
}

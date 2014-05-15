package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 30/03/14
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    private String LOG_OFF_LINK_TEXT = "Sign off";

    public LoginPage logOutFromHomePage(){
        driver.findElement(By.linkText(LOG_OFF_LINK_TEXT));
        return new LoginPage(driver);
    }
}

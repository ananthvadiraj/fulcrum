package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 30/03/14
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage {

    private String LOGIN_ID = "username";
    private String PASSWORD_ID = "password";
    private String SUBMIT_NAME = "commit";

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(String username, String password){
         driver.findElement(By.id(LOGIN_ID)).sendKeys(username);
         driver.findElement(By.id(PASSWORD_ID)).sendKeys(password);
         driver.findElement(By.name(SUBMIT_NAME)).submit();
         return new HomePage(driver);
    }


}

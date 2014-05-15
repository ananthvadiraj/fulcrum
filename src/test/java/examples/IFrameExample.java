package examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 29/03/14
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class IFrameExample {

    @Test
    public void testIFrame() {
        WebDriver driver = new FirefoxDriver();
        //The frame on the right side has a nested iframe containing
        //'Twitter Follow' Button
        //Activate the frame on right side using it's name attribute

        driver.switchTo().frame("right");
        //Get the iframe element
        WebElement twitterframe = driver.findElement(By.tagName("iframe"));
        //Activate the iframe
        driver.switchTo().frame(twitterframe);
        //Get and Click the follow button from iframe
        //a Popup Window will appear after click
        WebElement button = driver.findElement(By.id("follow-button"));
        button.click();
        //Store the handle of current driver window
        String currentWindow = driver.getWindowHandle();
        //The Twitter Popup does not have name or title.
        //Script will get handles of all open windows and
        //desired window will be activated by checking it's Title
        Set<String> allWindows = driver.getWindowHandles();
        if (!allWindows.isEmpty()) {
            for (String windowId : allWindows) {
                driver.switchTo().window(windowId);
                if (driver.getTitle().equals("Unmesh Gundecha (@upgundecha) on Twitter")) {
                    assertTrue("Twitter Login Popup Window Found", true);
                    driver.close();
                    break;
                }
            }
        }
        //Switch back to original driver window
        driver.switchTo().window(currentWindow);
        //switch back to Page from the frame
        driver.switchTo().defaultContent();
    }



//    <html>
//    <head><title>Test for Selenium iframe</title>
//    </head>
//    <body>
//    <div>
//    <iframe id="frame1">
//    <iframe id="frame2>
//    <body>
//    <input type="text" id="input2">UserName</input>
//    </body>
//    </iframe>
//    <body>
//    <input type="text" id="input1">Password</input>
//    </body>
//    </iframe>
//
//    <body>
//    <button name="btnG">OK<button>
//    </body>
//    </div>
//    </body>
//    </html>


    @Test
    public void sampleIframeTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///C:/Users/Ananth/Documents/Ananth/Training/IframeExample.html");
        driver.switchTo().frame("frame1");
        driver.switchTo().frame("frame2");
        driver.switchTo().defaultContent(); // you are now outside both frames
        driver.switchTo().frame((WebElement) driver.findElements(By.tagName("iframe")));
    }


}

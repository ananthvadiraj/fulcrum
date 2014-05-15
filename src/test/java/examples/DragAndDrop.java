package examples;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 29/03/14
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public class DragAndDrop {

    private static StringBuffer verificationErrors = new StringBuffer();
    private static WebDriver driver = new FirefoxDriver();

    @Test
    public void testDragDrop() {
        driver.get("http://dl.dropbox.com/u/55228056/DragDropDemo.html");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions builder = new Actions(driver);
        builder.dragAndDrop(source, target).perform();
        try {
            assertEquals("Dropped!", target.getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }


    @Test
    public void testAnotherDragDrop() {
        driver.get("http://www.theautomatedtester.co.uk/demo2.html");
        WebElement someElement = driver.findElement(By.className("draggable"));
        WebElement otherElement = driver.findElement(By.className("undropped"));
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(someElement)
                .moveToElement(otherElement)
                .release(otherElement)
                .build();
        dragAndDrop.perform();
    }
}

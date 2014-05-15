package examples;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataTest {

    @Test
    public void readDataFromExcel() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Ananth\\testDataInput.xls");
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheet("testDataSheet");
            for (int count = 1; count <= sheet.getLastRowNum(); count++) {
                HSSFRow row = sheet.getRow(count);
//                System.out.println("Running test case " + row.getCell(0).toString());
//                runTest(row.getCell(1).toString(), row.getCell(2).toString());
                loginTest(row.getCell(0).toString(), row.getCell(1).toString());
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("Test data file not found");
        }
    }

    private void loginTest(String user, String pwd) {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://travel.agileway.net");
        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pwd);
//        assertEquals("","");

//        driver.quit();
    }


    public void runTest(String strSearchString, String strPageTitle) {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(strSearchString);
        element.submit();

        if (driver.getTitle().equals(strPageTitle)) {
            System.out.println("Page title is " + strPageTitle + ", as expected");
        } else {
            System.out.println("Expected page title was " + strPageTitle + ", but was " + driver.getTitle() + " instead");
        }

        driver.quit();
    }
}

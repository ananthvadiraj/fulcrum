import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadWriteExcelTest {

    @Test
    public void readDataFromExcel() {
        try {
            // Open the Excel file
            FileInputStream fis = new FileInputStream("C:\\Users\\Ananth\\Documents\\Ananth\\Training\\testDataInput.xls");
            // Access the required test data sheet
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            HSSFSheet sheet = wb.getSheet("testDataSheet");
            // Loop through all rows in the sheet
            // Start at row 1 as row 0 is our header row
            for (int count = 1; count <= sheet.getLastRowNum(); count++) {
                HSSFRow row = sheet.getRow(count);
                System.out.println("Running test case " + row.getCell(0).toString());
                // Run the test for the current test data row
                runTest(row.getCell(1).toString(), row.getCell(2).toString());
            }
            fis.close();
        } catch (IOException e) {
            System.out.println("Test data file not found");
        }
    }


    public void runTest(String strSearchString, String strPageTitle) {
        // Start a browser driver and navigate to Google
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.google.com");

        // Enter the search string and send it
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(strSearchString);
        element.submit();

        // Check the title of the page
        if (driver.getTitle().equals(strPageTitle)) {
            System.out.println("Page title is " + strPageTitle + ", as expected");
        } else {
            System.out.println("Expected page title was " + strPageTitle + ", but was " + driver.getTitle() + " instead");
        }

        //Close the browser
        driver.quit();
    }
}

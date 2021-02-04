package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

public class US3 extends TestBase {


    @Test
    public void testSettings(){
     WebElement fileModule = driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']"));
     BrowserUtils.wait(4);
     fileModule.click();


    }
}

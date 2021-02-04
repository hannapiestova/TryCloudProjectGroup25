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

        driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']")).click();
     BrowserUtils.wait(4);

     driver.findElement(By.xpath("//button[@class='settings-button']")).click();
     BrowserUtils.wait(4);




    }
}

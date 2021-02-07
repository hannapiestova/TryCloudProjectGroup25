package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class US3 extends TestBase {


    @Test
    public void testSettings(){
        driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']")).click();
     BrowserUtils.wait(4);

     driver.findElement(By.xpath("//button[@class='settings-button']")).click();
     BrowserUtils.wait(4);

        WebElement checkbox1 = driver.findElement(By.xpath("//label[@for='showRichWorkspacesToggle']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//label[@for='recommendationsEnabledToggle']"));
        WebElement checkbox3 = driver.findElement(By.xpath("//label[text()='Show hidden files']"));

       checkbox1.click();
       BrowserUtils.wait(1);
       checkbox2.click();
       BrowserUtils.wait(1);
       checkbox3.click();
       BrowserUtils.wait(1);

       Assert.assertTrue( !checkbox1.isSelected() && !checkbox2.isSelected() && !checkbox3.isSelected());




    }


    @Test
    public void testStorage()  {
        driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']")).click();
        BrowserUtils.wait(1);
        String txt =driver.findElement(By.xpath("//*[text()='0 B used']")).getText();
        driver.findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/mykytakharchenko/Desktop/download.jpg");
        BrowserUtils.wait(1);
        driver.navigate().refresh();
        BrowserUtils.wait(1);
        String txt2 =driver.findElement(By.xpath("//a[@class='icon-quota svg']")).getText();
        Assert.assertFalse(txt.equals(txt2));



    }
}

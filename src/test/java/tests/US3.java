package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.Driver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class US3 extends TestBase {


    @Test(priority = 1)
    public void testSettings(){
        Driver.get().findElement(By.xpath("//a[@href='/index.php/apps/files/']")).click();
        BrowserUtils.wait(4);
        Driver.get().findElement(By.xpath("//button[@class='settings-button']")).click();
        BrowserUtils.wait(4);

        WebElement checkbox1 = Driver.get().findElement(By.xpath("//label[@for='showRichWorkspacesToggle']"));
        WebElement checkbox2 = Driver.get().findElement(By.xpath("//label[@for='recommendationsEnabledToggle']"));
        WebElement checkbox3 = Driver.get().findElement(By.xpath("//label[text()='Show hidden files']"));

       checkbox1.click();
       BrowserUtils.wait(1);
       checkbox2.click();
       BrowserUtils.wait(1);
       checkbox3.click();
       BrowserUtils.wait(1);

       Assert.assertTrue( !checkbox1.isSelected() && !checkbox2.isSelected() && !checkbox3.isSelected());




    }


    @Test(priority = 2)
    public void testStorage()  {
        Driver.get().findElement(By.xpath("//a[@href='/index.php/apps/files/']")).click();
        BrowserUtils.wait(1);
        String txt =Driver.get().findElement(By.xpath("//a[@class='icon-quota svg']")).getText();
        Driver.get().findElement(By.xpath("//a[@class='button new']")).click();
        BrowserUtils.wait(1);
        Driver.get().findElement(By.xpath("//input[@type='file']")).sendKeys("/Users/mykytakharchenko/Desktop/download.jpg");
        BrowserUtils.wait(1);
        Driver.get().navigate().refresh();
        BrowserUtils.wait(1);
        String txt2 =Driver.get().findElement(By.xpath("//a[@class='icon-quota svg']")).getText();
        Assert.assertFalse(txt.equals(txt2));



    }
}

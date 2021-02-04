package tests;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BrowserUtils;


public class US3 extends TestBase {


    @Test
    public void testSettings(){
        driver.findElement(By.xpath("//a[@href='/index.php/apps/files/']")).click();
     BrowserUtils.wait(4);

     driver.findElement(By.xpath("//button[@class='settings-button']")).click();
     BrowserUtils.wait(4);

     WebElement checkbox = driver.findElement(By.xpath("//label[@for='showhiddenfilesToggle']"));
     if(!checkbox.isSelected()){
         checkbox.click();
     }

     BrowserUtils.wait(4);

        Assert.assertTrue(checkbox.isSelected());


    }


    @Test
    public void testStorage(){

        String txt =driver.findElement(By.id("quotatext")).getText();
        BrowserUtils.wait(4);
        driver.findElement(By.xpath("//span[@class='icon icon-add']")).click();
        BrowserUtils.wait(4);
        driver.findElement(By.xpath("//span[text()='Upload file']")).sendKeys("/Users/mykytakharchenko/Desktop/download.jpg");;

        BrowserUtils.wait(2);
        String txt2 =driver.findElement(By.id("quotatext")).getText();

        Assert.assertNotEquals(txt, txt2);



    }
}

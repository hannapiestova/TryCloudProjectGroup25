package tests;

import base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;

import javax.sql.rowset.BaseRowSet;

public class US1 extends TestBase {


    Faker faker = new Faker();
    LogInPage logInPage = new LogInPage();
    String username = ConfigurationReader.getProperty("username2");
    String password = ConfigurationReader.getProperty("password");
    String negUserName = faker.name().username();
    String negPassword = faker.internet().password();


    @Test
    public void positiveLogIn(){
        logInPage.logIng(username,password);
        Assert.assertTrue(driver.getCurrentUrl().equals("http://qa2.trycloud.net/index.php/apps/dashboard/"));
    }

    @Test
    public void negativeLogIn(){
        logInPage.negLogIn(negUserName, negPassword);
        Assert.assertTrue(driver.getPageSource().contains("Wrong username or password"));
    }


    @Test
    public void forgotPasswordTest(){
        logInPage.forgotPassword();
        BrowserUtils.wait(2);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id = 'reset-password-submit']")).isDisplayed());
    }
}

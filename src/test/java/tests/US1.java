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
import utilities.Driver;

import javax.sql.rowset.BaseRowSet;

public class US1 extends TestBase {

    @Test(priority = 1)
    public void positiveLogIn(){
        LogInPage logInPage = new LogInPage();
        String username = ConfigurationReader.getProperty("username2");
        String password = ConfigurationReader.getProperty("password");
        logInPage.logIn(username,password);
        String current = Driver.get().getTitle();
        Assert.assertTrue(Driver.get().getTitle().equals(current));

        logInPage.logout();
    }

    @Test(priority = 2)
    public void negativeLogIn(){
        LogInPage logInPage = new LogInPage();
        Faker faker = new Faker();
        String negUserName = faker.name().username();
        String negPassword = faker.internet().password();
        logInPage.negLogIn(negUserName, negPassword);
        Assert.assertTrue(Driver.get().getPageSource().contains("Wrong username or password"));
    }


    @Test(priority = 3)
    public void forgotPasswordTest(){
        LogInPage logInPage = new LogInPage();
        logInPage.forgotPassword();
        BrowserUtils.wait(2);
        Assert.assertTrue(Driver.get().findElement(By.xpath("//input[@id = 'reset-password-submit']")).isDisplayed());
    }
}

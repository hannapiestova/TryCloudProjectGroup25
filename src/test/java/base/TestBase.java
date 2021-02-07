package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {

    public WebDriver driver = Driver.get();
    LogInPage logInPage = new LogInPage();
    String username = ConfigurationReader.getProperty("username3");
    String passwrod = ConfigurationReader.getProperty("password");

    @BeforeMethod
    public void setUpMethod(){
        driver.get(ConfigurationReader.getProperty("url1"));
        logInPage.logIn(username,passwrod);
    }




    @AfterMethod
    public void tearDown(){
        Driver.close();
    }
}

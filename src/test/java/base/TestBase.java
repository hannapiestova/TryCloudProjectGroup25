package base;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {

    public WebDriver driver = Driver.get();
    public Faker faker = new Faker();
    public LogInPage logInPage = new LogInPage();


    @BeforeMethod
    public void setUpMethod(){

        driver.get(ConfigurationReader.getProperty("url1"));

    }





    @AfterMethod
    public void tearDown(){
        Driver.close();
    }
}

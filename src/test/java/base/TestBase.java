package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {

    public WebDriver driver = Driver.get();


    @BeforeMethod
    public void setUpMethod(){

        driver.get(ConfigurationReader.getProperty("url"));

    }





    @AfterMethod
    public void tearDown(){
        Driver.close();
    }
}

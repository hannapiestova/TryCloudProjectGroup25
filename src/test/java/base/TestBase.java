package base;

import org.openqa.selenium.WebDriver;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {

    public WebDriver driver = Driver.get();


    public void setUpMethod(){

        Driver.get().get(ConfigurationReader.getProperty("url"));


    }
}

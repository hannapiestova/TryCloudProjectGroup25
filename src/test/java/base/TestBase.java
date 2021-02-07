package base;


import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public abstract class TestBase {

    @BeforeMethod
    public void setUpMethod(){
        Driver.get().get(ConfigurationReader.getProperty("url1"));
        BrowserUtils.wait(1);
    }



    @AfterMethod
    public void tearDown(){
        Driver.close();
    }
}

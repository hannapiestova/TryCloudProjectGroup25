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





    @BeforeClass
    public void setUpMethod(){
     //   LogInPage logInPage = new LogInPage();
    //    String username1 = ConfigurationReader.getProperty("username3");
      //  String password1 = ConfigurationReader.getProperty("password");
        Driver.get().get(ConfigurationReader.getProperty("url1"));
     //   logInPage.logIn(username1,password1);
    }




    @AfterClass
    public void tearDown(){
        Driver.close();
    }
}

package base1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public abstract class Test {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Navigate to login page http://qa.trycloud.net/index.php/login?clear=1
        driver.get(ConfigurationReader.getProperty("url2"));
        //Enter valid username
        WebElement userName = driver.findElement(By.id("user"));
        userName.sendKeys(ConfigurationReader.getProperty("username1"));
        //Enter valid password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        //Click login button
        WebElement logInPage = driver.findElement(By.id("submit-form"));
        logInPage.click();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}



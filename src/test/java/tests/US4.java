package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TryCloudUtil;

public class US4 {
    WebDriver driver = Driver.get();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.getProperty("url0"));
        TryCloudUtil.LogInTryCloud(driver);
    }

    @Test(priority = 1)
    public void TC1_verification_title() {
        //2. Click Talks module
        Driver.get().findElement(By.xpath("(//*[@aria-label='Talk'])[1]")).click();
        //3. Verify the page tile is Talks module's tile
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Talk - Trycloud QA";
        Assert.assertTrue(actualPageTitle.equals(expectedPageTitle), "Actual page does not equal to expected Page title!!");
    }

    @Test(priority = 2)
    public void TC2_verification_send_message() {
        // Click Talks module
        Driver.get().findElement(By.xpath("(//*[@aria-label='Talk'])[1]")).click();
        BrowserUtils.wait(1);
        //3. Search a "user" from search box on the left
        //Option
        //  WebElement option = Driver.get().findElement(By.xpath("//div//*[@class='app-navigation-toggle']"));
        //search
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("user100");
        //enter user100
        driver.findElement(By.xpath("//*[@class='acli__content__line-one__title']")).click();
        //4. Creating a faker to write a message
        String message = faker.lorem().fixedString(5);
        //5. Click submit button
        driver.findElement(By.xpath("//div[@contenteditable='true']")).sendKeys(message + Keys.ENTER);
        //6. Verify the message is displayed on the conversation log
        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[text()='" + message + "']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        Driver.close();
    }
}
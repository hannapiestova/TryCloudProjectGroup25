package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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


    @BeforeClass
    public void setUp() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        TryCloudUtil.LogInTryCloud(driver);
    }

    @BeforeMethod
    public void sleep() {
        BrowserUtils.wait(3);
    }


    @Test(priority = 1)
    public void TC1_verification_title() {


        //2. Click Talks module
        WebElement TalksModule = driver.findElement(By.xpath("(//*[@aria-label='Talk'])[1]"));
        TalksModule.click();
        //3. Verify the page tile is Talks module’s tile
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle = "Talk - Trycloud";
        Assert.assertTrue(actualPageTitle.equals(expectedPageTitle), "Actual page does not equal to expected Page title!!");

        System.out.println("expectedTitle = " + expectedPageTitle);
        System.out.println("actualPageTitle = " + actualPageTitle);
    }
    @Test (priority = 2)
    public void TC2_verification_send_message() {
        //2. Click Talks module
        WebElement TalksModule = driver.findElement(By.xpath("(//*[@aria-label='Talk'])[1]"));
        TalksModule.click();
        BrowserUtils.wait(2);

        //3. Search a "user" from search box on the left
        //Option
        WebElement option = driver.findElement(By.xpath("//div//*[@class='app-navigation-toggle']"));
        //search
        WebElement searchbox = driver.findElement(By.xpath("//input[@type='text']"));
        //enter user100
        searchbox.sendKeys("user100");

        WebElement user = driver.findElement(By.xpath("//*[@class='acli__content__line-one__title']"));
        user.click();

        //4. Creating a faker to write a message
        String message = faker.lorem().fixedString(5);
        driver.findElement(By.xpath("//div[@contenteditable='true']")).sendKeys(message);

        //5. Click submit button
        WebElement SubmitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        SubmitButton.click();


        //6. Verify the message is displayed on the conversation log

        /*WebElement expectedMessage = driver.findElement(By.xpath("(//*[@class='acli__content__line-two__subtitle'])[1]"));
        String actualMessage = message;

        Assert.assertTrue(actualMessage.equals(expectedMessage), "failed");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@rich-text--wrapper='"+message+"']")).isDisplayed(),"Test failed");


         */
    }

    @AfterMethod
    public void tearDown()  { Driver.close(); }
}

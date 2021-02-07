package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TryCloudUtil;

public class US5 {

    WebDriver driver = Driver.get();
    Faker faker = new Faker();

    // new contact WebElement under Contact moodule


    @BeforeClass
    public void setUp(){
            Driver.get().get(ConfigurationReader.getProperty("url1"));
            TryCloudUtil.LogInTryCloud(driver);
        }

    @BeforeMethod
    public void sleep(){
       BrowserUtils.wait(5);
    }

    @Test
    public void TC1(){
        //Test case #1 - verify users can access to Talks module
        // Click “Contacts” module
        TryCloudUtil.clickContactsModule(driver);

        // 3.Verify the page tile is Contents module’s tile
        String contactsPageTitle=driver.getTitle();
        Assert.assertTrue(contactsPageTitle.contains("Contacts"));
    }

    @Test
    public void TC2(){
        //  Test case #2 - verify users can add contacts
        //  2.Click contacts module
        TryCloudUtil.clickContactsModule(driver);

        //  3.Click “New Contact” button
        //  4.Fill out the contact info like : Title, Phone, email, address , etc
        TryCloudUtil.CreatingNewContact(driver);

        //  5.Verify the contact name is added to the contact list
        WebElement newContact=driver.findElement(By.xpath("//body[@id='body-user']"));
        Assert.assertTrue(newContact.isDisplayed());
    }

    @Test
    public void TC3(){
        //Test case #3 - verify users can see all the contact names on the contact list
        // 2.Click contacts module
        TryCloudUtil.clickContactsModule(driver);

        // 3.Verify the contact names are in the list (Pre-condition: there should be at least 2 contact names are displayed On the contact list)

        //Creating 2 contacts
        TryCloudUtil.CreatingNewContact(driver);
        WebElement company=driver.findElement(By.xpath("//input[@id='contact-org']"));
        company.sendKeys("Test1");
        BrowserUtils.wait(5);

        TryCloudUtil.CreatingNewContact(driver);
        company.sendKeys("Test2");
        BrowserUtils.wait(5);

        Assert.assertTrue(driver.getPageSource().contains("Test1"));
        Assert.assertTrue(driver.getPageSource().contains("Test2"));

    }

    @AfterClass
    public void tearDownMethod()  {
        Driver.close();
    }


    }











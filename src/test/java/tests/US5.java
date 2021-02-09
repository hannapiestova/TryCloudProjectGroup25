package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ContactModule;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TryCloudUtil;


public class US5 {

    ContactModule contactModule=new ContactModule();

    WebDriver driver=Driver.get();

    @BeforeClass
    public void setUp(){
            Driver.get().get(ConfigurationReader.getProperty("url1"));
            TryCloudUtil.LogInTryCloud();
        }

    @BeforeMethod
    public void sleep(){
       BrowserUtils.wait(5);
    }

    @Test (priority = 1, description = "access to contact module")
    public void TC1(){
        //Test case #1 - verify users can access to Talks module
        // Click “Contacts” module
        contactModule.clickContactsModule();

        // 3.Verify the page tile is Contents module’s tile
        String contactsPageTitle=driver.getTitle();
        Assert.assertTrue(contactsPageTitle.contains("Contacts"));
    }

    @Test (priority = 2, description = "Creating new contact")
    public void TC2(){
        //  Test case #2 - verify users can add contacts
        //  2.Click contacts module
       contactModule.clickContactsModule();

        //  3.Click “New Contact” button
        //  4.Fill out the contact info like : Title, Phone, email, address , etc
       contactModule.CreatingNewContact();

        //  5.Verify the contact name is added to the contact list
        WebElement newContact=driver.findElement(By.xpath("//body[@id='body-user']"));
        Assert.assertTrue(newContact.isDisplayed());
    }

    @Test (priority = 3, description = "Verifying if new contact is created")
    public void TC3(){
        //Test case #3 - verify users can see all the contact names on the contact list
        // 2.Click contacts module
        contactModule.clickContactsModule();

        // 3.Verify the contact names are in the list (Pre-condition: there should be at least 2 contact names are displayed On the contact list)

        //Creating 2 contacts
        contactModule.CreatingNewContact();

        contactModule.companyInput.sendKeys("Test1");
        BrowserUtils.wait(5);

        contactModule.CreatingNewContact();
        contactModule.companyInput.sendKeys("Test2");
        BrowserUtils.wait(5);

        Assert.assertTrue(driver.getPageSource().contains("Test1"));
        Assert.assertTrue(driver.getPageSource().contains("Test2"));

    }

    @AfterClass
    public void tearDownMethod()  {
        Driver.close();
    }


    }











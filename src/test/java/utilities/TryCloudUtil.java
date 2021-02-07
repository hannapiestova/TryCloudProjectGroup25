package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TryCloudUtil {

    public static void LogInTryCloud(WebDriver driver){
        //enter username
        WebElement username = driver.findElement(By.xpath("//input[@id='user']"));
        username.sendKeys(ConfigurationReader.getProperty("username1"));

        //enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));

        //click login
        WebElement logIn = driver.findElement(By.xpath("//input[@id='submit-form']"));
        logIn.click();
    }

    // click on “Contacts” module
    public static void clickContactsModule(WebDriver driver){
   WebElement contactsModule= driver.findElement(By.xpath("(//a[@aria-label='Contacts'])[1]"));
   contactsModule.click();
   BrowserUtils.wait(3);
    }

    // creating new contact, fill in contact form
    public static void CreatingNewContact(WebDriver driver){
        Faker faker=new Faker();
        WebElement NewContact= driver.findElement(By.xpath("//button[@id='new-contact-button']"));
        NewContact.click();

        // Enter phone number
        WebElement Phone=driver.findElement(By.xpath("//input[@inputmode='tel']"));
        String phoneNumberFaker=faker.phoneNumber().phoneNumber();
        Phone.sendKeys(phoneNumberFaker);

        //Enter email
        WebElement Email=driver.findElement(By.xpath("//input[@inputmode='email']"));
        String emailFaker=faker.internet().emailAddress();
        Email.sendKeys(emailFaker);

        //Enter post office box
        WebElement postOfficeBox=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[2]/input"));
        String postOfficeBoxFaker=faker.address().buildingNumber();
        postOfficeBox.sendKeys(postOfficeBoxFaker);

        //Enter address
        WebElement address=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[3]/input"));
        String addressFaker=faker.address().streetAddress();
        address.sendKeys(addressFaker);

        //Enter extended address
        WebElement extendedAddress=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[4]/input"));
        String extendedAddressFaker=faker.address().secondaryAddress();
        extendedAddress.sendKeys(extendedAddressFaker);

        //Enter PostCode
        WebElement postCode=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[5]/input"));
        String postCodeFaker=faker.address().zipCode();
        postCode.sendKeys(postCodeFaker);

        // Enter City
        WebElement city=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[6]/input"));
        String cityFaker=faker.address().city();
        city.sendKeys(cityFaker);

        //Enter State
        WebElement state=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[7]/input"));
        String stateFaker=faker.address().state();
        state.sendKeys(stateFaker);

        //Enter Country
        WebElement country=driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[8]/input"));
        String countryFaker=faker.address().country();
        country.sendKeys(countryFaker);

    }

}

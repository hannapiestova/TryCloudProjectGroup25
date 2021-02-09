package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class ContactModule {
    WebDriver driver= Driver.get();

    public ContactModule(){
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "(//a[@aria-label='Contacts'])[1]")
    public WebElement contactModulePage;

    @FindBy(xpath = "//button[@id='new-contact-button']")
    public WebElement NewContactInput;


    // locators for New Contacts
    @FindBy(xpath = "//input[@inputmode='tel']")
    public WebElement PhoneInput;

    @FindBy(xpath = "//input[@inputmode='email']")
    public WebElement EmailInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[2]/input")
    public WebElement postOfficeBoxInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[3]/input")
    public WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[4]/input")
    public WebElement extendedAddressInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[5]/input")
    public WebElement postCodeInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[6]/input")
    public WebElement cityInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[7]/input")
    public WebElement stateInput;

    @FindBy(xpath = "//*[@id=\"app-content-wrapper\"]/div[2]/section/div[3]/div/div[8]/input")
    public WebElement countryInput;

    @FindBy(xpath = "//input[@id='contact-org']")
    public WebElement companyInput;

    // click on “Contacts” module
    public void clickContactsModule(){
        contactModulePage.click();
        BrowserUtils.wait(3);
    }

    // creating new contact, fill in contact form
    public  void CreatingNewContact(){
        Faker faker=new Faker();

        NewContactInput.click();

        // Enter phone number
        String phoneNumberFaker=faker.phoneNumber().phoneNumber();
        PhoneInput.sendKeys(phoneNumberFaker);

        //Enter email
        String emailFaker=faker.internet().emailAddress();
        EmailInput.sendKeys(emailFaker);

        //Enter post office box
        String postOfficeBoxFaker=faker.address().buildingNumber();
        postOfficeBoxInput.sendKeys(postOfficeBoxFaker);

        //Enter address
        String addressFaker=faker.address().streetAddress();
        addressInput.sendKeys(addressFaker);

        //Enter extended address
        String extendedAddressFaker=faker.address().secondaryAddress();
        extendedAddressInput.sendKeys(extendedAddressFaker);

        //Enter PostCode
        String postCodeFaker=faker.address().zipCode();
        postCodeInput.sendKeys(postCodeFaker);

        // Enter City
        String cityFaker=faker.address().city();
        cityInput.sendKeys(cityFaker);

        //Enter State
        String stateFaker=faker.address().state();
        stateInput.sendKeys(stateFaker);

        //Enter Country
        String countryFaker=faker.address().country();
        countryInput.sendKeys(countryFaker);

    }















}

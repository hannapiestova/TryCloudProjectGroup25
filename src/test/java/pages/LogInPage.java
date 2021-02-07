package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import javax.swing.*;
import java.util.*;

public class LogInPage {


    @FindBy(id = "user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(id = "submit-form")
    public WebElement logInButton;

    @FindBy(id = "lost-password")
    public WebElement forgotPassword;

    @FindBy(xpath = "//div[@class='avatardiv avatardiv-shown']" )
    public WebElement avatar;

    @FindBy(xpath = "//ul/li[@data-id ='logout']")
    public  WebElement logOut;

     public LogInPage(){
        PageFactory.initElements(Driver.get(), this);
    }

     public void logIn(String username , String password){
         userName.sendKeys(username);
         BrowserUtils.wait(1);
         passWord.sendKeys(password);
         BrowserUtils.wait(1);
         logInButton.click();
     }

     public void negLogIn(String negUserName ,String negPassword ){
        userName.sendKeys(negUserName);
         BrowserUtils.wait(1);
        passWord.sendKeys(negPassword);
         BrowserUtils.wait(1);
        logInButton.click();
     }

     public void forgotPassword(){
        BrowserUtils.wait(3);
        forgotPassword.click();
     }

     public void logout(){

         avatar.click();
         BrowserUtils.wait(1);
         logOut.click();
     }

}

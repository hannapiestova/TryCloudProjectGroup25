package tests.userStory2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class UserStory2 extends base.Test {

    SoftAssert sa = new SoftAssert();

    @AfterClass
    public void teardownClass() {
        System.out.println("------>After class is running...");
    }

    @Test
    public void accessMainModules() throws InterruptedException {

        //2. Verify the user see the following modules:

        //Dashboard

        WebElement dashboard = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
        sa.assertTrue(dashboard.isDisplayed(),"Dashboard did not displayed");
        sa.assertEquals(dashboard.getAttribute("aria-label"),"Dashboard","Element has a different name");

        /*Soft Assertions are the type of assertions that do not throw an exception when an assertion fails
        and would continue with the next step after assert statement.*/



        //Files

        WebElement files = driver.findElement(By.xpath("//ul[@id='appmenu']/li[2]/a"));
        sa.assertTrue(files.isDisplayed(),"Files did not displayed");
        sa.assertEquals(files.getAttribute("value"),"Files","Element has a different name");


        //Galleries
        WebElement galleries = driver.findElement(By.xpath("//ul[@id='appmenu']/li[3]"));
        sa.assertTrue(galleries.isDisplayed(),"Galleries did not displayed");
        sa.assertEquals(galleries.getText(),"Galleries","Element has a different name");
        //( Expected module name: Galleries
        //Actual module name : Photos )

        //Activity
        //WebElement activity = driver.findElement(By.xpath("//ul[@id='appmenu']/li[3]"));
        WebElement activity = driver.findElement(By.xpath("//div[@id='apps']/ul/li[4]"));
        sa.assertTrue(activity.isDisplayed(),"Activity did not displayed");
        sa.assertEquals(activity.getText(),"Activity","Element has a different name");

        //Talk
        WebElement talk = driver.findElement(By.xpath("//ul[@id='appmenu']/li[5]"));
        sa.assertTrue(talk.isDisplayed(),"Talk did not displayed");
        sa.assertEquals(talk.getText(),"Talk","Element has a different name");

        //Contacts
        WebElement contacts = driver.findElement(By.xpath("//ul[@id='appmenu']/li[6]"));
        sa.assertTrue(contacts.isDisplayed(),"Contacts did not displayed");
        sa.assertEquals(contacts.getText(),"Contacts","Element has a different name");

        //Circles
        WebElement circles = driver.findElement(By.xpath("//ul[@id='appmenu']/li[7]"));
        sa.assertTrue(circles .isDisplayed(),"Circles did not displayed");
        sa.assertEquals(circles .getText(),"Circles","Element has a different name");
        //Calendar
        WebElement calendar = driver.findElement(By.xpath("//ul[@id='appmenu']/li[8]"));
        sa.assertTrue(calendar.isDisplayed(),"Calendar did not displayed");
        sa.assertEquals(calendar.getText(),"Calendar","Element has a different name");

         //Deck
        WebElement deck = driver.findElement(By.xpath("//ul[@id='appmenu']/li[9]"));
        sa.assertTrue(deck.isDisplayed(),"Deck did not displayed");
        sa.assertEquals(deck.getText(),"Deck","Element has a different name");





    }




}

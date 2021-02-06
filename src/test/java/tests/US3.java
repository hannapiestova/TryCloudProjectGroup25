package tests;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TryCloudUtil;

public class US3 {

    WebDriver driver = Driver.get();
    Faker faker = new Faker();
    // // // new contact WebElement under Contact module

    @BeforeClass
    public void setUp(){
        Driver.get().get(ConfigurationReader.getProperty("url1"));
        TryCloudUtil.LogInTryCloud(driver);
    }


    @BeforeMethod
    public void sleep(){
        BrowserUtils.wait(1);
    }


    @Test(priority = 1)
    public void TC1(){
        //Test case #1 - verify users can access to Files module
        //1. Login as a user //
        // TryCloudUtil.LogInTryCloud(driver);
        driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        //2. Verify the page tile is Files module's tile
        String actualTitleFiles = driver.getTitle();
        // Asserts method to verificate title and String message.
        Assert.assertTrue(actualTitleFiles.contains("Files"), "Verification title Failed");
    }
    @Test(priority = 2)
    public void TC2() throws InterruptedException {
        //Test case #2 - verify users can select all the uploaded files from the page
        //1. Login as a user
        // TryCloudUtil.LogInTryCloud(driver);
        // go to Files
        driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.wait(1);
        //2. Click the top left checkbox of the table
        driver.findElement(By.xpath("//*[@id=\"headerSelection\"]/label")).click();
        //3. Assert all the files are selected
        boolean selected1 = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[1]/label")).isSelected();
        boolean selected2 = driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[2]/td[1]/label")).isSelected();
        BrowserUtils.wait(1);
        Assert.assertTrue(selected1,"Not selected");
        Assert.assertTrue(selected2,"Not selected");
        //fail

        //(Pre-condition: there should be at least 2 files are uploaded the page)
    }

    @Test(priority = 3)
    public void TC3() {
        // NOT POSSIBLE TO TEST NO ICON "Add to Favorites"

        //Test case #3 - verify users can add a file to favorites.
        //1. Login as a user
        // TryCloudUtil.LogInTryCloud(driver);
    //    driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        //2. Click action-icon from any file on the page
    //  driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[1]/label")).click();
        //3. Choose "Add to Favorites" option
        // no "Add to Favorites" option
        //4. Click "Favorites" sub-module on the lest side
        //5. Verify the chosen file is listed on the table
        //(Pre-condition: there should be at least 1 file is uploaded)

    }
    @Test(priority = 4)
    public void TC4() {
        // NOT POSSIBLE TO TEST NO ICON  "Remove from Favorites"

        //Test case #4 - verify users can remove a file from favorites.
        //1. Login as a user
        // TryCloudUtil.LogInTryCloud(driver);
    //    driver.findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        //2. Click action-icon from any file on the page
    //    driver.findElement(By.xpath("//*[@id=\"fileList\"]/tr[1]/td[1]/label")).click();
        //3. Click "Remove from Favorites" option
        //  no  ""Remove from Favorites""
        //4. Verify that the file is removed from Favorites sub-module's table.
        //(Pre-condition: there should be at least 1 file is added to favorites table)

    }
    @Test(priority = 5)
    public void TC5() {
    //Test case #5 - verify users can upload a file directly to the homepage (File-Uploading)
    // 1. Login as a user
    // TryCloudUtil.LogInTryCloud(driver);
        // go to Files

        // path of file
        String filePatch = "/Users/vladyslavpaliy/Desktop/Screen Shot 2021-02-05 at 15.16.28xzdsa.png";

        Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.wait(1);
    // 2. Click the "+" icon on top
        Driver.get().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/a")).click();
        BrowserUtils.wait(1);
    //3. Click "upload file"
        WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label"));
        BrowserUtils.wait(1);
    //4. Upload a file
        chooseFile.sendKeys(filePatch);
        // fail

    //5. Verify the file is displayed on the page

    }

    @Test(priority = 6)
    public void TC6() {
//Test case #6 - verify users can create a folder
//1. Login as a user
        // go to Files
        Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.wait(1);
//2. Click the "+" icon on top
        Driver.get().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/a")).click();
        BrowserUtils.wait(1);
//3. Click "New Folder"
        Driver.get().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[2]/a")).click();
        BrowserUtils.wait(1);
//4. Write a folder name
        Driver.get().findElement(By.xpath("//*[@id=\"view13-input-folder\"]")).clear();
        BrowserUtils.wait(1);
        String nameOfFolder = faker.name().firstName();
        Driver.get().findElement(By.xpath("//*[@id=\"view13-input-folder\"]")).sendKeys(nameOfFolder+Keys.ENTER);
        BrowserUtils.wait(1);
//5. Click submit icon
       //  Driver.get().findElement(By.xpath("//*[@id=\"view13-input-folder\"]")).sendKeys("Folder name"+Keys.ENTER);
//6. Verify the folder is displayed on the page

        //fail
    }
    @Test(priority = 7)
    public void TC7() {

//Test case #7 - verify users can upload a file inside a folder
//1. Login as a user
        // go to Files
        Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.wait(1);
//2. Choose a folder from the page
        Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr[2]/td[2]/a/span[1]/span")).click();
//3. Click the "+" icon on top
        Driver.get().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/a")).click();
//4. Click "upload file"
        String filePatch = "/Users/vladyslavpaliy/Desktop/Screen Shot 2021-02-05 at 15.16.28xzdsa.png";
        WebElement chooseFile = driver.findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[1]/label/span[2]"));
//5. Upload a file
        chooseFile.click();
        chooseFile.sendKeys(filePatch);

        // fail

//6. Verify the file is displayed on the page
//(Pre-condition: there should be at least 1 folder is created on the filers page)

    }
    @Test(priority = 8)
    public void TC8() {
//Test case #8 - verify users can delete a file/folder.
//1. Login as a user
        // go to Files
        Driver.get().findElement(By.xpath("//*[@id=\"appmenu\"]/li[2]/a")).click();
        BrowserUtils.wait(1);

        //First create file
        Driver.get().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/a")).click();
        WebElement newFile = Driver.get().findElement(By.xpath("//*[@id=\"controls\"]/div[2]/div[2]/ul/li[3]/a/span[2]"));
        newFile.click();
        WebElement nameOfFile = Driver.get().findElement(By.xpath("//*[@id=\"view13-input-x-office-document\"]"));
        nameOfFile.clear();
        nameOfFile.sendKeys("AFile"+Keys.ENTER);

//2. Click action-icon from any file on the page
Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr[4]/td[2]/a/span[2]/a[2]")).click();
//3. Choose "delete files" option
//4. Click deleted files on the left bottom corner
        Driver.get().findElement(By.xpath("//*[@id=\"fileList\"]/tr[4]/td[2]/div/ul/li[8]/a/span[2]")).click();
//5. Verify the deleted file is displayed on the page.

//(Pre-condition: there should be at least 1 file is uploaded inside files page)

    }

   // @AfterClass
  //  public void close(){driver.quit();}
}
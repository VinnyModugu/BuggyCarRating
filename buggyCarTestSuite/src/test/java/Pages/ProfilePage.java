package Pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Readpropetyfile;

import java.io.IOException;

public class ProfilePage extends BaseTest {

    @FindBy(xpath = "//input[@id='gender']")
    WebElement Gender;
    @FindBy(xpath = "//input[@id='age']")
    WebElement Age;
    @FindBy(xpath = "//textarea[@id='address']")
    WebElement Address;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    WebElement Phone;
    @FindBy(xpath = "/html/body/my-app/div/main/my-profile/div/form/div[2]/div/button")
    WebElement Savebutton;
    @FindBy(xpath = "//div[@class='result alert alert-success hidden-md-down']")
    WebElement ProfileUpdateMsg;


    Readpropetyfile read = new Readpropetyfile();


    public ProfilePage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public String ProfileUpdate() throws IOException, InterruptedException {

        Thread.sleep(5000);
        Gender.sendKeys(read.getData("Sheet1",1,4));
        Age.sendKeys(read.getData("Sheet1",1,5));
        Address.sendKeys(read.getData("Sheet1",1,6));
        Phone.sendKeys(read.getData("Sheet1",1,7));
        Savebutton.click();
        Thread.sleep(5000);
        return(ProfileUpdateMsg.getText());
    }
}

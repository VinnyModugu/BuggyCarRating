package Pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Readpropetyfile;

import java.io.IOException;

public class RegistryPage extends BaseTest {

    Readpropetyfile read = new Readpropetyfile();

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/form/a")
    WebElement HomePageRegistryButton;
    @FindBy(id = "username")
    WebElement Username;
    @FindBy(id = "firstName")
    WebElement Firstname;
    @FindBy(id = "lastName")
    WebElement Lastname;
    @FindBy(id = "password")
    WebElement Password;
    @FindBy(id = "confirmPassword")
    WebElement ConfirmPassword;
    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/button")
    WebElement RegisterButton ;
    @FindBy(xpath = "/html/body/my-app/div/main/my-register/div/div/form/div[6]")
    WebElement RegisterSuccessMsg ;

    public RegistryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String registryUser() throws IOException, InterruptedException {
        Thread.sleep(5000);

        HomePageRegistryButton.click();
        Username.sendKeys(read.getData("Sheet1",1,0));
        Firstname.sendKeys(read.getData("Sheet1",1,1));
        Lastname.sendKeys(read.getData("Sheet1",1,2));
        Password.sendKeys(read.getData("Sheet1",1,3));
        ConfirmPassword.sendKeys(read.getData("Sheet1",1,3));
        Thread.sleep(5000);
        RegisterButton.click();
        Thread.sleep(5000);
        String SuccessMsg = RegisterSuccessMsg.getText();
        return(SuccessMsg);
    }


}

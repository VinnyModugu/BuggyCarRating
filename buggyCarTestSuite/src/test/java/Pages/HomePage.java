package Pages;

import base.BaseTest;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Readpropetyfile;

import java.io.IOException;

import static org.openqa.selenium.support.How.*;

public class HomePage extends BaseTest {
    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/form/button")
    WebElement LoginButton;
    @FindBy(css = "div input[name=login]")
    WebElement Username;

    @FindBy(css = "div input[name=password]")
    WebElement Password;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/ul/li[1]/span")
    WebElement LoginMsg;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/ul/li[2]/a")
    WebElement ProfileButton;


    Readpropetyfile read = new Readpropetyfile();


    public HomePage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public String Login() throws IOException, InterruptedException {

        Thread.sleep(5000);
        Username.sendKeys(read.getData("Sheet1",1,0));
        Password.sendKeys(read.getData("Sheet1",1,3));
        LoginButton.click();
        Thread.sleep(5000);
        return(LoginMsg.getText());
    }

    public void ProfileClick() throws InterruptedException {

        Thread.sleep(5000);
        ProfileButton.click();
    }
}

package Pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Readpropetyfile;

import java.io.IOException;

public class PopularMakePage extends BaseTest {


    Readpropetyfile read = new Readpropetyfile();

    @FindBy(xpath = "/html/body/my-app/div/main/my-home/div/div[3]/div/a/img")
    WebElement PopularMake;
    @FindBy(xpath = "/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[1]/td[7]/a")
    WebElement PopularModel;
    @FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[1]/div[1]/div[2]/h4")
    WebElement ModelName;
    @FindBy(xpath = "/html/body/my-app/header/nav/div/a")
    WebElement HomeButton;


    public PopularMakePage(WebDriver driver)
    {

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public String PopularCar() throws IOException, InterruptedException {

        HomeButton.click();
        Thread.sleep(10000);
        PopularMake.click();
        Thread.sleep(5000);
        PopularModel.click();
        Thread.sleep(5000);
        return(ModelName.getText());
    }


}

package Pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Readpropetyfile;

import java.io.IOException;

public class CarDetailsPage extends BaseTest {

    Readpropetyfile read = new Readpropetyfile();

    @FindBy(xpath = "/html/body/my-app/div/main/my-home/div/div[3]/div/a/img")
    WebElement OverallRating;
    @FindBy(xpath = "/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[1]/td[7]/a")
    WebElement ViewMoreLink;
    @FindBy(xpath = "/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[1]/h4/strong")
    WebElement VoteCount;
    @FindBy(css = "fieldset textarea[id=comment]")
    WebElement CommentBox;
    @FindBy(css = "div button")
    WebElement votebutton;
    @FindBy(css = "div[class=card-block] p[class=card-text]")
    WebElement votesuccessmessage;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/a")
    WebElement HomeButton;


    public CarDetailsPage(WebDriver driver)
    {

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public String CarDetails() throws IOException, InterruptedException {

        HomeButton.click();
        Thread.sleep(10000);
        OverallRating.click();
        Thread.sleep(5000);
        ViewMoreLink.click();
        Thread.sleep(5000);
        System.out.println("Vote Count Before "+VoteCount.getText());
        CommentBox.sendKeys("Fantasize this Car");
        votebutton.click();
        Thread.sleep(5000);
        System.out.println("Vote Count After"+VoteCount.getText());
        return(votesuccessmessage.getText());
    }


}

package testcase;

import Pages.*;
import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Readpropetyfile;

import java.io.IOException;

public class systemTests extends BaseTest{

    static Readpropetyfile read = new Readpropetyfile();

    @Test(priority=0)
    public static void CheckUserRegistration() throws IOException, InterruptedException {

        RegistryPage objRegistryPage = new RegistryPage(BaseTest.driver);
        String SuccessMsg= objRegistryPage.registryUser();
        Assert.assertEquals(SuccessMsg,"Registration is successful");

    }
    @Test(priority=1)
    public static void CheckUserLogin() throws IOException, InterruptedException {

        HomePage objHomePage = new HomePage(BaseTest.driver);
        String SuccessMsg= objHomePage.Login();
        Assert.assertEquals(SuccessMsg,"Hi, "+ read.getData("Sheet1",1,1) );

    }

    @Test(priority=2)
    public static void CheckUserProfileUpdate() throws IOException, InterruptedException {

        HomePage objHomePage = new HomePage(BaseTest.driver);
        ProfilePage objProfilePage = new ProfilePage(BaseTest.driver);
        objHomePage.ProfileClick();
        String UpdateSuccessMsg= objProfilePage.ProfileUpdate();
        Assert.assertEquals(UpdateSuccessMsg,"The profile has been saved successful" );

    }
    @Test(priority=3)
    public static void CheckUserCanVote() throws IOException, InterruptedException {


        CarDetailsPage objCarDetailsPage = new CarDetailsPage(BaseTest.driver);
        String VoteSuccessMsg= objCarDetailsPage.CarDetails();
        Assert.assertEquals(VoteSuccessMsg,"Thank you for your vote!" );

    }
    @Test(priority = 4)
    public static void CheckUserCanViewPopular() throws IOException, InterruptedException {

        PopularMakePage objPopularMakePage = new PopularMakePage(BaseTest.driver);
        String PopularMake= objPopularMakePage.PopularCar();
        Assert.assertEquals(PopularMake,"Alfa Romeo" );

    }















}

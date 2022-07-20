package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {


    protected static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader file;




    @BeforeTest
    public void setUp() throws IOException, InterruptedException {

            FileReader file = new FileReader("U:\\Automtion Documents - Vinny\\buggyCarTestSuite\\src\\test\\resources\\configfile\\config.properties");
            Properties prop = new Properties();
            prop.load(file);


        if (prop.getProperty("browser").equalsIgnoreCase("chrome"))
        {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(prop.getProperty("testurl"));
                driver.manage().window().maximize();
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
        {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.get(prop.getProperty("testurl"));
                driver.manage().window().maximize();
        }
            else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
        {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(prop.getProperty("testurl"));
                driver.manage().window().maximize();
        }

    }

    @AfterTest
    public void tearDown()
    {
        driver.close();

    }

}

package reuseable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utills.CommonUtils;
import utills.ConfigReader;
import utills.UserAction;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static Properties properties;


    public static WebDriver browserCall() throws IOException {

        String path = System.getProperty("user.dir");
        properties= new ConfigReader().initializeProperties();
        System.setProperty("webdriver.chrome.driver",path +"//src//main//resources//drivers//chromedriver.exe");



        switch (properties.getProperty("Browser").toLowerCase()){

            case "chrome" :
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;

            case "edge" :
                driver = new EdgeDriver();
                break;

            case "firefox" :
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));


        return driver;
    }
}

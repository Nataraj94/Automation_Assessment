package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utills.CommonUtils;
import utills.UserAction;

public class HomePage {

    private static WebDriver driver;

    private UserAction userAction;
    public HomePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
        userAction = new UserAction(driver);
    }

    @FindBy(xpath = "//div//button[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
    private WebElement customerMenu;

    @FindBy(xpath = "//a[@class='nav-link' and @href='/Admin/Customer/List']/child::p[1]")
    private WebElement customerList;


    public void loginButton(){

        userAction.clickOnElement(loginBtn, CommonUtils.EXPLICIT_WAIT);
    }
    public void clickCustomerMenu(){

        userAction.clickOnElement(customerMenu,CommonUtils.EXPLICIT_WAIT);
    }
    public void clickCustomerOption(){

        userAction.clickOnElement(customerList,CommonUtils.EXPLICIT_WAIT);
    }
}

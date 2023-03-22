package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(id="Email")
    WebElement txtEmail;


    @FindBy(id="Password")
    WebElement txtPassword;


    @FindBy(xpath="//button[text()='Log in']")
    WebElement btnLogin;


    public void setUserName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {

        btnLogin.click();

    }


}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

    WebDriver driver;
    public CustomersPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(tagName = "Body")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//li[1]")
    private WebElement email;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//li[2]")
    private WebElement role;

    @FindBy(id="SearchEmail")
    private WebElement searchMail;
    @FindBy(id="SearchFirstName")
    private WebElement searchFname;
    @FindBy(id = "search-customers")
    private WebElement searchBtn;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//td[@class='  button-column']/a")
    private WebElement editBtn;


    public void clickEditButton(){
        editBtn.click();
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void enterSearchFname(String firstName){
        searchFname.sendKeys(firstName);
    }

    public void enterSearchMail(String emailText){

        searchMail.sendKeys(emailText);
    }

    public String verifySuccessMessage(){
        String actualMessage = successMessage.getText();
        return actualMessage;
    }
    public String getEmailWarringMessage(){
        String emailMessage = email.getText();
        return emailMessage;
    }

    public String getCustomerRoleWarring(){
        String roleMessage = role.getText();
        return roleMessage;
    }
}

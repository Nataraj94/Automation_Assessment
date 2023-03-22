package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utills.CommonUtils;
import utills.UserAction;

public class AddCustomerPage {

   private static WebDriver driver;

   private UserAction userAction;

    public AddCustomerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        userAction = new UserAction(driver);

    }

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement addNewButton;

    @FindBy(id= "Email")
    private WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    private WebElement maleGender;

    @FindBy(xpath = "//input[@id='Gender_Female']")
    private WebElement femaleGender;

    @FindBy(id = "DateOfBirth")
    private WebElement dateOfBirth;

    @FindBy(id = "Company")
    private WebElement companyName;

    @FindBy(id = "IsTaxExempt")
    private WebElement texButton;

    @FindBy(xpath = "//div[@class='input-group-append input-group-required']/child::div/child::div/child::div")
    private WebElement customerRole;

    @FindBy(xpath = "//div[@class='col-md-9']//div//ul[@id='SelectedCustomerRoleIds_taglist']//li//following-sibling::span[@title='delete']")
    private WebElement deleteCustomerRole;

    @FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']")
    private WebElement customerRole1;

    @FindBy(xpath = "//li[text()='Administrators']")
    private WebElement administratorList;
    @FindBy(xpath = "//li[text()='Registered']")
    private WebElement registerList;
    @FindBy(xpath = "//li[text()='Vendors']")
    private WebElement vendorsList;

    @FindBy(xpath = "//li[text()='Guests']")
    private WebElement guestList;

    @FindBy(xpath = "//select[@id='VendorId']")
    private WebElement managerVendors;

    @FindBy(id = "Active")
    private WebElement activeChkBox;
    @FindBy(id = "AdminComment")
    private WebElement adminCmt;

    @FindBy(xpath="//button[@name='save']")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//li")
    private WebElement errorText;
    @FindBy(xpath = "//div[@class='validation-summary-errors']//ul//li")
    private WebElement emptyErrorText;



    public String getEmptyFieldErrorMessage(){

        return emptyErrorText.getText();

    }
    public void enterAdminComment(String comment){


        adminCmt.sendKeys(comment);
    }

    public String duplicateErrorText(){
        String errorMessage = errorText.getText();
        return errorMessage;
    }

    public void deleteCustomerRole(){

        userAction.clickOnElement(deleteCustomerRole, CommonUtils.EXPLICIT_WAIT);
    }


    public void verifyActiveChkBox(){
        Boolean bool = activeChkBox.isSelected();
    }
    public void setCustomerRole(String value) throws InterruptedException {

       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500)","");

       userAction.clickOnElement(customerRole,CommonUtils.EXPLICIT_WAIT);


        if(value.equals("Administrators")) {
            administratorList.click();
        }
        else if(value.equals("Guests")) {
            guestList.click();
        }
        else if(value.equals("Registered")) {
            registerList.click();
        }
        else if(value.equals("Vendors")) {
            vendorsList.click();
        }
        else {
            guestList.click();
        }

    }
    public void clickAddNewButton(){

        userAction.clickOnElement(addNewButton,CommonUtils.EXPLICIT_WAIT);
    }

    public void enterEmail(String textEmail){

        email.sendKeys(textEmail);
    }

    public void enterPassword(String textPassword){
        password.sendKeys(textPassword);
    }

    public void enterFirstName(String textFirstname) {
        firstName.sendKeys(textFirstname);

    }

    public void enterLastName(String textLastname)
    {
        lastName.sendKeys(textLastname);
    }

    public void setDob(String dob)
    {

        dateOfBirth.sendKeys(dob);
    }

    public void setGender(String gender) {
        if(gender.equals("Male")) {
           maleGender.click();
        }
        else if(gender.equals("Female")){
            femaleGender.click();
        }
        else {
            maleGender.click(); //default
        }
    }

    public void enterCompanyName(String textCompanyName){
        companyName.sendKeys(textCompanyName);
    }

    public void clickTexBox(){

        userAction.clickOnElement(texButton,CommonUtils.EXPLICIT_WAIT);
    }

    public void selectManagerVendors(String value){
        Select select = new Select(managerVendors);
        select.selectByVisibleText(value);
    }

    public void clickSaveButton(){

        userAction.clickOnElement(saveBtn,CommonUtils.EXPLICIT_WAIT);
    }


}

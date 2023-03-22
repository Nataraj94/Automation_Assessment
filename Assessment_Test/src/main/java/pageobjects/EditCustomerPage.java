package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utills.CommonUtils;
import utills.UserAction;

public class EditCustomerPage {

    private static WebDriver driver;
    private UserAction userAction;
    public EditCustomerPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver,this);
        userAction=new UserAction(driver);
    }

    @FindBy(id = "Email")
    private WebElement editEmail;

    @FindBy(xpath = "//input[@autocomplete='new-password']")
    private WebElement editPass;
    @FindBy(id="FirstName")
    private WebElement editFname;
    @FindBy(id="LastName")
    private WebElement editLname;

    @FindBy(id = "DateOfBirth")
    private WebElement editDOB;
    @FindBy(id = "Company")
    private WebElement editCompany;

    @FindBy(xpath = "//div[@class='col-md-9']//div//ul[@id='SelectedCustomerRoleIds_taglist']//li//following-sibling::span[@title='delete']")
    private WebElement deleteCusRole;

    @FindBy(xpath = "//div[@class='input-group-append input-group-required']/child::div/child::div/child::div")
    private WebElement editCusRole;

    @FindBy(xpath = "//li[text()='Administrators']")
    private WebElement administratorList;
    @FindBy(xpath = "//li[text()='Registered']")
    private WebElement registerList;
    @FindBy(xpath = "//li[text()='Vendors']")
    private WebElement vendorsList;

    @FindBy(xpath = "//li[text()='Guests']")
    private WebElement guestList;

    @FindBy(id = "AdminComment")
    private WebElement editComment;

    @FindBy(xpath = "//select[@id='VendorId']")
    private WebElement editManagerVendors;

    @FindBy(xpath = "//button[@name='save-continue']")
    private WebElement saveBtn;
    @FindBy(xpath = "//div[@class='content-wrapper']//div[@class='alert alert-success alert-dismissable']")
    private WebElement successMessage;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//ul//li")
    private WebElement roleErrorMessage;
    @FindBy(xpath = "//button[@name='changepassword']")
    private WebElement chgPass;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']//button[@type='button']")
    private WebElement chgPassAlertMessage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissable']")
    private WebElement passErrorMessage;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//ul//li")
    private WebElement invalidAlert;

    @FindBy(xpath = "//div[@class='float-right']/span[@id='customer-delete']")
    private WebElement deleteOption;

    @FindBy(xpath = "//div[@class='modal-content']//form[@action='/Admin/Customer/Delete/136']//div[2]//button[@type='submit']")
    private WebElement deleteBtn;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='form-horizontal']//div[@class='modal-footer']//button[@type='submit']")
    private WebElement deleteEle;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    private WebElement deleteMessage;



    public String getDeleteMessage(){

        return deleteMessage.getText();
    }

    public void clickDelete(){

        String ele = driver.getWindowHandle();
        driver.switchTo().window(ele);


        userAction.clickOnElement(deleteEle, CommonUtils.EXPLICIT_WAIT);

    }

    public void clickDeleteOption(){

        userAction.clickOnElement(deleteOption,CommonUtils.EXPLICIT_WAIT);
    }
    public String getInvalidAlertMessage(){

        return invalidAlert.getText();
    }
    public String getPasswordSuccessMessage(){
        return chgPassAlertMessage.getText();
    }
    public String getPasswordErrorMessage(){
        return passErrorMessage.getText();
    }
    public void clickChangePassword(){
        chgPass.click();
    }
    public String getCustomerRoleErrorMessage(){
        return roleErrorMessage.getText();
    }
    public String getSuccessMessage(){
        String actualMessage = successMessage.getText();
        return actualMessage;
    }
    public void enterEmail(String textEmail){
        editEmail.clear();
        editEmail.sendKeys(textEmail);
    }

    public void enterPassword(String textPassword){
        editPass.sendKeys(textPassword);
    }

    public void enterFirstName(String textFirstname) {
        editFname.clear();
        editFname.sendKeys(textFirstname);

    }

    public void enterLastName(String textLastname)
    {
        editLname.clear();
        editLname.sendKeys(textLastname);
    }

    public void setDob(String dob)
    {
        editDOB.clear();
        editDOB.sendKeys(dob);
    }


    public void enterCompanyName(String textCompanyName){

        editCompany.clear();
        editCompany.sendKeys(textCompanyName);
    }



    public void deleteCustomerRole(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        Actions actions = new Actions(driver);
        actions.moveToElement(deleteCusRole).build().perform();
        deleteCusRole.click();

    }
    public void editCustomerRole(String value) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)","");
        userAction.clickOnElement(editCusRole,CommonUtils.EXPLICIT_WAIT);



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

    public void setEditManagerVendors(String value){
        Select select = new Select(editManagerVendors);
        select.selectByVisibleText(value);
    }

    public void editComment(String Comment){

        editComment.sendKeys(Comment);
    }

    public void clickSaveEditButton(){
        saveBtn.click();
    }



}

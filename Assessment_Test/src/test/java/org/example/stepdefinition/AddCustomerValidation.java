package org.example.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import reuseable.BaseClass;
import utills.ReadExcel;

import java.io.IOException;

public class AddCustomerValidation extends BaseClass {


    WebDriver driver;
    HomePage homePage;
    AddCustomerPage addCustomer;
    CustomersPage customersPage;
    EditCustomerPage editPage;
    LoginPage login;

    @Given("User navigates to customer page")
    public void registerPage() throws IOException {

        driver = BaseClass.browserCall();

        login=new LoginPage(driver);
        login.setUserName(properties.getProperty("email"));
        login.setPassword(properties.getProperty("password"));
        login.clickLogin();

        homePage=new HomePage(driver);
        homePage.clickCustomerMenu();
        homePage.clickCustomerOption();

    }


    @When("user clicks the ADD New Button")
    public void user_clicks_the_customer_menu_and_click_add_new_button() {

        addCustomer=new AddCustomerPage(driver);
        addCustomer.clickAddNewButton();

    }
    @When("user enter the valid customer information")
    public void user_enter_the_valid_customer_information() throws InterruptedException {

        addCustomer = new AddCustomerPage(driver);

        addCustomer.enterEmail(ReadExcel.readExcelData("TestData",0,1));
        addCustomer.enterPassword("1234567");
        addCustomer.enterFirstName(ReadExcel.readExcelData("TestData",2,1));
        addCustomer.enterLastName(ReadExcel.readExcelData("TestData",3,1));
        addCustomer.setDob("07/07/1994");
        addCustomer.enterCompanyName(ReadExcel.readExcelData("TestData",5,1));
        addCustomer.clickTexBox();
        addCustomer.setGender("Male");
        addCustomer.setCustomerRole("Vendors");
        addCustomer.selectManagerVendors("Vendor 2");
        addCustomer.verifyActiveChkBox();
        addCustomer.enterAdminComment(ReadExcel.readExcelData("TestData",6,1));

    }

    @When("user click the save button")
    public void submitButton(){

        addCustomer = new AddCustomerPage(driver);
        addCustomer.clickSaveButton();
    }
    @Then("user validate the successful message")
    public void user_clicks_the_save_button_and_validate_the_successful_message() {

        customersPage = new CustomersPage(driver);
        String expectedText = "The new customer has been added successfully.";
        Assert.assertTrue(customersPage.verifySuccessMessage().contains(expectedText));
    }

    @When("user enter the customer information without mandatory field")
    public void user_enter_the_customer_information_without_mandatory_field() throws InterruptedException {


        addCustomer.enterPassword("1234567");
        addCustomer.enterFirstName(ReadExcel.readExcelData("TestData",2,1));
        addCustomer.enterLastName(ReadExcel.readExcelData("TestData",3,1));
        addCustomer.setDob("07/07/1994");
        addCustomer.enterCompanyName(ReadExcel.readExcelData("TestData",5,1));
        addCustomer.clickTexBox();
        addCustomer.setGender("Male");
        addCustomer.setCustomerRole("Vendors");
        addCustomer.selectManagerVendors("Vendor 2");
        addCustomer.verifyActiveChkBox();
        addCustomer.enterAdminComment(ReadExcel.readExcelData("TestData",6,1));

    }

    @Then("User should get proper warning messages for every mandatory field")
    public void user_should_get_proper_warning_messages_for_every_mandatory_field() {

        addCustomer.clickSaveButton();

        customersPage = new CustomersPage(driver);
        System.out.println(customersPage.getEmailWarringMessage());
        Assert.assertEquals("'Email' must not be empty.",customersPage.getEmailWarringMessage());

        Assert.assertEquals("Valid Email is required for customer to be in 'Registered' role",customersPage.getCustomerRoleWarring());

    }

    @When("user enter the duplicate customer information")
    public void duplicateAccountCreation() throws InterruptedException {
        addCustomer.enterEmail(ReadExcel.readExcelData("TestData",0,1));
        addCustomer.enterPassword("1234567");
        addCustomer.enterFirstName(ReadExcel.readExcelData("TestData",2,1));
        addCustomer.enterLastName(ReadExcel.readExcelData("TestData",3,1));
        addCustomer.setDob("07/07/1994");
        addCustomer.enterCompanyName(ReadExcel.readExcelData("TestData",5,1));
        addCustomer.clickTexBox();
        addCustomer.setGender("Male");
        addCustomer.setCustomerRole("Vendors");
        addCustomer.selectManagerVendors("Vendor 2");
        addCustomer.verifyActiveChkBox();
        addCustomer.enterAdminComment(ReadExcel.readExcelData("TestData",6,1));
    }
    @When("User should get a proper warning about duplicate email")
    public void verifyDuplicateEmail(){

        Assert.assertEquals("Email is already registered",addCustomer.duplicateErrorText());
    }

    @When("User don't enter any details into fields")
    public void emptyFieldTesting() throws InterruptedException {

        addCustomer.enterEmail("");
        addCustomer.enterPassword("");
        addCustomer.enterFirstName("");
        addCustomer.enterLastName("");
        addCustomer.setDob("");
        addCustomer.enterCompanyName("");
        addCustomer.clickTexBox();
        addCustomer.setGender("");
        //addCustomer.setCustomerRole("");
        addCustomer.deleteCustomerRole();
        addCustomer.selectManagerVendors("Vendor 2");
        addCustomer.verifyActiveChkBox();
        addCustomer.enterAdminComment("");

    }
    @Then("User should verify get proper warning messages")
    public void validateEmptyErrorMessage(){
        String expectedText = "Add the customer to 'Guests' or 'Registered' customer role";
        String actualText = addCustomer.getEmptyFieldErrorMessage();

        Assert.assertTrue(actualText.contains(expectedText));

    }


    //Edit Customer Validation Methods





    @When("user search the registered customer with valid information")
    public void searchExistingCustomer(){
        customersPage = new CustomersPage(driver);

        customersPage.enterSearchMail("sachin10@infotech.com");
        customersPage.enterSearchFname("Sachin");
        customersPage.clickSearchBtn();


    }

    @When("user select the customer and click edit button")
    public void selectEditOption(){

        customersPage = new CustomersPage(driver);
        customersPage.clickEditButton();


    }

    @When("user edit the valid customer information")
    public void editExistingCustomer() throws InterruptedException {

        editPage = new EditCustomerPage(driver);

        editPage.enterEmail("virat@gmail.com");
        editPage.enterFirstName("Rohit");
        editPage.enterLastName("Sharma");
        editPage.enterCompanyName("Rohit infoview");
        editPage.deleteCustomerRole();
        editPage.editCustomerRole("Guests");
        editPage.editComment("This is edited information about customer");

    }
    @When("user click the save & continue edit button")
    public void clickSaveAndContinueBtn(){
        editPage.clickSaveEditButton();

    }

    @Then("user validate the successful edit message")
    public void validateEditMessage(){

        Assert.assertTrue(editPage.getSuccessMessage().contains("update"));
    }

    @When("user edit and save the customer roles information without selecting roles")
    public void editCustomerRole(){


        editPage = new EditCustomerPage(driver);
        editPage.deleteCustomerRole();


    }
    @Then("user validate the edit customer role error message")
    public void validateErrorMessage(){

        String actualErrorMessage= editPage.getCustomerRoleErrorMessage();
        Assert.assertEquals("Add the customer to 'Guests' or 'Registered' customer role",actualErrorMessage);
    }

    @When("user enters the new password and click change password button")
    public void changePassword(){

        editPage = new EditCustomerPage(driver);
        editPage.enterPassword("1234567");
        editPage.clickChangePassword();

    }

    @Then("user validate the change password successful message")
    public void validateChangePasswordAlert(){
        String actualMessage = editPage.getSuccessMessage();
        String exceptedMessage = "The password has been changed successfully.";
        Assert.assertTrue(actualMessage.contains(exceptedMessage));
    }

    @When("user enters the duplicate password customer information")
    public void invalidCustomerInformation(){
        editPage = new EditCustomerPage(driver);
        editPage.enterPassword("1234567");
        editPage.clickChangePassword();

    }

    @Then("user validate invalid error message in edit customer")
    public void verifyInvalidErrorMessage(){
        String actualMessage = editPage.getPasswordErrorMessage();
        String exceptedMessage ="You entered the password that is the same as one of the last passwords you used. Please create a new password.";

        Assert.assertTrue(actualMessage.contains(exceptedMessage));


    }

    @When("user enters invalid email")
    public void invalidEmail(){
        editPage =new EditCustomerPage(driver);
        editPage.enterEmail("abc@gmail.comlion@info.com");
        editPage.clickSaveEditButton();

    }
    @Then("user Validate the error message for invalid email")
    public void verifyInvalidMailAlert(){
        String expectedMessage = "Please enter a valid email address.";
        String actualMessage = editPage.getInvalidAlertMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @When("user click the delete option and clicks the delete button in alert")
    public void clickDeleteOption(){
        editPage = new EditCustomerPage(driver);
        editPage.clickDeleteOption();
        editPage.clickDelete();
    }
    @Then("user validate the alert message")
    public void verifyDeleteAlertMessage(){

        String expectedDeleteMessage ="The customer has been deleted successfully.";
        String actualDeleteMessage = editPage.getDeleteMessage();

        Assert.assertTrue(actualDeleteMessage.contains(expectedDeleteMessage));
    }


}








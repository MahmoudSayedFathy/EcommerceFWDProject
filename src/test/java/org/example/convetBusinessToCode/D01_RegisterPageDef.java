package org.example.convetBusinessToCode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pagePackage.P01_RegisterPage;
import org.openqa.selenium.devtools.v85.dom.model.RGBA;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class D01_RegisterPageDef {

    P01_RegisterPage registerPage = new P01_RegisterPage();

    @Given("user go to register page")
    public void register_page(){
        registerPage.registerButton.click();
    }

    @And("user select gender type")
    public void selectGNDR(){
        registerPage.genderButton.click();
    }

    @And("user enter first name \"mahmoud\" and last name \"sayed\"")
    public void ENTRfullname(){
        registerPage.firstName.sendKeys("mahmoud");
        registerPage.lastName.sendKeys("sayed");
    }

    Select selectObj = null;
    @And("user enter date of birth")
    public void ENTRdate(){

        selectObj= new Select(registerPage.dayDropDownList);
        selectObj.selectByValue("23");
        selectObj= new Select(registerPage.monthDropDownList);
        selectObj.selectByIndex(9);
        selectObj= new Select(registerPage.yearDropDownList);
        selectObj.selectByVisibleText("1998");
    }

    @And("user enter email \"test5@example.com\" field")
    public void enterEmail(){
        registerPage.emailField.sendKeys("test5@example.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"Password\"")
    public void enterPass(){
        registerPage.passwordField.sendKeys("P@ssw0rd");
        registerPage.confirmPasswordField.sendKeys("P@ssw0rd");
    }
    @And("user clicks on register button")

    public void regBTN_click(){
        registerPage.registerButt.click();
    }
    SoftAssert ass =new SoftAssert();
    @Then("success message is displayed")
    public void succesMSG(){
        ass.assertTrue(registerPage.successMessage.getText().contains("Your registration completed"));
        ass.assertEquals(registerPage.successMessage.getCssValue("color"),new RGBA(76, 177, 124, Optional.of(1)));
    }
}

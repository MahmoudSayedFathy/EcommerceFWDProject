package org.example.convetBusinessToCode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pagePackage.P02_LoginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_LoginPageDef {

    P02_LoginPage loginPage = new P02_LoginPage();

    @Given("user go to login page")
    public void navtologin(){
        loginPage.loginLink.click();
    }
    @When("user login with \"valid\" \"test5@example.com\" and \"P@ssw0rd\"")
    public void vaildData(){
    loginPage.email.sendKeys("test5@example.com");
    loginPage.password.sendKeys("P@ssw0rd");
    }
    @And("user press on login button")
    public void loginBtnClick(){
    loginPage.loginButton.click();
    }
    SoftAssert ass =new SoftAssert();
    @Then("user login to the system successfully")
    public void logedSuccessfully(){
    ass.assertEquals(BeforeAndAfterTest.driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    ass.assertEquals(loginPage.myAccountButton.getText(),"My account");
    }

    @When("user login with \"invalid\" \"wrong@example.com\" and \"P@ssw0rd\"")
    public void invaildData(){
        loginPage.email.sendKeys("wrong@example.com");
        loginPage.password.sendKeys("P@ssw0rd");
    }

    @Then("user could not login to the system")
    public void unlogedSuccessfully(){
        ass.assertTrue(loginPage.unLoggedMessage.getText().contains("Login was unsuccessful."));
        ass.assertEquals(loginPage.unLoggedMessage.getCssValue("color"),
                Color.fromString("rgba(228, 67, 75, 1)").asHex());
    }



}

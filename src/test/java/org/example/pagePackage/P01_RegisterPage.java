package org.example.pagePackage;

import org.example.convetBusinessToCode.BeforeAndAfterTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_RegisterPage {
    public P01_RegisterPage(){
    PageFactory.initElements(BeforeAndAfterTest.driver,this);
    }
    @FindBy(linkText = "Register")
    public WebElement registerButton;

    @FindBy(css = "input#gender-male")
    public WebElement genderButton;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dayDropDownList;
    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthDropDownList;
    @FindBy(name = "DateOfBirthYear")
    public WebElement yearDropDownList;

    @FindBy(id = "Email")
    public WebElement emailField;

    @FindBy(id = "Password")
    public WebElement passwordField;
    @FindBy(id="ConfirmPassword")
    public WebElement confirmPasswordField;

    @FindBy(name="register-button")
    public WebElement registerButt;
    @FindBy(css = "div.result")
    public WebElement successMessage;

}

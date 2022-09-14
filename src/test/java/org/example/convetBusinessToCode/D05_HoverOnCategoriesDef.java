package org.example.convetBusinessToCode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pagePackage.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_HoverOnCategoriesDef {
    String subcategory_name=null;
    P03_homePage homePage=new P03_homePage();
    Actions action=new Actions(BeforeAndAfterTest.driver);
    @Given("user hover on category")
    public void hover() throws InterruptedException {
        action.moveToElement(homePage.computer_category()).perform();
        Thread.sleep(1000);
    }
    @When("user select a subcategory")
    public void select_subcategory(){
        subcategory_name = homePage.desktops_subcategory().getText().toLowerCase().trim();
        BeforeAndAfterTest.driver.findElement(By.cssSelector("a[href=\"/desktops\"]")).click();
    }
    @Then("page title should contain the name of the subcategory")
    public void checkPageTitle(){
        Assert.assertTrue(BeforeAndAfterTest.driver.getCurrentUrl().contains("desktops"),"wrong URL");
        System.out.println(homePage.page_title().getText());
        Assert.assertTrue(homePage.page_title().getText().toLowerCase().contains(subcategory_name),"wrong Title");
    }
}

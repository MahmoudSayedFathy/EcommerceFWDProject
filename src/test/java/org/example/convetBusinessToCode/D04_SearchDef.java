package org.example.convetBusinessToCode;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pagePackage.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_SearchDef {
    P03_homePage homePage=new P03_homePage();
    SoftAssert soft=new SoftAssert();
    @Given("user click on search box")
    public void searchBox(){
        homePage.searchBox().click();
    }
    @When("^user enter product \"(.*)\"$")
    public void searchByName(String product){
        homePage.searchBox().sendKeys(product);
        homePage.searchBox().sendKeys(Keys.ENTER);
    }
    @Then("^results should have the same \"(.*)\"$")
    public void checkResults(String keyword){
        System.out.println(keyword);
        Assert.assertTrue(BeforeAndAfterTest.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search"));
        int no_of_results= BeforeAndAfterTest.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        System.out.println(no_of_results);
        for (int i =0;i<no_of_results;i++) {
            System.out.println(BeforeAndAfterTest.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(i).findElement(By.xpath("./child::*")).getText().toLowerCase());
            soft.assertTrue(BeforeAndAfterTest.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(i).findElement(By.xpath("./child::*")).getText().toLowerCase().contains(keyword), "not " + keyword);
        }
        soft.assertAll();
    }
    @And("user click on the product")
    public void clickTheProduct(){
        BeforeAndAfterTest.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).get(0).findElement(By.xpath("./child::*")).click();
    }
    @Then("^result should have the same \"(.*)\"$")
    public void checkTheResult(String sku){
        System.out.println(BeforeAndAfterTest.driver.findElement(By.cssSelector("div[class=\"sku\"]")).findElements(By.xpath("./child::*")).get(1).getText());
        soft.assertTrue(BeforeAndAfterTest.driver.findElement(By.cssSelector("div[class=\"sku\"]")).findElements(By.xpath("./child::*")).get(1).getText().contains(sku));
        soft.assertAll();
    }
}

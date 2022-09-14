package org.example.convetBusinessToCode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pagePackage.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistDef {
    P03_homePage homePage=new P03_homePage();
    SoftAssert soft=new SoftAssert();
    @When("user click on add button")
    public void add_to_wishlist(){
        homePage.wishlistButtons().get(2).click();
    }
    @Then("success message will appear in a green background")
    public void success_bar(){
        soft.assertTrue(homePage.success_bar().isDisplayed());
        String background_color=homePage.success_bar().getCssValue("background-color");
        soft.assertTrue(background_color.contains("(75, 176, 122, 1)"));
        System.out.println(homePage.success_bar().getCssValue("background-color"));
        System.out.println(homePage.success_bar().getText());
        soft.assertAll();
    }
    @When("user click on wishlist")
    public void click_on_wishlist(){
        WebDriverWait wait=new WebDriverWait(BeforeAndAfterTest.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.success_bar()));
        homePage.wishlist().click();
    }
    @Then("user finds number of items is more than zero")
    public void check_no_of_items(){
        System.out.println(homePage.item_count().getAttribute("value"));
        soft.assertTrue(Integer.parseInt(homePage.item_count().getAttribute("value"))> 0);
        soft.assertAll();
    }
}

package org.example.convetBusinessToCode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pagePackage.P03_homePage;
import org.testng.Assert;

public class D03_CurrenciesPageDef {
    P03_homePage currancy= new P03_homePage();
    @When("user select euro currency")
    public void user_select_euro_currency() throws InterruptedException {currancy.SelectCurrency();}
    @Then("categories will be changed to the currency symbol")
    public void user_can_find_euro_symbol(){
        currancy.CurrencySymol();
        Assert.assertTrue(currancy.priceSymbol().getText().contains("€"));
        System.out.println("Done");
    }

}

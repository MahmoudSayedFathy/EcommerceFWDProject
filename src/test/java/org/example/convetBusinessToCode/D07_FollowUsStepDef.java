package org.example.convetBusinessToCode;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pagePackage.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUsStepDef {
    P03_homePage homePage=new P03_homePage();

    @When("user opens facebook link")
    public void facebook_click() throws InterruptedException {
        homePage.facebook_page().click();
        Thread.sleep(2000);
    }
    @When("user opens twitter link")
    public void twitter_click() throws InterruptedException {
        homePage.twitter_page().click();
        Thread.sleep(2000);
    }
    @When("user opens rss link")
    public void rss_click() throws InterruptedException {
        homePage.rss_page().click();
        Thread.sleep(2000);
    }
    @When("user opens youtube link")
    public void youtube_click() throws InterruptedException {
        homePage.youtube_page().click();
        Thread.sleep(2000);
    }
    @Then("^\"(.*)\" is opened in new tab$")
    public void checkURL(String url){
        ArrayList<String> tabs = new ArrayList<>(BeforeAndAfterTest.driver.getWindowHandles());
        BeforeAndAfterTest.driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(BeforeAndAfterTest.driver.getCurrentUrl().contains(url));
        BeforeAndAfterTest.driver.close();
        BeforeAndAfterTest.driver.switchTo().window(tabs.get(0));
        System.out.println(BeforeAndAfterTest.driver.getCurrentUrl());
        System.out.println(BeforeAndAfterTest.driver.getTitle());
    }
    @Then("^\"(.*)\" is opened in the same tab$")
    public void checkRSS_URL(String url){

        Assert.assertTrue(BeforeAndAfterTest.driver.getCurrentUrl().contains(url));
        System.out.println(BeforeAndAfterTest.driver.getCurrentUrl());
        System.out.println(BeforeAndAfterTest.driver.getTitle());
    }
}

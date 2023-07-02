package com.cydeo.step_definition;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Google_StepDefinition {

    @When("User is on the Google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");

    }
    @Then("User should see title Google`")
    public void user_should_see_title_google() {

        String actualString = Driver.getDriver().getTitle();
        String expectedString = "Google";
        Assert.assertTrue(actualString.equals(expectedString));

        Driver.closeDriver();

    }

}

package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.AddToCartHelper;

public class AddToCartSteps {
	
	AddToCartHelper helper = new AddToCartHelper();
	
	@Given("^customer lands in home page$")
	public void customer_lands_in_home_page() throws Throwable {
		helper.navigateToSite();
	}

	@Given("^logs into the application$")
	public void logs_into_the_application() throws Throwable {
		helper.loginToApp("anusha.siriwardene@gmail.com", "test@123");
	}

	@When("^click on search field$")
	public void click_on_search_field() throws Throwable {
	    helper.clickSearch();
	}

	@When("^click on Shop From List screen$")
	public void click_on_Shop_From_List_screen() throws Throwable {
	    helper.clickSearchList();
	}

	@When("^enters list of (.*)$")
    public void enters_list_of(String products) throws Throwable {
        helper.addItemList(products);
    }

	@When("^clicks on Find Products button$")
	public void clicks_on_Find_Products_button() throws Throwable {
	    helper.clickFindProductBtn();
	}

	@When("^from the search results click on Add to Trolley button of (.*)$")
    public void from_the_search_results_click_on_add_to_trolley_button_of(String productNameList) throws Throwable {
        helper.selectProduct(productNameList);
    }

	@When("^selects the Trolley image$")
	public void selects_the_Trolley_image() throws Throwable {
	    helper.selectTrollyIcon();
	}

	@When("^selects View All button$")
	public void selects_View_All_button() throws Throwable {
	    helper.clickViewAll();
	}

	@When("^clicks on the Save Trolley button$")
	public void clicks_on_the_Save_Trolley_button() throws Throwable {
	    helper.clickSaveTrolly();
	}

	@When("^enters the (.*) name$")
    public void enters_the_name(String trollyName) throws Throwable {
        helper.saveTrollyWithName(trollyName);
    }

	@Then("^I verify the (.*) appear in the shopping cart$")
    public void i_verify_the_appear_in_the_shopping_cart(String listofproducts) throws Throwable {
        helper.verifyList(listofproducts);
    }
	
	@After
	public void afterScenario() {
		helper.clearTrolly();
		helper.browserClose();
	}

}

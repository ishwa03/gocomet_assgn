package stepdefinitions;

import hooks.hooks;
import io.cucumber.java.en.*;
import pages.CasekaroPage;

public class CasekaroSteps {

    CasekaroPage page = new CasekaroPage(hooks.page);

    @Given("user opens casekaro website")
    public void openSite(){
        page.openWebsite();
    }

    @When("user clicks mobile covers")
    public void clickMobile(){
        page.clickMobileCovers();
    }
  @When("user clicks search")
public void clickSearch(){

    page.clickSearch();
}
    
@When("user searches Apple")
public void selectModel(){

    page.searchApple();
}
    

    

    @When("user selects first product")
    public void selectProduct(){
        page.selectFirstProduct();
    }

    @When("user adds Hard material")
    public void addHard(){
        page.chooseOptions();
        page.addMaterial("Hard");
    }

    @When("user adds Soft material")
    public void addSoft(){
        page.chooseOptions();
        page.addMaterial("Soft");
    }

    @When("user adds Glass material")
    public void addGlass(){
        page.chooseOptions();
        page.addMaterial("Glass");
    }

    @When("user opens cart")
    public void openCart(){
        page.openCart();
    }

    @Then("validate all three materials added")
    public void validateCart(){
        page.validateCart();
    }

    @Then("print cart details")
    public void printDetails(){
        page.printCartDetails();
    }
}
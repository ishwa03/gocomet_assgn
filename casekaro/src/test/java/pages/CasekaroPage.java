package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import org.junit.jupiter.api.Assertions;

public class CasekaroPage {

    Page page;

    public CasekaroPage(Page page){
        this.page = page;
    }

    public void openWebsite(){
        page.navigate("https://casekaro.com/");
        page.waitForLoadState();
    }

    
    public void clickMobileCovers(){

      page.getByRole(AriaRole.LINK, 
    new Page.GetByRoleOptions().setName("Mobile Covers")).click();

    
    }
public void clickSearch(){
   page.locator("summary[aria-label='Search']").click();
}
    
public void searchApple(){

    page.locator("input[type='search']").fill("Apple");

    page.waitForTimeout(2000);

    page.getByText("Apple - Designer Pop Case").first().click();
    page.locator("text=iPhone 16 Pro").first().click();
    Locator choose = page.locator("text=Choose Options").first();

    // wait until button appears
    choose.waitFor();

    // scroll to that button
    choose.scrollIntoViewIfNeeded();

    // click button
    choose.click();

    page.waitForLoadState();
}
    


    public void chooseOptions(){

   page.locator("text=Choose Options").first().click();

   
}
    public void selectFirstProduct(){

        page.locator(".card__heading a").first().click();
         page.waitForLoadState();
    }

    public void addMaterial(String material) {
    // 1. Locate the material label
    Locator materialLabel = page.locator("fieldset.product-form__input label:has-text('" + material + "')");
    
    // FORCED SCROLL: If it's in a popup, sometimes we need to scroll the container specifically
    // We use JavaScript to ensure the label's parent is scrolled into view
    materialLabel.evaluate("el => el.scrollIntoView({ behavior: 'smooth', block: 'center' })");
    
    materialLabel.click();
    System.out.println("Clicked material: " + material);

    // 2. Select the Add to Cart button
    // Using a more generic class-based selector in case the ID changes per session
    Locator addToCartBtn = page.locator(".product-form__submit").last();

    // 3. Handle the Scroll in the Popup
    // If a popup is open, the 'window' won't scroll, the 'div' will.
    // This JS snippet finds the button and forces the scroll inside its scrollable parent.
    addToCartBtn.evaluate("el => el.scrollIntoView({ behavior: 'auto', block: 'center' })");

    // 4. Click using dispatchEvent 
    // This is safer for popups because it doesn't care if another element is 'technically' overlapping
    addToCartBtn.dispatchEvent("click");
    
    System.out.println("Add to Cart clicked inside popup.");
}

    public void openCart(){

        page.locator("a[href*='cart']").click();
        page.waitForLoadState();
    }

    public void validateCart(){

        Locator items = page.locator("tr.cart-item");

        Assertions.assertEquals(3, items.count());
    }

    public void printCartDetails(){

        Locator items = page.locator("tr.cart-item");

        int count = items.count();

        for(int i=0;i<count;i++){

            String material = items.nth(i)
                    .locator(".product-option")
                    .innerText();

            String price = items.nth(i)
                    .locator(".price")
                    .innerText();

            String link = items.nth(i)
                    .locator("a")
                    .getAttribute("href");

            System.out.println("Material: " + material);
            System.out.println("Price: " + price);
            System.out.println("Link: https://casekaro.com" + link);
            System.out.println("-----------------------");
        }
    }
}
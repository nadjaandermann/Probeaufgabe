package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class product extends setup {

        public Page page;

        public String productTitel = "//div[@data-test='inventory-item-name']";
        public String productPrice = "//div[@data-test='inventory-item-price']";
        public String productInfo = "//div[@data-test='inventory-item-desc']";
        public String productPicture = "//div[@class='inventory_details_img_container']";
        public String addToCartButton = "//button[@id='add-to-cart']";
        public String cartButton = "//div[@id='shopping_cart_container']";
        public String removeButton = "//button[@id='remove']";

        public product(Page page) {
                this.page = page;
        }

        public void clickAddToCartButton() {
                outPrint("Klicke den Button 'add to cart'");
                page.locator(addToCartButton).click();
        }

        public void clickCartButton() {
                outPrint("Navigiere zum Warenkorb");
                page.locator(cartButton).click();
        }

        public void clickRemoveButton() {
                outPrint("Klicke den Button 'remove'");
                page.locator(removeButton).click();
        }
}

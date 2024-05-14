package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class cart extends setup {

        public Page page;

        public String productTitel = "//div[@class='inventory_item_name']";
        public String productPrice = "//div[@class='inventory_item_price']";
        public String removeButton = "//button[@id='remove-sauce-labs-backpack']";
        public String checkoutButton = "//button[@id='checkout']";
        public String continueButton = "//button[@id='continue-shopping']";
        public String quantity = "//div[@class='cart_quantity']";

        public cart(Page page) {
                this.page = page;
        }

        public void removeProduct(int product) {
                outPrint("Das " + product + " Produkt wird aus dem Warenkorb gelöscht");
                page.locator(removeButton).nth(product).click();
        }

        public void clickContinueShopping() {
                outPrint("Der Button Continue Shopping wird geklickt");
                page.locator(continueButton).click();
        }

        public void clickCheckout() {
                outPrint("Der Button Checkout wird geklickt");
                page.locator(checkoutButton).click();
        }

        public String getProductTitel(int product) {
                outPrint("Der Name des " + product + " Produkts wird ausgelesen");
                return page.locator(productTitel).nth(product).innerText();
        }

        public String  getProductPrice(int product) {
                outPrint("Der Preis des " + product + " Produkts wird ausgelesen");
                return page.locator(productPrice).nth(product).innerText();
        }

        public String getProductMenge(int product) {
                outPrint("Die Menge des " + product + " Produkts wird ausgelesen");
                return page.locator(quantity).nth(product).innerText();
        }
}

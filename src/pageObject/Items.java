package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class Items extends setup {

        public Page page;

        public String warenkorb = "//div[@id='shopping_cart_container']";
        public String products = "//div[@class='inventory_item']";
        public String productTitle = "//div[@class='inventory_item_name ']";
        public String productBild = "//div[@class='inventory_item_img']";
        public String pruductPrice = "//div[@class='inventory_item_price']";
        public String productAddCart = "//button[text()='Add to cart']";

        public Items(Page page) {
                this.page = page;
        }

        public void clickWarenkorb() {
                outPrint("Navigiere zum Warenkorb");
                page.locator(warenkorb).click();
        }

        public String getProductTitel(int product) {
                outPrint("Frage Produkt Name vom " + product + " Produkt ab.");
                return page.locator(productTitle).nth(product).innerText();
        }

        public String getProductPrice(int product) {
                outPrint("Frage Produkt Price vom " + product + " Produkt ab.");
                return page.locator(pruductPrice).nth(product).innerText();
        }

        public void clickProduct(int product) {
                outPrint("Klicke Product " + product + " an.");
                page.locator(products).nth(product).click();
        }

        public void addProductToCart(int product) {
                outPrint("Füge Produkt " + product + " dem Warenkorb hinzu");
                page.locator(productAddCart).nth(product).click();
        }
}

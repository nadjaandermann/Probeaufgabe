package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class checkoutOverview extends setup {

        public Page page;

        public String productTitel = "//div[@class='inventory_item_name']";
        public String productPrice = "//div[@class='inventory_item_price']";
        public String cancelButton = "//button[@id='cancel']";
        public String finishButton = "//button[@id='finish']";

        public checkoutOverview(Page page) {
                this.page = page;
        }

        public String getProductTitel(int product) {
                outPrint("Der Name des " + product + " Produkts wird ausgelesen");
                return page.locator(productTitel).nth(product).innerText();
        }

        public String  getProductPrice(int product) {
                outPrint("Der Preis des " + product + " Produkts wird ausgelesen");
                return page.locator(productPrice).nth(product).innerText();
        }

        public void clickFinish() {
                outPrint("Klicke den Finish Button");
                page.locator(finishButton).click();
        }

        public void clickCancel() {
                outPrint("Klicke den Cancel Button");
                page.locator(cancelButton).click();
        }
}

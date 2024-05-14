package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class checkoutComplete extends setup{

        public Page page;

        public String bestaetigung = "//h2[text()='Thank you for your order!']";
        public String backButton = "//button[@id='back-to-products']";

        public checkoutComplete(Page page) {
                this.page = page;
        }

        public void clickBack() {
                outPrint("Klicke Back Button");
                page.locator(backButton).click();
        }
}

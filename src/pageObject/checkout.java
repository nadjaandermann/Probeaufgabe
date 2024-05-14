package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class checkout extends setup{

        public Page page;

        public String fistNameInput = "//input[@id='first-name']";
        public String lastNameInput = "//input[@id='last-name']";
        public String zip = "//input[@id='postal-code']";
        public String fehlermeldungFistName = "//h3[contains(text(), 'First Name is required')]";
        public String fehlermeldungLasName = "//h3[contains(text(), 'Last Name is required')]";
        public String fehlermeldungZip = "//h3[contains(text(), 'Postal Code is required')]";
        public String continueButton = "//input[@id='continue']";
        public String cancelButton = "//button[@id='cancel']";

        public checkout(Page page) {
                this.page = page;
        }

        public void eingabeFirstName(String name) {
                outPrint("Gebe den Nutzername ein");
                page.locator(fistNameInput).fill(name);
        }

        public void eingabeLastName(String name) {
                outPrint("Gebe den Nachname ein");
                page.locator(lastNameInput).fill(name);
        }

        public void eingabeZip(String name) {
                outPrint("Gebe die PLZ ein");
                page.locator(zip).fill(name);
        }

        public void clickContinue() {
                outPrint("Klicke den Contiune Button");
                page.locator(continueButton).click();
        }

        public void clickCancel() {
                outPrint("Klicke den Cancel Button");
                page.locator(cancelButton).click();
        }
}

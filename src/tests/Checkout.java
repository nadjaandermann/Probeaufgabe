package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;

public class Checkout extends setup {

        public String productTitel;
        public String productPrice;

        @Test(priority = 0)
        @Description("Hier wird geprüft ob die Fehlermeldung 'First Name' angezeigt wird.")
        @Epic("Checkout")
        public void checkoutOhneDaten() {
                getPage().navigate("https://www.saucedemo.com/");

                //Anmelden
                login.anmelden("standard_user", "secret_sauce");

                //Product Daten speichern
                productTitel = items.getProductTitel(0);
                productPrice = items.getProductPrice(0);

                //Füge ein Product hinzu
                items.addProductToCart(0);

                //Navigiere zum Checkout
                items.clickWarenkorb();
                cart.clickCheckout();

                checkout.clickContinue();
                Assert.assertTrue(getPage().locator(checkout.fehlermeldungFistName).isVisible(),
                        "Fehlermeldung 'First Name' wird nicht angezeigt");
        }

        @Test(priority = 1)
        @Description("Hier wird geprüft ob die Fehlermeldung 'Last Name' angezeigt wird.")
        @Epic("Checkout")
        public void checkoutNurNutzerName() {
                checkout.eingabeFirstName("Test");
                checkout.clickContinue();
                Assert.assertTrue(getPage().locator(checkout.fehlermeldungLasName).isVisible(),
                        "Fehlermeldung 'Last Name' wird nicht angezeigt");
        }

        @Test(priority = 2)
        @Description("Hier wird geprüft ob die Fehlermeldung 'PLZ Name' angezeigt wird.")
        @Epic("Checkout")
        public void checkoutOhneZip() {
                checkout.eingabeLastName("Testnachname");
                checkout.clickContinue();
                Assert.assertTrue(getPage().locator(checkout.fehlermeldungZip).isVisible(),
                        "Fehlermeldung 'PLZ' wird nicht angezeigt");
        }

        @Test(priority = 3)
        @Description("Hier wird geprüft ob der Checkout durchgeführt werden kann.")
        @Epic("Checkout")
        public void checkoutMitKorrektenDaten() {
                checkout.eingabeZip("12345");
                checkout.clickContinue();

                Assert.assertEquals(checkoutOverview.getProductTitel(0), productTitel,
                        "Es wird nicht das korrekte Produkt im Checkout angezeigt.");

                Assert.assertEquals(checkoutOverview.getProductPrice(0), productPrice,
                        "Es wird nicht der korrekte Preis im Checkout angezeigt.");

        }

        @Test(priority = 4)
        @Description("Hier wird geprüft ob die Bestellung abgeschickt werden kann.")
        @Epic("Checkout")
        public void checkoutFinish() {
                checkoutOverview.clickFinish();

                Assert.assertTrue(getPage().locator(checkoutComplete.bestaetigung).isVisible(),
                        "Es wird kein Bestätigungstext angezeigt");
        }
}

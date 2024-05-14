package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;

import java.time.Duration;

public class Warenkorb extends setup{

        @Test(priority = 0)
        @Description("Hier wird geprüft ob ein Produkt in den Warenkorb hinzugefügt werden kann.")
        @Epic("Warenkorb")
        public void producthinzufuegen() {
                getPage().navigate("https://www.saucedemo.com/");

                //Anmelden
                login.anmelden("standard_user", "secret_sauce");

                //Product Daten speichern
                String productTitel = items.getProductTitel(0);
                String productPrice = items.getProductPrice(0);

                //Product hinzufügen
                items.addProductToCart(0);
                items.clickWarenkorb();

                Assert.assertEquals(cart.getProductTitel(0), productTitel, "Es wurde nicht das korrekte Product hinzugefügt.");
                Assert.assertEquals(cart.getProductPrice(0), productPrice, "Es wurde nicht der korrekte Preis angezeigt.");
                Assert.assertEquals(cart.getProductMenge(0), "1", "Es wurde nicht der korrekte Menge angezeigt.");
        }

        @Test(priority = 1)
        @Description("Hier wird geprüft ob ein Produkt im Warenkorb gelöscht werden kann.")
        @Epic("Warenkorb")
        public void productloeschen() {
                cart.removeProduct(0);
                Assert.assertTrue(getPage().locator(cart.productTitel).count() == 0, "Der Warenkorb ist nicht leer");
        }

        @Test(priority = 2)
        @Description("Hier wird geprüft ob ein Produkt über die Product Seite hinzugefügt.")
        @Epic("Warenkorb")
        public void productSite() {
                getPage().navigate("https://www.saucedemo.com/inventory.html");

                //Product Daten speichern
                String productTitel = items.getProductTitel(0);
                String productPrice = items.getProductPrice(0);

                //Navigiere zum Product
                getPage().locator(items.productTitle).nth(0).click();

                //Füge Product hinzu
                product.clickAddToCartButton();
                product.clickCartButton();

                Assert.assertEquals(cart.getProductTitel(0), productTitel, "Es wurde nicht das korrekte Product hinzugefügt.");
                Assert.assertEquals(cart.getProductPrice(0), productPrice, "Es wurde nicht der korrekte Preis angezeigt.");
                Assert.assertEquals(cart.getProductMenge(0), "1", "Es wurde nicht der korrekte Menge angezeigt.");
        }

        @Test(priority = 3)
        @Description("Hier wird geprüft ob ein Produkt über die Product Seite gelöscht werden kann.")
        @Epic("Warenkorb")
        public void productSiteDelet() {
                getPage().navigate("https://www.saucedemo.com/inventory.html");

                //Navigiere zum Warenkorb
                items.clickWarenkorb();

                //Navigiere zum Product
                getPage().locator(cart.productTitel).click();

                //Lösche das Product aus dem Warenkorb
                product.clickRemoveButton();
                product.clickCartButton();

                Assert.assertTrue(getPage().locator(cart.productTitel).count() == 0, "Der Warenkorb ist nicht leer");
        }
}

package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;

public class ProductListe extends setup {

        @Test(priority = 0)
        @Description("Hier wird geprüft ob jedes Produkt ein Preis besitz.")
        @Epic("Product Search")
        public void checkPrice() {
                getPage().navigate("https://www.saucedemo.com/");
                login.anmelden("standard_user", "secret_sauce");
                Assert.assertTrue(getPage().locator(items.pruductPrice).count() == getPage().locator(items.products).count(),
                        "Nicht jedes Produkt hat ein Preis.");
                outPrint("Jedes Produkt hat ein Preis.");
        }

        @Test(priority = 1)
        @Description("Hier wird geprüft ob jedes Produkt ein Bild besitz.")
        @Epic("Product Search")
        public void checkProductBild() {
                getPage().navigate("https://www.saucedemo.com/inventory.html");
                Assert.assertTrue(getPage().locator(items.productBild).count() == getPage().locator(items.products).count(),
                        "Nicht jedes Produkt hat ein Bild.");
                outPrint("Jedes Produkt hat ein Bild.");
        }

        @Test(priority = 2)
        @Description("Hier wird geprüft ob jedes Produkt einen Namen besitz.")
        @Epic("Product Search")
        public void checkProductName() {
                getPage().navigate("https://www.saucedemo.com/inventory.html");
                Assert.assertTrue(getPage().locator(items.productTitle).count() == getPage().locator(items.products).count(),
                        "Nicht jedes Produkt hat einen Namen.");
                outPrint("Jedes Produkt hat einen Namen.");
        }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;

public class Product extends setup {

        String productTitel;
        String productPrice;

        @Test(priority = 0)
        public void checkProductName() {
                getPage().navigate("https://www.saucedemo.com/");
                login.anmelden("standard_user", "secret_sauce");

                productTitel = items.getProductTitel(0);
                productPrice = items.getProductPrice(0);
                getPage().locator(items.productTitle).nth(0).click();

                Assert.assertEquals(getPage().locator(product.productTitel).innerText(), productTitel, "Es wurde nicht das korrekte Product hinzugefügt.");

        }

        @Test(priority = 1)
        public void checkProductPrice() {
                Assert.assertEquals(getPage().locator(product.productPrice).innerText(), productPrice, "Es wurde nicht der korrekte Preis angezeigt.");
        }

        @Test(priority = 2)
        public void checkProductInfo() {
                Assert.assertTrue(getPage().locator(product.productInfo).isVisible(), "Es wird kein Info Text angezeigt");
        }

        @Test(priority = 3)
        public void ckeckPicture() {
                Assert.assertTrue(getPage().locator(product.productPicture).isVisible(), "Es wird kein Bild angezeigt");
        }

}

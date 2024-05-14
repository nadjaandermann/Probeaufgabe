package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.setup;

import java.time.Duration;

public class Login extends setup {

       @Test(priority = 0)
       @Description("Hier wird getestet ob die Richtigen Fehlermeldungen angezeigt werden.")
       @Epic("Login")
       public void loginOhneDaten() {
              getPage().navigate("https://www.saucedemo.com/");
              login.clickLogin();
              Assert.assertTrue(getPage().locator(login.fehlermeldungUser).isVisible(), "Fehlermeldung wird nicht angezeigt.");
       }

       @Test(priority = 1)
       @Description("Hier wird getestet ob die Richtigen Fehlermeldungen bei nicht eingabe des Paswworts angezeigt werden.")
       @Epic("Login")
       public void loginOhnePasswort() {
              getPage().navigate("https://www.saucedemo.com/");
              login.emailEingabe("standard_user");
              login.clickLogin();

              Assert.assertTrue(getPage().locator(login.fehlermeldungPasswort).isVisible(), "Fehlermeldung wird nicht angezeigt.");
       }

       @Test(priority = 2)
       @Description("Hier wird getestet ob die Richtigen Fehlermeldungen bei eingabe des Falschen angezeigt werden.")
       @Epic("Login")
       public void loginFalschesPasswort() {
              getPage().navigate("https://www.saucedemo.com/");
              login.emailEingabe("standard_user");
              login.passwortEingabe("test123");
              login.clickLogin();

              Assert.assertTrue(getPage().locator(login.fehlermeldungFalschesPasswort).isVisible(), "Fehlermeldung wird nicht angezeigt.");
       }

       @Test(priority = 3)
       @Description("Hier wird getestet ob die Richtigen Fehlermeldungen bei einem gesperrten User angezeigt werden.")
       @Epic("Login")
       public void loginGesperrterUser() {
              getPage().navigate("https://www.saucedemo.com/");
              login.emailEingabe("locked_out_user");
              login.passwortEingabe("secret_sauce");
              login.clickLogin();
              Assert.assertTrue(getPage().locator(login.fehlermeldungBlocked).isVisible());
       }

       @Test(priority = 4)
       @Description("Hier wird getestet ob der Login möglich ist.")
       @Epic("Login")
       public void loginRichtigeDaten() {
              getPage().navigate("https://www.saucedemo.com/");
              login.emailEingabe("standard_user");
              login.passwortEingabe("secret_sauce");
              login.clickLogin();
              Assert.assertTrue(getPage().locator("//div[@id='shopping_cart_container']").isVisible(), "Nutzer konnte sich nicht einloggen.");
       }
}

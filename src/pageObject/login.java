package pageObject;

import com.microsoft.playwright.Page;
import setup.setup;

public class login extends setup {

        private Page page;

        public String emailInput = "//input[@id='user-name']";
        public String passwortInput = "//input[@id='password']";
        public String fehlermeldungUser = "//h3[contains(text(), 'Username is required')]";
        public String fehlermeldungPasswort = "//h3[contains(text(), 'Password is required')]";
        public String fehlermeldungBlocked = "//h3[contains(text(), 'Sorry, this user has been locked out.')]";
        public String fehlermeldungFalschesPasswort = "//h3[contains(text(), 'Username and password do not match any user in this service')]";
        public String loginButton = "//input[@id='login-button']";

        public login(Page page) {
                this.page = page;
        }

        public void passwortEingabe(String passwort) {
                outPrint("Gebe in das Passwort Feld '" + passwort + "'ein");
                page.locator(passwortInput).fill(passwort);
        }

        public void emailEingabe(String email) {
                outPrint("Gebe in das E-Mail Feld '" + email + "'ein");
                page.locator(emailInput).fill(email);
        }

        public void clickLogin() {
                outPrint("Klicke Login-Button");
                page.locator(loginButton).click();
        }

        public void anmelden(String email, String passwort) {
                outPrint("Der Nutzer wird eingeloggt. (email: " + email + ", passwort: " + passwort +")");
                emailEingabe(email);
                passwortEingabe(passwort);
                clickLogin();
        }
}

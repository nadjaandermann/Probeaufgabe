package setup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.annotations.*;

import pageObject.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class setup {

        private Page page;
        private Browser browserDriver;
        private Playwright playwright;

        public login login;
        public Items items;
        public cart cart;
        public checkout checkout;
        public checkoutOverview checkoutOverview;
        public checkoutComplete checkoutComplete;
        public product product;

        public Path pathReport = Paths.get(System.getProperty("user.dir"))
                .resolve("allure-report");
        public Path pathResult = Paths.get(System.getProperty("user.dir"))
                .resolve("allure-results");

        @BeforeSuite
        @Parameters({"betriebssystem"})
        public void start(String betriebssystem) throws IOException {

               outPrint("----lösche alte Ergebnisse-----");
                if (betriebssystem.toLowerCase().contains("windows")) {
                        Runtime.getRuntime().exec("rmdir /s /q '" + pathResult + "'");
                } else if (betriebssystem.toLowerCase().contains("mac")) {
                        Runtime.getRuntime().exec("rm -rf " + pathResult);
                }
        }

        @BeforeClass
        @Parameters({"headless", "browser"})
        public void setup(boolean headless, String browser) {
                outPrint("----Öffne den Browser------");
                // Start Playwright
                playwright = Playwright.create();
                browserDriver = createBrowser(headless, browser);

                // Create a new page
                page = getBrowser().newPage();

                login = new login(getPage());
                items = new Items(getPage());

                outPrint("----Generiere Page Objects------");

                login = new login(getPage());
                items = new Items(getPage());
                cart = new cart(getPage());
                checkout = new checkout(getPage());
                checkoutOverview = new checkoutOverview(getPage());
                checkoutComplete = new checkoutComplete(getPage());
                product = new product(getPage());

        }

        @AfterClass
        public void close() {
                getPage().close();
        }

        @AfterSuite
        public void teardown() throws IOException {
                outPrint("----Schließe den Browser------");
                playwright.close();

                outPrint("------Generate Reporting-------");
                Runtime.getRuntime().exec("mvn allure:report");
        }

        public Page getPage() {
                return page;
        }

        public void setPage(Page page) {
                this.page = page;
        }

        public Browser getBrowser() {
                return browserDriver;
        }

        public void setBrowser(Browser browser) {
                this.browserDriver = browser;
        }

        public Playwright getPlaywright() {
                return playwright;
        }

        public void setPlaywright(Playwright playwright) {
                this.playwright = playwright;
        }

        public void outPrint(String text) {
                System.out.println(text);
                Allure.addAttachment("Step", text);
        }

        public Browser createBrowser(boolean headless, String browser) {
                switch (browser.toLowerCase()) {
                        case "firefox":
                                return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(0));
                        case "chrome":
                                return playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(0));
                        case "webkit":
                                return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(0));
                }
                return null;
        }
}

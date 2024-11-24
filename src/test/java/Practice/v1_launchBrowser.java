package Practice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class v1_launchBrowser {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        //Chrome setup yapıyoruz, headles(false) browser aç demek
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());

        page.close(); //sayfanin oturumunu kapatir
        browser.close(); //tarayicinin oturumunu kapatir
        playwright.close(); // testi sonlandirip bitirir
    }
}

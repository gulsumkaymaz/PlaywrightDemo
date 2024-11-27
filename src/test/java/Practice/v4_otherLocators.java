package Practice;

import com.microsoft.playwright.*;

import java.awt.*;

public class v4_otherLocators {

    public static void main(String[] args) throws InterruptedException {


        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width, height);


        page.navigate("https://getir.com/");
        System.out.println("title " + page.title());

        // css matching by text
        // 1. has text
        Locator loginText = page.locator("h5:has-text('Giriş yap veya kayıt ol')");
        System.out.println("1. login text " + loginText.innerText());
    }
}
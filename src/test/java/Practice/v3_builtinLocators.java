package Practice;

import com.microsoft.playwright.*;

import java.awt.*;

public class v3_builtinLocators {
    public static void main(String[] args) {

        Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.setViewportSize(width,height);

        page.navigate("https://www.getir.com/");
        System.out.println("title" + page.title());

        // getByText
        Locator loginText = page.getByText("Giriş yap veya kayıt ol");
        System.out.println("1. text" + loginText.innerText());
/*loginText bizim locator Webelement olarak dusunebiliriz
innerText ise Seleniumdan getText() olarak dusunebiliriz
 */

    }
}

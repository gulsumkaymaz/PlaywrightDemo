package Practice;

import com.microsoft.playwright.*;

import java.awt.*;

import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.microsoft.playwright.options.AriaRole.TEXTBOX;

public class v3_builtinLocators {
    public static void main(String[] args) throws InterruptedException {

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

        // Locate in Shadow DOM
        Locator shadowDom = page.locator("div", new Page.LocatorOptions().setHasText("Giriş yap veya kayıt ol")).last();
        System.out.println("shadowDom " + shadowDom.innerText());


        // getByRole
        Locator phoneNumber = page.getByRole(TEXTBOX, new Page.GetByRoleOptions().setName("Telefon Numarası"));
        System.out.println("2. phone number " + phoneNumber.innerText());
        phoneNumber.click();
        phoneNumber.fill("590-345");

    }
}

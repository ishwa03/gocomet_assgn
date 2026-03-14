package utils;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext context;
    public static Page page;

    public static Page initBrowser() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );

        context = browser.newContext();
        page = context.newPage();

        return page;
    }

    public static void closeBrowser() {
        browser.close();
        playwright.close();
    }
}

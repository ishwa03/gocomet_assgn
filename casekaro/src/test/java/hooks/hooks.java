package hooks;

import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.PlaywrightFactory;

public class hooks {

    public static Page page;

    @Before
    public void setup() {
        page = PlaywrightFactory.initBrowser();
    }

    @After
    public void tearDown() {
        PlaywrightFactory.closeBrowser();
    }
}
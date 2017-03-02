package utils;


import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.util.concurrent.TimeUnit;

public class PhantomJsUtils {

    private static final Logger LOGGER = Logger.getLogger(PhantomJsUtils.class);

    private static WebDriver driver;

    public PhantomJsUtils() {
        LOGGER.info("CREATE PHANTOM DRIVER");
        this.driver = new PhantomJSDriver();
    }

    public static Document getSourcePage(String url) throws InterruptedException {
        new PhantomJsUtils();
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        driver.get(url);
        LOGGER.info("GET SOURCE PAGE FROM PHANTOM DRIVER");
        Document document = Jsoup.parse(driver.getPageSource());
        driver.quit();
        return document;
    }
}

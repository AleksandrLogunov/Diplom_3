package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private static final String BROWSER_PROP = System.getProperty("browser", "chrome");
    private static final Browser BROWSER = Browser.valueOf(BROWSER_PROP.toUpperCase());

    public static WebDriver createWebDriver() {
        switch (BROWSER) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "driver/chrome/chromedriver-win64/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);

            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "driver/yandex/yandexdriver-25.6.0.2261-win64/yandexdriver.exe");
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary("C:\\Users\\Turbo\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                yandexOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(yandexOptions);

            default:
                throw new RuntimeException("Неизвестный браузер: " + BROWSER);
        }
    }
}
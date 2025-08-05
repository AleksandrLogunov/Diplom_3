package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.net.URL;

public class WebDriverFactory {

    private static final String BROWSER_PROP = System.getProperty("browser", "chrome");
    private static final Browser BROWSER = Browser.valueOf(BROWSER_PROP.toUpperCase());

    public static WebDriver createWebDriver() {
        switch (BROWSER) {
            case CHROME:
                setupDriverFromResources("webdriver.chrome.driver", "driver/chrome/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);

            case YANDEX:
                setupDriverFromResources("webdriver.chrome.driver", "driver/yandex/yandexdriver.exe");
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary("C:\\Users\\Turbo\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                yandexOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(yandexOptions);

            default:
                throw new RuntimeException("Неизвестный браузер: " + BROWSER);
        }
    }
    private static void setupDriverFromResources(String propertyName, String resourcePath) {
        URL resource = WebDriverFactory.class.getClassLoader().getResource(resourcePath);
        if (resource == null) {
            throw new RuntimeException("Драйвер не найден в папке ресурсов: " + resourcePath);
        }
        File driverFile = new File(resource.getFile());
        if (!driverFile.exists()) {
            throw new RuntimeException("Файл драйвера не существует: " + driverFile.getAbsolutePath());
        }
        System.setProperty(propertyName, driverFile.getAbsolutePath());
    }
}
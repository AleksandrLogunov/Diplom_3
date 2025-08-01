package tests;

import api.User;
import api.UserClient;
import factory.WebDriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";

    protected UserClient userClient;
    protected User user;
    protected String accessToken;
    protected MainPage mainPage;
    protected LoginPage loginPage;

    @BeforeEach
    @Step("Настройка перед тестом: запуск браузера, открытие главной страницы и создание тестового пользователя")
    public void setUp() {

        driver = WebDriverFactory.createWebDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        userClient = new UserClient();

        String timestamp = String.valueOf(System.currentTimeMillis());
        String randomEmail = "test-" + timestamp + "@yandex.ru";

        String randomPassword = "password-" + timestamp.substring(timestamp.length() - 6);
        String randomName = "name-" + timestamp;
        user = new User(randomEmail, randomPassword, randomName);

    }

    @AfterEach
    @Step("Очистка после теста: закрытие браузера и удаление тестового пользователя")
    public void tearDown() {
        if (accessToken != null) {
            userClient.deleteUser(accessToken)
                    .then()
                    .statusCode(202);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}

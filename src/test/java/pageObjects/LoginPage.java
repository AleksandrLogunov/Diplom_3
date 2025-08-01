package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // Поле ввода Email
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    // Поле ввода Пароль
    private final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    // Кнопка "Войти"
    private final By loginButton = By.xpath(".//button[text()='Войти']");
    // Ссылка "Зарегистрироваться"
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");
    // Ссылка "Восстановить пароль"
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввести email в поле Email на странице входа")
    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль в поле Пароль на странице входа")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку 'Войти' на странице входа")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Проверить видимость страницы входа")
    public boolean isLoginPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

    @Step("Нажать ссылку 'Зарегистрироваться' на странице входа")
    public void clickRegisterLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink));
        driver.findElement(registerLink).click();
    }

    @Step("Нажать ссылку 'Восстановить пароль' на странице входа")
    public void clickForgotPasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        driver.findElement(forgotPasswordLink).click();
    }

    @Step("Выполнить вход с email и паролем")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
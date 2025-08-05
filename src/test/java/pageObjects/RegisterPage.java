package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;

    // Поле ввода Имя
    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    // Поле ввода Email
    private final By emailField = By.xpath("//label[text()='Email']/following::input[1]");
    // Поле ввода Пароль
    private final By passwordField = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    // Кнопка "Зарегистрироваться"
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    // Ссылка "Войти"
    private final By loginLink = By.xpath(".//a[text()='Войти']");
    // Ошибка "Некорректный пароль"
    private final By incorrectPasswordError = By.xpath(".//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Ввести имя в поле Имени на странице регистрации")
    public void enterName(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Ввести email в поле Email на странице регистрации")
    public void enterEmail(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввести пароль в поле Пароля на странице регистрации")
    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажать кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {

        driver.findElement(registerButton).click();
    }

    @Step("Проверить, что отображается ошибка 'Некорректный пароль'")
    public boolean isIncorrectPasswordErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(incorrectPasswordError)).isDisplayed();
    }

    @Step("Нажать ссылку 'Войти' на странице регистрации")
    public void clickLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }

    @Step("Выполнить регистрацию с именем, email и паролем")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }
}
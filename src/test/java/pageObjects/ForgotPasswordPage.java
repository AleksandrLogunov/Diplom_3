package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ForgotPasswordPage {
    private final WebDriver driver;

    // Локатор поля Email
    private final By emailField = By.xpath("//label[text()='Email']/parent::div/input");
    // Кнопка "Восстановить"
    private final By restorePasswordButton = By.xpath(".//button[text()='Восстановить']");
    // Кнопка "Войти"
    private final By loginLink = By.xpath(".//a[text()='Войти']"); // Ссылка "Войти"

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить видимость страницы восстановления пароля")
    public boolean isForgotPasswordPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(restorePasswordButton)).isDisplayed();
    }

    @Step("Нажать ссылку 'Войти' на странице восстановления пароля")
    public void clickLoginLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink));
        driver.findElement(loginLink).click();
    }
}

package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {
    private final WebDriver driver;

    // Локатор ссылки "Профиль"
    private final By profileLink = By.xpath(".//a[contains(@class, 'Account_link__2ETeP') and text()='Профиль']");
    // Кнопка "Выход"
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверить, что страница личного кабинета отображается")
    public boolean isAccountPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed() ||
                wait.until(ExpectedConditions.visibilityOfElementLocated(profileLink)).isDisplayed();
    }

    @Step("Нажать кнопку 'Выход' в личном кабинете")
    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
    }
}

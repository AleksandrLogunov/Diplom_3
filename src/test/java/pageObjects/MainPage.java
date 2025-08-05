package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    // Кнопка "Личный кабинет"
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    // Кнопка "Войти в аккаунт"
    private final By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    // Кнопка "Оформить заказ"
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    // Кнопка "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    // Логотип Stellar Burgers
    private final By stellarBurgersLogo = By.xpath(".//div[contains(@class, 'AppHeader_header__logo')]");

    // Локаторы для разделов конструктора
    // Вкладка "Булки"
    private final By bunsSection = By.xpath(".//span[text()='Булки']");
    // Вкладка "Соусы"
    private final By saucesSection = By.xpath(".//span[text()='Соусы']");
    // Вкладка "Начинки"
    private final By fillingsSection = By.xpath(".//span[text()='Начинки']");

    // Проверка активности вкладок (выбранный элемент имеет класс 'current')
    private final By activeBunsSection = By.xpath(".//div[contains(@class, 'current')]/span[text()='Булки']");
    private final By activeSaucesSection = By.xpath(".//div[contains(@class, 'current')]/span[text()='Соусы']");
    private final By activeFillingsSection = By.xpath(".//div[contains(@class, 'current')]/span[text()='Начинки']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать кнопку 'Личный кабинет' на главной странице")
    public void clickPersonalAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }

    @Step("Нажать кнопку 'Войти в аккаунт' на главной странице")
    public void clickLoginAccountButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginAccountButton));
        driver.findElement(loginAccountButton).click();
    }

    @Step("Проверить видимость кнопки 'Оформить заказ'")
    public boolean isCreateOrderButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Нажать кнопку 'Конструктор'")
    public void clickConstructorButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип Stellar Burgers")
    public void clickStellarBurgersLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(stellarBurgersLogo));
        driver.findElement(stellarBurgersLogo).click();
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickBunsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bunsSection));
        driver.findElement(bunsSection).click();
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickSaucesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(saucesSection));
        driver.findElement(saucesSection).click();
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickFillingsSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsSection));
        driver.findElement(fillingsSection).click();
    }

    @Step("Проверить, что раздел 'Булки' активен")
    public boolean isBunsSectionActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeBunsSection));
        return driver.findElement(activeBunsSection).isDisplayed();
    }

    @Step("Проверить, что раздел 'Соусы' активен")
    public boolean isSaucesSectionActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeSaucesSection));
        return driver.findElement(activeSaucesSection).isDisplayed();
    }

    @Step("Проверить, что раздел 'Начинки' активен")
    public boolean isFillingsSectionActive() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeFillingsSection));
        return driver.findElement(activeFillingsSection).isDisplayed();
    }
}

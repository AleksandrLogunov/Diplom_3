package tests;

import org.junit.jupiter.api.*;
import pageObjects.AccountPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountNavigationTests extends BaseTest {

    private AccountPage accountPage;

    @BeforeEach
    public void setupAccountTest() {

        accountPage = new AccountPage(driver);

        userClient.createUser(user)
                .then()
                .statusCode(200);

        mainPage.clickLoginAccountButton();

        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась после входа");

        accessToken = userClient.loginUser(user)
                .then().extract().path("accessToken");
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на 'Личный кабинет'")
    public void goToPersonalAccountTest() {
        mainPage.clickPersonalAccountButton();
        assertTrue(accountPage.isAccountPageDisplayed(), "Страница личного кабинета не отобразилась");
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на 'Конструктор'")
    public void goToConstructorFromAccountByConstructorButtonTest() {
        mainPage.clickPersonalAccountButton();
        assertTrue(accountPage.isAccountPageDisplayed(), "Страница личного кабинета не отобразилась");

        mainPage.clickConstructorButton();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась, переход в конструктор не удался");
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void goToConstructorFromAccountByLogoTest() {
        mainPage.clickPersonalAccountButton();
        assertTrue(accountPage.isAccountPageDisplayed(), "Страница личного кабинета не отобразилась");

        mainPage.clickStellarBurgersLogo();
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась, переход в конструктор не удался");
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке 'Выйти' в личном кабинете")
    public void logoutFromAccountTest() {
        mainPage.clickPersonalAccountButton();
        assertTrue(accountPage.isAccountPageDisplayed(), "Страница личного кабинета не отобразилась");

        accountPage.clickLogoutButton();
        assertTrue(loginPage.isLoginPageDisplayed(), "Страница входа не отобразилась после выхода");
    }
}

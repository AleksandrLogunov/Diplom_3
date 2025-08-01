package tests;

import org.junit.jupiter.api.*;
import pageObjects.ForgotPasswordPage;
import pageObjects.RegisterPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    private ForgotPasswordPage forgotPasswordPage;
    private RegisterPage registerPage;

    @BeforeEach
    public void setupLoginTest() {

        forgotPasswordPage = new ForgotPasswordPage(driver);
        registerPage = new RegisterPage(driver);

        userClient.createUser(user)
                .then()
                .statusCode(200);

        accessToken = userClient.loginUser(user)
                .then().extract().path("accessToken");
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной странице")
    public void loginFromMainPageAccountButtonTest() {
        mainPage.clickLoginAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась после входа");
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет' на главной странице")
    public void loginFromPersonalAccountButtonTest() {
        mainPage.clickPersonalAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась после входа");
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegistrationFormTest() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();
        registerPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась после входа");
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordFormTest() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickForgotPasswordLink();
        assertTrue(forgotPasswordPage.isForgotPasswordPageDisplayed());
        forgotPasswordPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась после входа");
    }

}
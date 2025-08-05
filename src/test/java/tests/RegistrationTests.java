package tests;

import org.junit.jupiter.api.*;
import pageObjects.RegisterPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTests extends BaseTest {

    private RegisterPage registerPage;

    @BeforeEach
    public void setupTest() {

        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successfulRegistrationTest() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();

        registerPage.register(user.getName(), user.getEmail(), user.getPassword());

        assertTrue(loginPage.isLoginPageDisplayed(), "Страница входа не отобразилась после успешной регистрации");

        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isCreateOrderButtonDisplayed(), "Кнопка 'Оформить заказ' не отобразилась после входа");

        accessToken = userClient.loginUser(user)
                .then().extract().path("accessToken");
    }

    @Test
    @DisplayName("Ошибка регистрации при использовании  пароля менее 6 символов")
    public void registrationWithShortPasswordShowsErrorTest() {
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterLink();

        String shortPassword = "123";
        registerPage.register(user.getName(), user.getEmail(), shortPassword);
        assertTrue(registerPage.isIncorrectPasswordErrorDisplayed(), "Сообщение об ошибке некорректного пароля не отобразилось");
    }
}
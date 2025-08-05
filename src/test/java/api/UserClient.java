package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserClient {

    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final String REGISTER_PATH = "/api/auth/register";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String USER_PATH = "/api/auth/user";

    public UserClient() {
        RestAssured.baseURI = BASE_URL;
    }

    @Step("Создать пользователя через API")
    public Response createUser(User user) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(REGISTER_PATH);
    }

    @Step("Авторизовать пользователя через API")
    public Response loginUser(User user) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post(LOGIN_PATH);
    }

    @Step("Удалить пользователя через API с токеном")
    public Response deleteUser(String accessToken) {
        return RestAssured.given()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_PATH);
    }
}

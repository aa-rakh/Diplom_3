package org.example;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static io.restassured.RestAssured.given;

@Getter
@Setter
@AllArgsConstructor
public class UserData {
    private String email;
    private String password;
    private String name;

    public UserData() {
    }

    @Step("Send POST request to /api/auth/register")
    public Response sendRequestCreate(UserData newUser){
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(newUser)
                .when()
                .post("/api/auth/register");
        System.out.println(response.getBody().asString());
        return response;
    }

    @Step("Send DELETE request to /api/auth/user")
    public Response sendRequestDelete(String accessToken) {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        Response response = given()
                .header("Authorization", accessToken)
                .delete("/api/auth/user");
        System.out.println(response.getBody().asString());
        return response;
    }
}


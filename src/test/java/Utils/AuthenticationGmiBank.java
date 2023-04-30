package Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static void main(String[] args) {
        System.out.println(gmiBankToken());
    }

    public static String gmiBankToken(){

        Map<String, Object> tokenBody = new HashMap<>();
        tokenBody.put("password", "Mark.123");
        tokenBody.put("rememberMe", true);
        tokenBody.put("username", "mark_twain");

        Response response = given().body(tokenBody).contentType(ContentType.JSON).post("https://gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");


    }







}

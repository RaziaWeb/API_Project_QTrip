package utils;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils 
{
    public static AuthResponse loginAndGetToken(String email,String password)
    {
        JSONObject body= new JSONObject();
        body.put("email",email);
        body.put("password",password);


        Response response=RestAssured.given()
                          .header("Content-Type","application/json")
                          .body(body.toString())
                          .when()
                          .post("https://qtrip-backend.labs.crio.do/api/v1/login")
                          .then()
                          .statusCode(201)
                          .extract().response();
            System.out.println(response.jsonPath().getString("data.token"));
            System.out.println(response.jsonPath().getString("data.id"));

            String token=response.jsonPath().getString("data.token");
            String id=response.jsonPath().getString("data.id");
        return new AuthResponse(token,id);
        
    }
}

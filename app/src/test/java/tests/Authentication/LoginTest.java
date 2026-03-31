package tests.Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.DP;

import org.json.JSONObject;


public class LoginTest
{
    // @Test(dependsOnMethods = {"tests.Authentication.RegisterTest.RegregisterUserSuccess"})
@Test(dataProvider="DP1",dataProviderClass=DP.class)
public void loginUserSuccess(String uName,String pwd)
    {
        JSONObject loginBody=new JSONObject();
        loginBody.put("email", uName);
        loginBody.put("password", pwd);

        Response res=RestAssured.given()
                     .contentType("application/json")
                     .body(loginBody.toString())
                     .when()
                     .post("https://qtrip-backend.labs.crio.do/api/v1/login")
                     .then()
                     .log().all().extract().response();

      System.out.println( "Status Code: "+res.getStatusCode());
       System.out.println( "Token: "+res.jsonPath().getString("data.token"));
       System.out.println( "ID: "+res.jsonPath().getString("data.id"));


       Assert.assertEquals(res.getStatusCode(), 201);
       Assert.assertNotNull(res.jsonPath().getString("data.token"));
       Assert.assertNotNull(res.jsonPath().getString("data.id"));
    }
}

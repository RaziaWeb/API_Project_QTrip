
package tests.Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.DP;

import org.json.JSONObject;

public class RegisterTest 

{
    @Test(dataProvider = "DP1", dataProviderClass = DP.class)
    public void RegregisterUserSuccess(String uName,String pwd,String confirmpwd)
    {
        // Create unique email
        // String email = "user" + System.currentTimeMillis() + "@gmail.com";
        // String password = "user123";

        // Print the credentials so you can use them for login
        System.out.println("=== REGISTER CREDENTIALS ===");
        System.out.println("Email: " + uName);
        System.out.println("Password: " + pwd);
        System.out.println("============================");


        JSONObject registerBody = new JSONObject();
        registerBody.put("email", uName); // unique email
        registerBody.put("password", pwd);
        registerBody.put("confirmpassword", confirmpwd);

        Response resp=RestAssured.given().header("Content-Type","application/json")
        .body(registerBody.toString())
        .when()
        .post("https://qtrip-backend.labs.crio.do/api/v1/register")
        .then()
                .log().all()    // logs response
                .extract()
                .response();


        System.out.println(resp.getStatusCode());
        System.out.println("Response body: " + resp.getBody().asString());
        Assert.assertEquals(resp.getStatusCode(),201);
    }
}

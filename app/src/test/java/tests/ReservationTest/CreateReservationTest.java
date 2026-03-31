package tests.ReservationTest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;
import utils.AuthResponse;

public class CreateReservationTest
{
    @Test
    public void createReservation()
    {
        AuthResponse auth =ApiUtils.loginAndGetToken("user1774794945164@gmail.com","user123");

        String tokenValue=auth.getToken();
         String tokenId=auth.getId();
        
        JSONObject reservatonBody=new JSONObject();
        reservatonBody.put("userId", tokenId);
        reservatonBody.put("name", "testUser");
        reservatonBody.put("date", "2026-04-30");
        reservatonBody.put("person", 10);
        reservatonBody.put("adventure",  2447910730L);

        Response res=RestAssured.given()
        .header("Content-Type","application/json")
        .header("Authorization","Bearer "+tokenValue)
        .body(reservatonBody.toString())
        .when()
        .post("https://qtrip-backend.labs.crio.do/api/v1/reservations/new");

        System.out.println("STATUS: " + res.getStatusCode());
        System.out.println("RESPONSE: " + res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(),200);
    }
}

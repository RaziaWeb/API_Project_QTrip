package tests.ReservationTest;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;
import utils.AuthResponse;

public class DeleteReservationTest 

{
    @Test
    public void deleteRervation()
    {
       AuthResponse auth=ApiUtils.loginAndGetToken("user1774794945164@gmail.com","user123");
      String token= auth.getToken();
      String userId=auth.getId();

      JSONObject body = new JSONObject();
      body.put("userId", userId);

      Response res=RestAssured.given()
      .header("Authorization","Bearer "+token)
      .header("Content-Type","application/json")
      .body(body.toString())
      .when()
      .delete("https://qtrip-backend.labs.crio.do/api/v1/reservations/39078b6ff9d8042e");

      Assert.assertEquals(res.getStatusCode(), 200);


    }
}

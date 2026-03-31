package tests.ReservationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiUtils;
import utils.AuthResponse;

public class GetReservationsTest 
{
    @Test
    public void getReservations()
    {
         AuthResponse auth=ApiUtils.loginAndGetToken("user1774794945164@gmail.com","user123");
         String token=auth.getToken();
         String idVal=auth.getId();

         Response res=RestAssured.given()
         .header("Content-Type","application/json")
         .header("Authorization","Bearer "+token)
         .when()
         .get("https://qtrip-backend.labs.crio.do/api/v1/reservations?id="+idVal);

         System.out.println("STATUS: "+res.getStatusCode());
         System.out.println("RESPONSE"+res.asPrettyString());

         Assert.assertEquals(res.getStatusCode(),200);
         Assert.assertTrue(res.jsonPath().getList("$").size() > 0);

         String name=res.jsonPath().getString("[0].name");
         Assert.assertEquals(name, "Testuser");

         String userId=res.jsonPath().getString("[0].userId");
         Assert.assertEquals(userId,"tQBEccDFWQzyFTpt");

        //  Boolean status=res.jsonPath().getBoolean("[0].isCancelled");
        //  Assert.assertFalse(status);

    }
}

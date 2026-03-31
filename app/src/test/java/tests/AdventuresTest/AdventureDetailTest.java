package tests.AdventuresTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AdventureDetailTest
 {

@Test
public void getAdventureDetail()
{
    String adventureId="2447910730";

    Response response=RestAssured.get("https://qtrip-backend.labs.crio.do/api/v1/adventures/detail?adventure=" + adventureId);

    System.out.println(response.getStatusCode());

     System.out.println(response.asPrettyString());

     Assert.assertEquals(response.getStatusCode(), 200);


}
    
}

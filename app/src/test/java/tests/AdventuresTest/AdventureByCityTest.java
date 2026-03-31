package tests.AdventuresTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AdventureByCityTest 
{
@Test
public void getAdventuresForCity()
{

  String city="bengaluru";
  
  Response response=RestAssured.get("https://qtrip-backend.labs.crio.do/api/v1/adventures?city=" + city);

  System.out.println("Status Code:"+response.getStatusCode());
  System.out.println("Number of Advetures in the given city:"+response.jsonPath().getList("$").size());
  System.out.println(response.asPrettyString());

  Assert.assertEquals(response.getStatusCode(), 200);
  Assert.assertTrue(response.jsonPath().getList("$").size()>0);

}  
}
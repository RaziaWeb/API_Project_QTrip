package tests.AdventuresTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SearchSpecificAdventurerInCityTest
{
   @Test
   public void searchAdventure()
   {
     String city="bengaluru";
     String query="nia";

     Response response=RestAssured.get("https://qtrip-backend.labs.crio.do/api/v1/adventures?city="+city +"&q="+query);
     
    System.out.println("StatusCode :"+response.getStatusCode()); 
    System.out.println(response.asPrettyString()); 

    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertEquals(response.jsonPath().getList("$").size(), 1);


   } 
}

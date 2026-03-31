package tests.CitiesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SearchCityTest 
{
 @Test
public void searchCityByQuery()
{
  String query="beng";

  Response res=RestAssured
               .get("https://qtrip-backend.labs.crio.do/api/v1/cities?q=" + query);
  
    System.out.println("Size of List:"+res.jsonPath().getList("$").size());
   Assert.assertEquals(res.getStatusCode(),200);     
   Assert.assertEquals(res.jsonPath().getList("$").size(),1);     
}
    
}

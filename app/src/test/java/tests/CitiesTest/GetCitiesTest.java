package tests.CitiesTest;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCitiesTest
{
@Test
public void getAllCities()
{
    Response res=RestAssured.get("https://qtrip-backend.labs.crio.do/api/v1/cities");

    System.out.println("Status Code: "+res.getStatusCode());
     System.out.println("Size of List: "+res.jsonPath().getList("$").size());
 System.out.println(res.asPrettyString());
    
System.out.println("Name of the Cities:");
List<Map<String,Object>>cities=res.jsonPath().getList("$");
 for(Map<String, Object> city:cities)
 {
    System.out.println(city.get("city"));
 }


    Assert.assertEquals(res.getStatusCode(),200);
    Assert.assertTrue(res.jsonPath().getList("$").size()>0);
}
}



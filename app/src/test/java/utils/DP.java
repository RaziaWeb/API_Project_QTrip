package utils;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DP
 {
    @DataProvider(name="DP1")
    public Object[][] getData(Method m) throws IOException
    {
        String sheetName="";
      if(m.getName().equalsIgnoreCase("RegregisterUserSuccess"))
      {
         sheetName="RegisterData";
      }

      else if(m.getName().equalsIgnoreCase("loginUserSuccess"))
      {
        sheetName="LoginData";
      }

  return ExcelUtilities.getTestData(sheetName);
    }
} 
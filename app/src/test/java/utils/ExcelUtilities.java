package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities 
{
    public static Object[][] getTestData(String sheetName) throws IOException
    {
        String filePath=System.getProperty("user.dir")+"/src/test/resources/Data.xlsx";
        FileInputStream fis=new FileInputStream(filePath);

        XSSFWorkbook wkbk=new XSSFWorkbook(fis);
        XSSFSheet sheet=wkbk.getSheet(sheetName);

        int rowCount=sheet.getPhysicalNumberOfRows();
        int colCount=sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][]data=new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++)
        {
             XSSFRow row= sheet.getRow(i);
        
        for(int j=0;j<colCount;j++)
        {
               String cell= row.getCell(j).toString();
               data[i-1][j]=cell;
        }

    }
        wkbk.close();
        return data;
    }
}

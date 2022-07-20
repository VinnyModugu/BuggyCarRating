package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Properties;

public class Readpropetyfile {

    public static void main(String[] args) throws IOException
    {
        Readpropetyfile red = new Readpropetyfile();
        System.out.println(red.getData("Sheet1",1,0));
    }
    public String getData(String excelSheetName, int i, int j ) throws IOException
    {
        File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);
        int totalRows = sheetName.getLastRowNum() + 1;
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        DataFormatter format = new DataFormatter();
        String testData;
        testData = format.formatCellValue(sheetName.getRow(i).getCell(j));
        return testData;
    }
}

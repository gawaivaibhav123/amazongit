package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



public class Utilityclass{

	public static void capture(WebDriver driver,int testid) throws IOException {
		
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY--MM--HH--mm--ss");
		Date date=new Date();
		
		String dateTime=sdf.format(date);
		
		//create filename
		String Screenshot=dateTime+"-"+testid;
		//script for screenshot
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//save screenshot
		
		File dest=new File("C:\\Users\\Dell\\eclipse-workspace\\Amazonwork\\test-output\\ScreensShots\\Screenshot\\testid.png");
		FileHandler.copy(source, dest);
	}
    private static final String File_Name="src\\main\\resources\\testdata\\Batch04.xlsx";
    public static String FetchData(String sheetName,int row, int cell) {
    	String data=null;
    	FileInputStream file = null;
    	Workbook workbook=null;
    	
    	try {
    		
    			file=new FileInputStream(File_Name);
    			workbook=new XSSFWorkbook(file);
    			Sheet sheet=workbook.getSheet(sheetName);
    			Row rowObj=sheet.getRow(row);
    			Cell cellObj=rowObj.getCell(cell);
    			data=cellObj.getStringCellValue();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    	finally {
    		try {
    			if(data!=null) {
    				file.close();
    			}
    			if(workbook!=null) {
    				file.close();
    			}
    			if(file!=null) {
    				file.close();
    			}
    		}
    		catch(IOException e){
    			e.printStackTrace();
    		}
    	}
    	return data;
    }
    
	}



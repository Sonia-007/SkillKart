package com.etrading.skillkart.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibaray {
	
	
public static Object[][] allDataFromExcel(String path,String sheetname){
	
	Object[][] arr=null;
	try {
	Sheet sheet = WorkbookFactory.create(new FileInputStream(path)).getSheet(sheetname);
	int rowcount = sheet.getPhysicalNumberOfRows();
	 arr=new Object[rowcount-1][];
	for(int i=1,k=0;i<=rowcount-1;i++,k++) {
		int cellcount = sheet.getRow(i).getPhysicalNumberOfCells();
		
		arr[k]=new Object[cellcount];
		for(int j=0;j<=cellcount-1;j++) {
			arr[k][j]=sheet.getRow(i).getCell(j).toString();
		}
		
	}
	
	
}
catch(IOException e) {
	System.out.println(e);
}
	return arr;
}

public static String requiredData(String path,String name,int rownum,int cellnum) {
	String data=null;
	try {
		//data=WorkbookFactory.create(new FileInputStream(path)).getSheet(name).getRow(rownum).getCell(cellnum).getStringCellValue();
		data=WorkbookFactory.create(new FileInputStream(path)).getSheet(name).getRow(rownum).getCell(cellnum).toString();
	}
	catch(IOException e) {
		System.out.println(e);
	}
	System.out.println(data);
	return data;
}

}


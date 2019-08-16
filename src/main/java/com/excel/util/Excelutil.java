package com.excel.util;

import java.util.ArrayList;
import java.util.List;

public class Excelutil {

	static ExcelReader excelReader;

	public static ArrayList<Object[]> getDataFromExcel() {
		ArrayList<Object[]> dataList = new ArrayList<Object[]>();
		try {
			excelReader = new ExcelReader(
					"C:\\Users\\Jeyanthi\\eclipse-workspace\\CarGurus\\src\\test\\resource\\Cargurus testdata.xlsx");

			for (int rowNum = 2; rowNum <= excelReader.getRowCount("search"); rowNum++) {
				String make = excelReader.getCellData("search", "Make", rowNum);
				String model = excelReader.getCellData("search", "Model", rowNum);
				String yearStart = excelReader.getCellData("search", "YearStart", rowNum);
				String yearEnd = excelReader.getCellData("search", "YearEnd", rowNum);
				String zipcode = excelReader.getCellData("search", "Zipcode", rowNum);
				String radius = excelReader.getCellData("search", "Radius", rowNum);
				Object[] obj = { make, model, yearStart, yearEnd,zipcode,radius };
				dataList.add(obj);
				System.out.println(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;

	}
	
	public static ArrayList<Object[]> getDataFromExcel(String sheetName, String[] columnNames) {
		ArrayList<Object[]> dataObjects = new ArrayList<Object[]>();
		try {
			
			excelReader = new ExcelReader("C:\\Users\\Jeyanthi\\eclipse-workspace\\CarGurus\\src\\test\\resource\\Cargurus testdata.xlsx");
			System.out.println(excelReader.getRowCount(sheetName));
			for (int rowNum = 2; rowNum <= excelReader.getRowCount(sheetName); rowNum++) {
				List<String> dataList = new ArrayList<String>();
				for (int i = 0; i < columnNames.length; i++) {
					String data = excelReader.getCellData(sheetName, columnNames[i], rowNum);
					dataList.add(data);
					System.out.println(data);
				}
				dataObjects.add(dataList.toArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataObjects;

	}

	public static void main(String[] args) {
		getDataFromExcel("search",new String[] {"Make","Model","YearStart","YearEnd","Zipcode","Radius"});
	
		getDataFromExcel("style",new String[] {"Body Style","Zipcode","Radius","YearStart","YearEnd","Price Mini","Price Max","Max Milelage","Transmission"});
		getDataFromExcel("Price",new String[] {"Zipcode","Radius","YearStart","YearEnd","Price Mini","Price Max","Max Milelage","Transmission"});
	}
	
}

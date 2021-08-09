package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    @Test
    public void excel_writing_test() throws IOException {
        String path ="SampleData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        workbook = new XSSFWorkbook(fileInputStream);

        sheet = workbook.getSheet("Employee");

        row = sheet.getRow(1);

        cell = row.getCell(1);
     // Create and store adamCell
        XSSFCell adamCell = sheet.getRow(2).getCell(0);

        System.out.println("Before : " + adamCell);

        //This method will override existing cell
        adamCell.setCellValue("Madam");

        System.out.println("After: "+ adamCell);

        //TODO: CHANGE STEVEN'S NAME TO TOM

        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
           if( sheet.getRow(rowNum).getCell(0).toString().equals("Steven")) {
               sheet.getRow(rowNum).getCell(0).setCellValue("Tom");

           }

        }


        //==============================================================================
       //Use fileOutputStream to push changes -> load the file to fileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        //Write to file using fileOutputStream
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

}

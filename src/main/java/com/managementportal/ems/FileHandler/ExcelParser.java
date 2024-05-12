//package com.managementportal.ems.FileHandler;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
//
//public class ExcelParser {
//    public static void main(String[] args) {
//        // Path to your Excel file
//        String filePath = "path/to/your/excel/file.xlsx";
//
//        try {
//            // Create a FileInputStream to read the Excel file
//            FileInputStream fis = new FileInputStream(new File(filePath));
//
//            // Create a Workbook object for the Excel file
//            Workbook workbook = new Workbook(fis);
//
//            // Get the first sheet of the Excel file
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Iterate over all rows in the sheet
//            for (Row row : sheet) {
//                // Iterate over all cells in the row
//                for (Cell cell : row) {
//                    // Print the cell value
//                    System.out.print(cell.toString() + "\t");
//                }
//                // Move to the next line after printing all cells in the row
//                System.out.println();
//            }
//
//            // Close the workbook and file input stream
//            workbook.close();
//            fis.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

package IMT.DemoTrain.Utility;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import IMT.DemoTrain.entity.User;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelGeneratorUtility {
    public static void employeeDetailReport(HttpServletResponse response, List<User> user) {
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("ueser");

            CellStyle cellStyle = workbook.createCellStyle();


            //set border to table
            cellStyle.setBorderTop(BorderStyle.MEDIUM);
            cellStyle.setBorderRight(BorderStyle.MEDIUM);
            cellStyle.setBorderBottom(BorderStyle.MEDIUM);
            cellStyle.setBorderLeft(BorderStyle.MEDIUM);
            cellStyle.setAlignment(HorizontalAlignment.LEFT);


            // Header
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Id");
            cell.setCellStyle(cellStyle);


            Cell cell1 = row.createCell(1);
            cell1.setCellValue("userName");
            cell1.setCellStyle(cellStyle);


            Cell cell2 = row.createCell(2);
            cell2.setCellValue("password");
            cell2.setCellStyle(cellStyle);

            Cell cell3 = row.createCell(3);
            cell3.setCellValue("firstName");
            cell3.setCellStyle(cellStyle);

            Cell cell4 = row.createCell(4);
            cell4.setCellValue("lastName");
            cell4.setCellStyle(cellStyle);

            Cell cell5 = row.createCell(5);
            cell5.setCellValue("dob");
            cell5.setCellStyle(cellStyle);


            //Set data
            int rowNum = 1;
            for (User emp : user) {
                Row empDataRow = sheet.createRow(rowNum++);
                Cell empIdCell = empDataRow.createCell(0);
                empIdCell.setCellStyle(cellStyle);
                empIdCell.setCellValue(emp.getId());

                Cell empNameCell = empDataRow.createCell(1);
                empNameCell.setCellStyle(cellStyle);
                empNameCell.setCellValue(emp.getUserName());

                Cell empPassCell = empDataRow.createCell(2);
                empPassCell.setCellStyle(cellStyle);
                empPassCell.setCellValue(emp.getPassword());

                Cell empFirstCell = empDataRow.createCell(3);
                empFirstCell.setCellStyle(cellStyle);
                empFirstCell.setCellValue(emp.getFirstName());

                Cell empLastCell = empDataRow.createCell(4);
                empLastCell.setCellStyle(cellStyle);
                empLastCell.setCellValue(emp.getLastName());

                Cell empDobCell = empDataRow.createCell(5);
                empDobCell.setCellStyle(cellStyle);
                empDobCell.setCellValue(emp.getDob());
                
            }

            //write output to response
            workbook.write(response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

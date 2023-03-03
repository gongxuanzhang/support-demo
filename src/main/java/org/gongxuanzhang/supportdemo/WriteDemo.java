package org.gongxuanzhang.supportdemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gxz gongxuanzhangmelt@gmail.com
 **/
public class WriteDemo {
    public static void main(String[] args) throws Exception {
        try (XSSFWorkbook xssfWorkbook = new XSSFWorkbook("export.xlsx");
             FileOutputStream fileOutputStream = new FileOutputStream("new.xlsx")) {
            XSSFSheet sheetAt = xssfWorkbook.getSheetAt(0);
            Map<Integer, String> errorMessage = getErrorMessage();
            errorMessage.forEach((index, error) -> {
                XSSFRow row = sheetAt.getRow(index);
                XSSFCell cell = row.createCell(3);
                cell.setCellValue(error);
            });
            xssfWorkbook.write(fileOutputStream);
        }

    }

    public static Map<Integer, String> getErrorMessage() {
        Map<Integer, String> errorMessage = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            errorMessage.put(i, String.format("第%s错了", i));
        }
        return errorMessage;
    }
}

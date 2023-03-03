package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.handler.context.WorkbookWriteHandlerContext;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Date;
import java.util.List;

/**
 * @author gxz gongxuanzhangmelt@gmail.com
 **/
public class DemoMain {

    public static void main(String[] args) {
        String fileName = "export.xlsx";
        EasyExcel.write(fileName).sheet("模板").registerWriteHandler(new WorkbookWriteHandler() {
            @Override
            public void afterWorkbookDispose(WorkbookWriteHandlerContext context) {
                Workbook workbook = context.getWriteWorkbookHolder().getWorkbook();
                Sheet sheetAt = workbook.getSheetAt(0);
                for (int i = 0; i <= sheetAt.getLastRowNum(); i++) {
                    Row row = sheetAt.getRow(i);
                    Cell cell = row.createCell(3);
                    cell.setCellValue("错误内容");
                }
            }
        }).doWrite(data());
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

}

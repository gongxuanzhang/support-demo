package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.metadata.Head;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.Cell;

import java.util.Date;
import java.util.List;

/**
 * @author gxz gongxuanzhangmelt@gmail.com
 **/
public class DemoMain {

    public static void main(String[] args) {
        String fileName = "export.xlsx";
        EasyExcel.write(fileName).sheet("模板").registerWriteHandler(new SheetWriteHandler() {
            @Override
            public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
                writeSheetHolder.getSheet().protectSheet("password");
            }
        }).registerWriteHandler(new CellWriteHandler() {
            @Override
            public void afterCellDispose(CellWriteHandlerContext context) {
                context.getCell().getCellStyle().setLocked(true);
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

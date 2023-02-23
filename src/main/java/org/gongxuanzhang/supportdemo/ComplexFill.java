package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class ComplexFill {

    public static void main(String[] args) {
        File file = new File("demo.xlsx");
        // 分页查询数据
        EasyExcel.write(file, DemoData.class)
                .sheet("模板").registerWriteHandler(new RowWriteHandler() {
                    @Override
                    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder,
                                                Row row, Integer relativeRowIndex, Boolean isHead) {
                        //  每个两个插入一个分页符
                        if (relativeRowIndex % 2 == 1) {
                            writeSheetHolder.getSheet().setRowBreak(relativeRowIndex);
                        }

                    }
                })
                .doWrite(ComplexFill::data);
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

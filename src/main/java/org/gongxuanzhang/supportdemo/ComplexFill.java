package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.handler.context.SheetWriteHandlerContext;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class ComplexFill {

    public static void main(String[] args) {
        File file = new File("demo.xlsx");
        try (ExcelWriter excelWriter = EasyExcel.write(file.getAbsoluteFile(), DemoData.class).build()) {
            for (int i = 0; i < 5; i++) {
                final int finalI = i;
                // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                WriteSheet writeSheet =
                        EasyExcel.writerSheet(i, "模板" + i).registerWriteHandler(new SheetWriteHandler() {
                            @Override
                            public void afterSheetCreate(SheetWriteHandlerContext context) {
                                System.out.println(String.format("这是第%s个sheet生成", finalI));
                            }
                        }).build();
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = data();
                excelWriter.write(data, writeSheet);
            }
        }
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

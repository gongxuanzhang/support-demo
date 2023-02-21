package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.handler.context.WorkbookWriteHandlerContext;
import org.apache.poi.ss.usermodel.Sheet;

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
                .sheet("模板").registerWriteHandler(new WorkbookWriteHandler() {
                    @Override
                    public void afterWorkbookDispose(WorkbookWriteHandlerContext context) {
                        Sheet sheet = context.getWriteContext().writeSheetHolder().getSheet();
                        //   这里手动合并
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

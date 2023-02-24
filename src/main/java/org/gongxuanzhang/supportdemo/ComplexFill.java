package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.WorkbookWriteHandler;
import com.alibaba.excel.write.handler.context.WorkbookWriteHandlerContext;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
                .sheet("模板").registerWriteHandler(new ImageListener())
                .doWrite(ComplexFill::data);
    }


    public static class ImageListener implements WorkbookWriteHandler {


        @Override
        public void afterWorkbookDispose(WorkbookWriteHandlerContext context) {
            try {
                String resource = ComplexFill.class.getClassLoader().getResource("og-spring.png").getFile();
                Workbook wb = context.getWriteWorkbookHolder().getWorkbook();
                ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                // 加载图片
                BufferedImage bufferImg = ImageIO.read(new File(resource));
                ImageIO.write(bufferImg, "jpg", byteArrayOut);
                Sheet sheet1 = wb.getSheetAt(0);
                Drawing<?> patriarch = sheet1.createDrawingPatriarch();
                XSSFClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, (short) 2, 2, (short) 5, 8);
                // 插入图片
                patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(),
                        XSSFWorkbook.PICTURE_TYPE_JPEG));
            } catch (Exception e) {
                e.printStackTrace();
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

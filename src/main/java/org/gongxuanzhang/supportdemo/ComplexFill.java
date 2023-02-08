package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Component
public class ComplexFill {


    @PostConstruct
    public void fill() {
        URL resource = this.getClass().getClassLoader().getResource("downloadbilltemplate.xlsx");
        File fileName = new File(this.getClass().getClassLoader().getResource("").getFile());
        File exportFile = new File(fileName, System.currentTimeMillis() + ".xlsx");
        try (ExcelWriter excelWriter = EasyExcel.write(exportFile).withTemplate(resource.getFile()).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(data(), fillConfig, writeSheet);
            Map<String, Object> map = MapUtils.newHashMap();
            map.put("A1", "这是A1");
            map.put("A2", "这是A2");
            excelWriter.fill(map, writeSheet);
        }
        System.out.println("导出文件在" + exportFile.getAbsoluteFile());
    }

    private List<A> data() {
        List<A> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            A a = new A();
            a.setA("a" + i);
            a.setB("b" + i);
            a.setC("c" + i);
            result.add(a);
        }
        return result;
    }


}

package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * @author gongxuanzhang
 */
@Data
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty(value = "图片", converter = StringUrlConverter.class)
    private String url;

}

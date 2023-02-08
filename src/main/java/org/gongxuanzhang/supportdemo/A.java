package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
@Data
public class A {
    @ExcelProperty("交易时间")
    private String a;
    @ExcelProperty("公众账号ID")
    private String b;
    @ExcelProperty("商户号")
    private String c;

}

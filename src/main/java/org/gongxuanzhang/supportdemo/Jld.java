package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 工程计量单
 */
@Data
public class Jld {

    @ExcelProperty(index = 0)
    private String xh;
    @ExcelProperty(index = 1)
    private String team;
    @ExcelProperty(index = 2)
    private String content;
    @ExcelProperty(index = 3)
    private String unit;
    @ExcelProperty(index = 4)
    private String num;
    @ExcelProperty(index = 5)
    private String price;
    @ExcelProperty(index = 6)
    private String money;
    @ExcelProperty(index = 7)
    private String lastMoney;


}

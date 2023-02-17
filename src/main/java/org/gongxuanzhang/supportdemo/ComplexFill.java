package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;

import java.net.URL;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class ComplexFill {

    public static void main(String[] args) {
        URL resource = ComplexFill.class.getClassLoader().getResource("demo.xlsx");

        EasyExcel.read(resource.getFile(), Jld.class,new MyLister()).sheet(0).headRowNumber(9).doReadSync();
    }


}

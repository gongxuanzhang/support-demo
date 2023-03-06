package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gxz gongxuanzhangmelt@gmail.com
 **/
public class DemoMain {

    public static void main(String[] args) {
        String fileName = "export.xlsx";
        EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(data());
    }

    private static List<List<String>> data() {
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> row = new ArrayList<>();
            row.add("1子菜单"+i);
            row.add("2子菜单"+i);
            data.add(row);
        }
        return data;
    }

    private static List<List<String>> head() {
        List<List<String>> list = new ArrayList<>();

        List<String> head0 = ListUtils.newArrayList();
        List<String> head1 = ListUtils.newArrayList();
        head0.add("一级菜单1");
        head1.add("一级菜单2");
        list.add(head0);
        list.add(head1);
        return list;
    }
}

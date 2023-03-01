package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;

import java.util.Date;
import java.util.List;

/**
 * @author gxz gongxuanzhangmelt@gmail.com
 **/
public class DemoMain {

    public static void main(String[] args) {
        String fileName = "export.xlsx";
        EasyExcel.write(fileName).head(head()).sheet("模板").doWrite(data());
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

    private static List<List<String>> head() {
        List<List<String>> list = ListUtils.newArrayList();
        //  一共六列
        List<String> head0 = ListUtils.newArrayList();
        List<String> head1 = ListUtils.newArrayList();
        List<String> head2 = ListUtils.newArrayList();
        List<String> head3 = ListUtils.newArrayList();
        List<String> head4 = ListUtils.newArrayList();
        List<String> head5 = ListUtils.newArrayList();
        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        list.add(head5);
        //  第一行一样
        head0.add("都一样");
        head1.add("都一样");
        head2.add("都一样");
        head3.add("都一样");
        head4.add("都一样");
        head5.add("都一样");
        //  第二行 后两个一样 前面各自不同
        head0.add("0");
        head1.add("1");
        head2.add("2");
        head3.add("3");
        head4.add("后两个一样");
        head5.add("后两个一样");
        //  第三行 3 4个一样 其他不同
        head0.add("0");
        head1.add("1");
        head2.add("2");
        head3.add("这两个一样");
        head4.add("这两个一样");
        head5.add("5");
        return list;
    }
}

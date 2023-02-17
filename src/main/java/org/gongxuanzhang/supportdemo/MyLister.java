package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class MyLister implements ReadListener<Jld> {
    @Override
    public void invoke(Jld o, AnalysisContext analysisContext) {
        System.out.println(o);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

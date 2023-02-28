package org.gongxuanzhang.supportdemo;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.url.UrlImageConverter;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.io.IOException;
import java.net.URL;

/**
 * @author gongxuanzhang
 */
public class StringUrlConverter implements Converter<String> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public WriteCellData<?> convertToExcelData(String value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) throws IOException {
        URL url = new URL(value);
        return new UrlImageConverter().convertToExcelData(url, contentProperty, globalConfiguration);
    }

}

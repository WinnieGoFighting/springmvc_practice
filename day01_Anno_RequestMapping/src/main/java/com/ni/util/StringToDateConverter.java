package com.ni.util;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String,Date> {
  @Override
    public Date convert(String s) {
        if (s==null)
            throw new RuntimeException("请传入数据");
      DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
      try {
          Date date = df.parse(s);
          return date;
      } catch (ParseException e) {
          throw new RuntimeException("e");
      }
  }
}

package com.cqupt.ssm.utils;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {


    // 日期转换成字符串
    public static String data2String(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String formate = sdf.format(date);
        return formate;
    }

    // 字符串转换成日期
    public static Date string2Date(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(str);
        return parse;
    }
}

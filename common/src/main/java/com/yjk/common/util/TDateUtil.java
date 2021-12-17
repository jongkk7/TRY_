package com.yjk.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TDateUtil {

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    public static SimpleDateFormat dateFormatKor = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");

    /**
     * 날짜 포맷 변경
     * TODO - 소스 검증 필요
     */
    public static String parseDate(String dateStr, SimpleDateFormat before, SimpleDateFormat after){

        String result = dateStr;

        try{

            Date date = before.parse(dateStr);
            result = after.format(date);

        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

}
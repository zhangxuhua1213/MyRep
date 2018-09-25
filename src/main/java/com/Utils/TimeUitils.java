package com.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUitils {
    public static String currentTimeToString(){
        return stampToDateStr(new Date());
    }

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDateStr(Date date){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate,Date bdate)
    {
        long between_days=0;
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            smdate=sdf.parse(sdf.format(smdate));
            System.out.println("smdate"+smdate);
            bdate=sdf.parse(sdf.format(bdate));
            System.out.println("bdate"+bdate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            between_days=(time2-time1)/(1000*3600*24);
        }catch (Exception e){

        }
        return Integer.parseInt(String.valueOf(between_days));
    }
}

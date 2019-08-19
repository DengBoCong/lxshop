package com.dbc.lxshop.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: lxshop
 * @description: 时间工具类
 * @author: DBC
 * @create: 2019-08-17 09:29
 **/
public class DateUtil {
    private static final long ONE_WEEK_MILLS = 604800000L;
    private static final long ONE_DAY_MILLS = 86400000L;
    private static final long ONE_MONTH_MILLS = 2592000000L;
    private static final long ONE_YEAR_MILLS = 31536000000L;

    /**
    * @Description: 返回当前时间的int型数据
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/17
    */
    public static int NewDateInt(){
        long nowTime = System.currentTimeMillis()/1000;
        return new Long(nowTime).intValue();
    }

    /**
    * @Description: 将int时间戳转换为Date
    * @Param:
    * @return:
    * @Author: DBC
    * @Date: 2019/8/17
    */
    public static Date IntToDate(int nowTimeInt){
        Date nowTimeDate = null;
        try{
            long nowTimeLong = new Long(nowTimeInt).longValue()*1000;
            DateFormat ymdhmsFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTimeStr = ymdhmsFormat.format(nowTimeLong);
            nowTimeDate = ymdhmsFormat.parse(nowTimeStr);
        }catch (ParseException e){
            e.printStackTrace();
            System.out.println("时间转换出现问题！");
        }
        return nowTimeDate;
    }

    /**
    * @Description: 返回当前时间前一周的系统时间戳
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/17
    */
    public static int LastWeekTime(){
        long nowTimeMills = (System.currentTimeMillis() - ONE_WEEK_MILLS)/1000;
        return new Long(nowTimeMills).intValue();
    }

    /**
    * @Description: 返回前一天时间戳
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    public static int LastDayTime(){
        long nowTimeMills = (System.currentTimeMillis() - ONE_DAY_MILLS)/1000;
        return new Long(nowTimeMills).intValue();

    }

    /**
    * @Description: 返回前两周的时间戳
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    public static int LastTwoWeekTime(){
        long nowTimeMills = (System.currentTimeMillis() - 2 * ONE_WEEK_MILLS)/1000;
        return new Long(nowTimeMills).intValue();
    }

    /**
    * @Description: 返回前一个月的时间戳
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    public static int LastMonthTime(){
        long nowTimeMills = (System.currentTimeMillis() - ONE_MONTH_MILLS)/1000;
        return new Long(nowTimeMills).intValue();
    }

    /**
    * @Description: 返回前一年的时间戳
    * @Param:
    * @return:  int
    * @Author: DBC
    * @Date: 2019/8/19
    */
    public static int LastYearTime(){
        long nowTimeMills = (System.currentTimeMillis() - ONE_YEAR_MILLS)/1000;
        return new Long(nowTimeMills).intValue();
    }
}

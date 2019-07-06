package com.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author buer
 * @create 2019/4/28 19:39
 * @description 时间描述
 */
public class DateTest {
    private static final int a = 1;
    @Test
    public void dateTest(){
        //mm与MM区别 mm表示分钟（minutes） MM表示（months）
//        SimpleDateFormat  sdf = new SimpleDateFormat("yy/MM/dd");
//        String format  = sdf.format(new Date());
//        System.out.println(format);
        System.out.println(new Date());
        System.out.println(a);
//        LocalDateTime
//                Date()

        System.out.println(LocalDate.now());
    }

    @Test
    public void test(){
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00").getClass().getSimpleName());
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN));
        System.out.println(LocalDateTime.of(LocalDate.now(), LocalTime.MIN).getClass().getSimpleName());

//        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        System.out.println(zero);

    }
}

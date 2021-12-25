package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalculateService {

    public double countHalfHours(String beginTime,String endTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm");
        Date checkInTime = simpleDateFormat.parse(beginTime);
        Date checkOutTime = simpleDateFormat.parse(endTime);
        return ((checkOutTime.getTime()-checkInTime.getTime())/(1000*60))/30;
    }

    public double salaryCaculate(double totalHalfHours,double halfHourPay){

        double totalSalrary = 0;
        double level2HalfHours;
        double level3HalfHours;
        if (totalHalfHours <= 16){
            totalSalrary = halfHourPay * totalHalfHours;
        }else if(totalHalfHours > 16 && totalHalfHours <= 20){
            level2HalfHours = totalHalfHours - 16;
            totalSalrary = 16 * halfHourPay + ((level2HalfHours * halfHourPay)*1.33);
        }else if(totalHalfHours > 20){
            level3HalfHours = totalHalfHours - 20;
            totalSalrary = 16 * halfHourPay +
                    ((4 * halfHourPay)*1.33) +
                    ((level3HalfHours * halfHourPay)*1.66);
        }
        return totalSalrary;
    }

}

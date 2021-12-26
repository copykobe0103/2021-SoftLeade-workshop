package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        double totalSalrary = 0;
        double totalSalrary2 = 0;
        double halfHourPay = 50;
        double totalHalfHours = 0;
        double totalHalfHours2 = 0;
        String checkInStartTime = null;

        List<String> checkInRecord = new ArrayList<>();
        checkInRecord.add("2021-12-01 08:00");
        checkInRecord.add("2021-12-01 17:00");
        checkInRecord.add("2021-12-02 08:00");
        checkInRecord.add("2021-12-02 17:00");

        CalculateService calculateService = new CalculateService();

        for (int i = 0; i < checkInRecord.size(); i++) {
            if (i % 2 == 1) {
                totalHalfHours = calculateService.countHalfHours(checkInStartTime, checkInRecord.get(i));
                totalSalrary = totalSalrary + calculateService.salaryCaculate(totalHalfHours, halfHourPay);
            } else {
                checkInStartTime = checkInRecord.get(i);
            }
        }
        System.out.println("totalSalraryType1 = " + totalSalrary);
        System.out.println("lastHalfHoursType1 = " + totalHalfHours);


        List<String> checkInRecord2 = new ArrayList<>();
        checkInRecord2.add("2021-12-01 08:00 16:00");
        checkInRecord2.add("2021-12-01 08:00 20:10");

        for (int i = 0;i < checkInRecord2.size();i++) {
            totalHalfHours2 = calculateService.countHalfHours2((checkInRecord2.get(i)).substring(11, 16),
                    (checkInRecord2.get(i)).substring(17, 22));
            totalSalrary2 = totalSalrary2 + calculateService.salaryCaculate(totalHalfHours2, 50);
        }
        System.out.println("totalSalraryType2 = " + totalSalrary2);
        System.out.println("lastHalfHoursType2 = " + totalHalfHours2);

        System.out.println("-------------------------------------------------");
        RightLeft demo = new RightLeft();

        demo.setUp();

        demo.Test();

    }

}
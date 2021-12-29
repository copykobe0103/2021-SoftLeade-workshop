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
        double totalHalfHoursMonth11 = 0;
        double totalHalfHoursMonth12 = 0;
        double totalSalraryMonth11 = 0;
        double totalSalraryMonth12 = 0;

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

        System.out.println("--------------------------------------------------");
        List<String> checkInRecordByMonth = new ArrayList<>();
        checkInRecordByMonth.add("2021-11-01 08:00 16:00");
        checkInRecordByMonth.add("2021-11-02 08:00 16:00");
        checkInRecordByMonth.add("2021-12-01 08:00 18:00");
//        System.out.println(checkInRecordByMonth.get(0).substring(5,7));
        for (int i = 0;i < checkInRecordByMonth.size();i++){
            switch (checkInRecordByMonth.get(i).substring(5,7)) {
                case "11":
                    totalHalfHoursMonth11 = calculateService.countHalfHours2
                            ((checkInRecordByMonth.get(i)).substring(11, 16),
                            (checkInRecordByMonth.get(i)).substring(17, 22));
                    totalSalraryMonth11 = totalSalraryMonth11 +
                            calculateService.salaryCaculate(totalHalfHoursMonth11, 50);
                    break;
                case "12":
                    totalHalfHoursMonth12 = calculateService.countHalfHours2
                            ((checkInRecordByMonth.get(i)).substring(11, 16),
                                    (checkInRecordByMonth.get(i)).substring(17, 22));
                    totalSalraryMonth12 = totalSalraryMonth12 +
                            calculateService.salaryCaculate(totalHalfHoursMonth12, 50);
                    break;
                default:
                    System.out.println("else");

                }
            }
        System.out.println("totalSalraryMonth11 = " + totalSalraryMonth11);
        System.out.println("totalSalraryMonth12 = " + totalSalraryMonth12);

        }


    }


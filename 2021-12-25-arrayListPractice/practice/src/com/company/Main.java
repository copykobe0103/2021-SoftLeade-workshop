package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        double totalSalrary = 0;
        double halfHourPay = 50;
        double totalHalfHours = 0;
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
        System.out.println("totalSalrary = " + totalSalrary);
        System.out.println("totalHalfHours = " + totalHalfHours);
        }
    }


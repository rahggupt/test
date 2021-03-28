package com.vdx.statistics;

import java.util.Scanner;

public class VdxMain {
    public static void main(String[] args) {
        StatisticsHandler handler = new StatisticsHandler();

//        Scanner scan = new Scanner(System.in);
//
//        boolean quit = false;
//        do {
//            System.out.println("1: Input Data : ");
//            System.out.println("2: Find Mean : ");
//            System.out.println("3: Find MeanlastNMinutes : ");
//            System.out.println("4: Find Variance : ");
//            System.out.println("5: Find Minimum : ");
//            System.out.println("6: Find Maximum : ");
//            System.out.println("7: Stop : ");
//
//            Integer option = scan.nextInt();
//            switch (Integer.valueOf(option)) {
//                case 1:
//                    int value = scan.nextInt();
//                    handler.event(value);
//                    break;
//                case 2:
//                    System.out.println(handler.mean());
//                    break;
//                case 3:
//                    int lastNMin = scan.nextInt();
//                    System.out.println(handler.mean(lastNMin));
//                    break;
//                case 4:
//                    System.out.println(handler.variance());
//                    break;
//                case 5:
//                    System.out.println(handler.minimum());
//                    break;
//                case 6:
//                    System.out.println(handler.maximum());
//                    break;
//                case 7:
//                    quit = true;
//                    break;
//                default:
//                    System.out.println("Invalid Option");
//                    break;
//            }
//        }
//        while (!quit);

        testOne();

    }


    public static void testOne(){
        StatisticsHandler handler = new StatisticsHandler();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.event(1);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.event(2);
            }
        });
        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                handler.event(10);
            }
        });
        t3.start();
        System.out.println(handler.mean());

    }

}

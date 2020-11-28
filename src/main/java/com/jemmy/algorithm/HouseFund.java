package com.jemmy.algorithm;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 住房公积金算法
 *
 * @author zhujiang.cheng
 * @since 2020/4/4
 */
public class HouseFund {

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入每月新增金额");
        String incr = scanner.nextLine();

        int month = 0;
        ArrayDeque<BigDecimal> arrayDeque = new ArrayDeque<>();
        BigDecimal bdSum = new BigDecimal(0);
        BigDecimal bdCur = new BigDecimal(0);
        BigDecimal bdIncr = new BigDecimal(incr);
        BigDecimal bdTarget = new BigDecimal(400000);
        while (bdSum.compareTo(bdTarget) < 0) {
            bdCur = bdCur.add(bdIncr);
            if (arrayDeque.size() >= 12) {
                BigDecimal bdRemove = arrayDeque.removeFirst();
                bdSum = bdSum.subtract(bdRemove);
            }
            bdSum = bdSum.add(bdCur);
            arrayDeque.addLast(bdCur);
            month++;
        }

        System.out.printf("第%s个月，余额为%s元，能贷50万元", month, bdCur);
        System.out.println();
        System.out.println("近12个月余额为：");
        for (BigDecimal bdElement : arrayDeque) {
            System.out.print(bdElement.toString() + '\t');
        }
    }

    /**
     * 近12个月: 41,255.11 36,618.69 32,733.01 28,545.52 24,385.51 20,252.95 16,147.87 12,070.24 8,020.09 6,229.00 6,229.00 6,229.00
     * 16,147.87 12,070.24 8,020.09 6,229.00 6,229.00 6,229.00 12,457.00 18,685.00 25,123.40 32,163.40 39,203.40 46,243.40
     * 10081.82 11761.82 13441.82 15121.82 16801.82 18481.82 20161.82 21841.82 23710.5 25390.5 27070.5 28750.5
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入近12个月余额");
        String balances = scanner.nextLine();
        System.out.println("请输入每月新增金额");
        String incr = scanner.nextLine();

        String[] array = balances.split(" ");
        ArrayDeque<BigDecimal> arrayDeque = new ArrayDeque<>();
        BigDecimal bdSum = new BigDecimal(0);
        BigDecimal bdCur = new BigDecimal(array[11].replace(",", ""));
        BigDecimal bdIncr = new BigDecimal(incr);

        // 最近12个月末余额总和 / 12 * 15 = 500000，得出余额总和目标为 400000
        BigDecimal bdTarget = new BigDecimal(400000);
        for (String balance : array) {
            BigDecimal prevBalance = new BigDecimal(balance.replace(",", ""));
            bdSum = bdSum.add(prevBalance);
            arrayDeque.addLast(prevBalance);
        }

        int month = 0;
        while (bdSum.compareTo(bdTarget) < 0) {
            bdCur = bdCur.add(bdIncr);
            if (arrayDeque.size() >= 12) {
                BigDecimal bdRemove = arrayDeque.removeFirst();
                bdSum = bdSum.subtract(bdRemove);
            }
            bdSum = bdSum.add(bdCur);
            arrayDeque.addLast(bdCur);
            month++;
        }

        System.out.printf("第%s个月，余额为%s元，能贷50万元", month, bdCur);
        System.out.println();
        System.out.println("近12个月余额为：");
        for (BigDecimal bdElement : arrayDeque) {
            System.out.print(bdElement.toString() + '\t');
        }
    }
}

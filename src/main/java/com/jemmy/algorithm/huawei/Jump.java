package com.jemmy.algorithm.huawei;

import java.util.Scanner;

/**
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 示例1
 * 输入
 * 1
 * 输出
 * 2.875
 * 0.03125
 *
 * 注意第几次落地和第几次反弹不同
 *
 * @author zhujiang.cheng
 * @since 2020/2/22
 */
public class Jump {

    /**
     * 统计出第5次落地时，共经过多少米?
     *
     * @param high 球的起始高度
     * @return 英文字母的个数
     */
    public static double getJourney(int high)
    {
        return 0;
    }

    /**
     * 统计出第5次反弹多高?
     *
     * @param high 球的起始高度
     * @return 空格的个数
     */
    public static double getTenthHigh(int high)
    {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("输入小球下落的高度：");
        Scanner scanner = new Scanner(System.in);
        double h = scanner.nextDouble();
        System.out.println("输入落地的次数：");
        double n = scanner.nextDouble();
        System.out.println("输入反弹的次数：");
        double m = scanner.nextDouble();

        double high = h;
        double journey = high;
        for (int i = 2; i <= n; i++) {
            high /= 2;
            journey += high * 2;
        }

        double high2 = h;
        for (int j = 1; j <= m; j++) {
            high2 /= 2;
        }

        System.out.println("共经过" + journey + "米");
        System.out.println("第" + m + "次反弹" + high2 + "米");
    }

}

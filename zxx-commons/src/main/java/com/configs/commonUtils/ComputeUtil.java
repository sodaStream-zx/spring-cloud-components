package com.configs.commonUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author TJ2020-6
 * @desc
 * @createTime 2020-04-22-14:42
 */
public class ComputeUtil {

    public static void main(String[] args) {
        BigDecimal compute = ComputeUtil.compute(1, 3);
        BigDecimal compute1 = ComputeUtil.compute("1", "3");
        BigDecimal compute2 = ComputeUtil.compute(1L, 3L);
        BigDecimal compute3 = ComputeUtil.compute(new BigDecimal(1), new BigDecimal(3));
        System.out.println(compute);
        System.out.println(compute1);
        System.out.println(compute2);
        System.out.println(compute3);
        System.out.println("-------------------------");
        BigDecimal computeRatio = ComputeUtil.computeRatio(1, 3);
        BigDecimal computeRatio1 = ComputeUtil.computeRatio(new BigDecimal(1), new BigDecimal(3));
        BigDecimal computeRatio2 = ComputeUtil.computeRatio("1", "3");
        System.out.println(computeRatio);
        System.out.println(computeRatio1);
        System.out.println(computeRatio2);
    }

    //计算比值
    public static BigDecimal compute(String x, String y) {
        BigDecimal bigX = new BigDecimal(x);
        BigDecimal bigY = new BigDecimal(y);
        if (bigY.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal(0);
        }
        return bigX.subtract(bigY).divide(bigY, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }

    //计算比值
    public static BigDecimal compute(BigDecimal x, BigDecimal y) {
        if (y.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal(0);
        }
        return x.subtract(y).divide(y, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }

    //计算比值
    public static BigDecimal compute(long x, long y) {
        BigDecimal bigX = new BigDecimal(x);
        BigDecimal bigY = new BigDecimal(y);
        if (bigY.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal(0);
        }
        return bigX.subtract(bigY).divide(bigY, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }

    //直接计算比值
    public static BigDecimal computeRatio(long x, long y) {
        BigDecimal bigX = new BigDecimal(x);
        BigDecimal bigY = new BigDecimal(y);
        if (bigY.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal(0);
        }
        return bigX.divide(bigY, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }

    //直接计算比值
    public static BigDecimal computeRatio(String x, String y) {
        BigDecimal bigX = new BigDecimal(x);
        BigDecimal bigY = new BigDecimal(y);
        if (bigY.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal(0);
        }
        return bigX.divide(bigY, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }

    //直接计算比值
    public static BigDecimal computeRatio(BigDecimal x, BigDecimal y) {
        if (y.compareTo(new BigDecimal(0)) == 0) {
            return new BigDecimal(0);
        }
        return x.divide(y, 2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
    }
}

package xyz.eden.learn.algorithm.ds.hugedata;

import java.math.BigInteger;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/11 18:35
 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        BigInteger X = (new BigInteger("-80538738812075974"));
        BigInteger Y = (new BigInteger("80435758145817515"));
        BigInteger Z = (new BigInteger("12602123297335631"));
        System.out.println(X.add(Y).add(Z));

    }
}

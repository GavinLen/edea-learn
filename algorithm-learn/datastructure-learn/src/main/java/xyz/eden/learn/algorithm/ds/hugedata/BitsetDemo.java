package xyz.eden.learn.algorithm.ds.hugedata;


import java.util.BitSet;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/14 17:55
 */
public class BitsetDemo {
    public static void main(String[] args) {
        int dataLen = 2000000000;

        long beforeMemory  = Runtime.getRuntime().totalMemory();

        // 初始化数据
        Solution solution = new BitsetDemo().new Solution(dataLen);
        for (int i = 0; i < dataLen; i++) {
            if (i != 898989) {
                solution.add(i);
            }
        }

        // 初始化完成
        System.out.println("添加数据占的内存:" + ((Runtime.getRuntime().totalMemory() - beforeMemory) >> 20) + "MB");

        // 判断是否包含
        long beginDatetime = System.currentTimeMillis();
        System.out.println("验证 [898989] Result:" + solution.contain(898989) + ", 耗时:" + (System.currentTimeMillis() - beginDatetime));
        System.out.println("验证 [900000] Result:" + solution.contain(900000) + ", 耗时:" + (System.currentTimeMillis() - beginDatetime));

    }

    class Solution {
        private BitSet bitSet;

        public Solution(int dataLen) {
            this.bitSet = new BitSet(dataLen);
        }

        public Solution add(int data) {
            this.bitSet.set(data, Boolean.TRUE);
            return this;
        }

        public boolean contain(int data) {
            return this.bitSet.get(data);
        }
    }
}

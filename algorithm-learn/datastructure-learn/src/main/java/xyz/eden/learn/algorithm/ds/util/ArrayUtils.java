package xyz.eden.learn.algorithm.ds.util;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/10 20:26
 */
public class ArrayUtils {

    /**
     * 添加元素
     *
     * @param arr
     * @param x
     * @param y
     * @param elementVal
     * @return
     */
    public static int[][] addElement(int[][] arr, int x, int y, int elementVal) {
        arr[x][y] = elementVal;
        return arr;
    }

    /**
     * 初始化数组
     *
     * @param rowLen
     * @param colLen
     * @return
     */
    public static int[][] initArray(int rowLen, int colLen) {
        return new int[rowLen][colLen];
    }
}

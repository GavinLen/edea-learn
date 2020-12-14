package xyz.eden.learn.algorithm.ds.array;


import xyz.eden.learn.algorithm.ds.util.ArrayUtils;

/**
 * 通过二维数组实现稀疏数组
 * 简介:
 * 当一个数组中大部分元素为相同值, 可以通过稀疏数组保存该数组.
 * 处理方式:
 * 1. 采用 (n +1) * 3 的三维数组来记录内容
 * 2. 数组信息
 * A[0][0] -- 记录原数组行数;
 * A[0][1] -- 记录原数组列数;
 * A[0][2] -- 记录原数组的其他值的个数
 * 3. 元素信息
 * A[i][0] -- 记录原数组中第 i-1 个其他值的元素行坐标;
 * A[i][1] -- 记录原数组中第 i-1 个其他值的元素列坐标;
 * A[i][2] -- 记录原数组中第 i-1 个其他值的元组值;
 * 4. 应用
 * 通过稀疏数组可以实现其他、地图等二维数组
 *
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/10 9:57
 */
public class SparseArrayByArray {

    public static void main(String[] args) {

        Solution solution = new SparseArrayByArray().new Solution();

        // 初始化数组
        int[][] intArr = ArrayUtils.initArray(6, 6);
        ArrayUtils.addElement(intArr, 0, 2, 1);
        ArrayUtils.addElement(intArr, 1, 1, 2);
        ArrayUtils.addElement(intArr, 4, 1, 3);

        System.out.println("原数组:");
        solution.showArrInfo(intArr);

        // 转换稀疏数组
        int[][] sparseArr = solution.arrayToSparseArray(intArr);
        System.out.println("稀疏数组:");
        solution.showArrInfo(sparseArr);

        // 还原数组
        int[][] newArr = solution.sparseArrayToArray(sparseArr);
        System.out.println("还原之后的数组:");
        solution.showArrInfo(newArr);

    }


    class Solution {

/**
 * 稀疏数组转数组
 *
 * @param sparArr
 * @return
 */
public int[][] sparseArrayToArray(int[][] sparArr) {

    int rowLen = sparArr[0][0];
    int colLen = sparArr[0][1];
    int eNum = sparArr[0][2];

    int[][] newArr = new int[rowLen][colLen];
    for (int i = 1; i <= eNum; i++) {
        newArr[sparArr[i][0]][sparArr[i][1]] = sparArr[i][2];
    }

    return newArr;
}


        /**
         * 数组转稀疏数组
         *
         * @param arr
         * @return
         */
        public int[][] arrayToSparseArray(int[][] arr) {
            int rowLen = arr.length;
            int colLen = arr[0].length;

            int eSum = 0;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    int e = arr[i][j];
                    if (e != 0) {
                        eSum += 1;
                    }
                }
            }

            int[][] sparseArr = new int[eSum + 1][3];
            sparseArr[0][0] = rowLen;
            sparseArr[0][1] = colLen;
            sparseArr[0][2] = eSum;

            int eIndex = 1;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    int e = arr[i][j];
                    if (e != 0) {
                        sparseArr[eIndex][0] = i;
                        sparseArr[eIndex][1] = j;
                        sparseArr[eIndex][2] = e;

                        eIndex += 1;
                    }
                }
            }

            return sparseArr;
        }

        /**
         * 显示数组
         *
         * @param arr
         */
        public void showArrInfo(int[][] arr) {
            int rowNumber = arr.length;
            int colNumber = arr[0].length;
            for (int i = 0; i < rowNumber; i++) {
                for (int j = 0; j < colNumber; j++) {
                    System.out.printf("%d\t", arr[i][j]);
                }
                System.out.println();
            }
        }
    }

}

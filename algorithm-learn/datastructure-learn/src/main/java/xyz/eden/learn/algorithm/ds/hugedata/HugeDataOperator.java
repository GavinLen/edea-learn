package xyz.eden.learn.algorithm.ds.hugedata;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/11 18:03
 */
public class HugeDataOperator {


    @Data
    public static class HugeData {
        private int[] numberArr;

        /**
         * 转换数据
         *
         * @param numberArr
         * @return
         */
        public String convertHugeData(int[] numberArr) {
            if (numberArr == null) {
                return StringUtils.EMPTY;
            }
            return numberArr.toString();
        }

        /**
         * 初始化数据
         *
         * @param numberStr
         * @return
         */
        public int[] initHugeData(String numberStr) {
            if (numberStr == null) {
                return new int[0];
            }
            return null;
        }

    }


}

package xyz.eden.learn.tool.pcg;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/21 14:25
 */
public class TestNumber {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{11, 22, 33, 44, 55, 66};
        System.out.println(StringUtils.join(arr, "---"));
    }
}

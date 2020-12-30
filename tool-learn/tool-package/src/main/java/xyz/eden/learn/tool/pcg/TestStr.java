package xyz.eden.learn.tool.pcg;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/21 14:26
 */
public class TestStr {
    public static void main(String[] args) {
        String[] arr = new String[]{"aaa", "bbb", "ccc", "DDD", "EEE", "FFF"};
        System.out.println(StringUtils.join(arr, "---"));
    }
}

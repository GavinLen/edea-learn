package xyz.eden.learn.tool.json.fastjson;

import com.alibaba.fastjson.JSONObject;
import xyz.eden.learn.tool.json.common.UserInfo;

import java.util.Date;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/24 17:51
 */
public class FastjsonDemo {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo(1L, "tom", new Date(), System.currentTimeMillis());
        String beanJsonStr = JSONObject.toJSONString(userInfo);
        System.out.println(beanJsonStr);

        System.out.println("aaa");


    }
}

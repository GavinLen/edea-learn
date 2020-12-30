package xyz.eden.learn.tool.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.eden.learn.tool.json.common.UserInfo;
import xyz.eden.learn.tool.json.common.UserInfoA;

import java.util.Date;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/24 15:12
 */
public class JacksonTest {

    public static void main(String[] args) throws JsonProcessingException {
        UserInfo userInfo = new UserInfo(1L, "tom", new Date(), System.currentTimeMillis());


        String beanJsonStr = JsonUtils.toJSONString(userInfo);
        System.out.println(beanJsonStr);

        System.out.println("aaa");


////        UserInfoA newUserInfo = mapper.readValue(beanJsonStr, UserInfoA.class);
//        long datetime = userInfo.getDatetime();
//        Date date = new Date(datetime);
//        System.out.println(date);
//        String s = newUserInfo.toString();
//        System.out.println(s);
    }
}

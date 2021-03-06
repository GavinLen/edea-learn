package xyz.eden.learn.tool.json.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lianghongwei01
 * @version 1.0.0
 * @date 2020/12/14 11:45
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {

    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss", timezone = "")
//    @JSONField(format = "yyyy年MM月dd日 HH:mm:ss")
    private Date createDatetime;
    private long datetime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

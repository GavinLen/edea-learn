package xyz.eden.learn.tool.json.common;

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
public class UserInfoA implements Serializable {

    private Long id;
    private String name;
    private String createDatetime;
    private String datetime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

package xyz.eden.learn.tool.json.common;

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
    private Date createDatetime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

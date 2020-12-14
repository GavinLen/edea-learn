package xyz.eden.learn.databases.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * UserEntity
 *
 * @author gavin
 * @version 1.0
 * @datetime 2020/12/12 19:39
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    private Long id;
    private String name;
    private String email;
    private Date createDatetime;

    public UserEntity(String name, String email, Date createDatetime) {
        this.name = name;
        this.email = email;
        this.createDatetime = createDatetime;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}

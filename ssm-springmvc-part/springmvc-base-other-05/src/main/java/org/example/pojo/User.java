package org.example.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;


/**
 * name 不为空 和 空字符串
 * 字符串用 @NotBlank
 * 集合用 @NotEmpty
 * 包装 @NotNull
 * password 长度 > 6
 * age 必须 >= 1
 * email 是邮箱格式字符串
 * birthday 一定是过去时间
 */
@Data
public class User {

    @NotBlank
    private String name;

    @Length(min = 6)
    private String password;

    @Min(1)
    private int age;

    @Email
    private String email;

    @Past
    private Date birthday;


}

package org.example.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读取配置的方式1. @Value
 * @Value必须写全了
 * @Value只能读取单个值
 * 2. 批量配置读取
 *  @ConfigurationProperties(prefix = "zwf.user") 通用的前缀
 *  实体类
 *    属性名 = 最后一个key的值
 *    优势1. 方便，不用一个一个填
 *    优势2. 可以给集合赋值
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "zwf.user")
public class User {


    //@Value("${zwf.user.username}")
    private String username;

    //@Value("${zwf.user.password}")
    private String password;

    //@Value("${zwf.user.gfs}")
    private List<String> gfs;
}

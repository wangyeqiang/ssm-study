package org.example.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("user")  // 可以不加，使用实体类中的名字作为表名，忽略大小写
                    // BaseMapper -》 User实体列 -》 实体类的名 -》 表名数据库
                    // 当数据库的表名和实体类命名不同（忽略大小写），使用@TableName命名
public class User {
    /**
     * 默认： 雪花算法 1. 数据库主键 bigint /varchar(64)
     *              2. 实体类Long类型
     *              3. 随机生成一个数字，给与主键值(不重复)
     *        auto 1. 要求mysql数据库创建表主键的时候 类型数字 并且auto_increment
     *             2. 插入数据库就是自增长
     */
    @TableId(value = "id")  // 默认使用雪花类型，如果mysql有自增长 则使用自增长
    private Long id;
    @TableField(value = "name", exist = true) // exist代表是不是属于数据库的一个列
    private String name;
    private Integer age;
    private String email;

    @TableLogic
    //逻辑删除字段 int mybatis-plus下,默认 逻辑删除值为1 未逻辑删除 1
    // 当删除数据的时候 会自动变成修改此列的属性值 默认0 未删除 1 删除
    // 当查询数据的时候，默认只查询 deleted = 0
    private Integer deleted;


    @Version // 设置为版本号字段
    private Integer version;

}

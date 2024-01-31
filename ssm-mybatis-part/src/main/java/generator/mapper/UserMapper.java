package generator.mapper;

import generator.org.example.pojo.User;

/**
* @author WYQ
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-01-31 17:57:58
* @Entity generator.org.example.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}

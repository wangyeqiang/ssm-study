package generator.mapper;

import generator.org.example.pojo.TOrder;

/**
* @author WYQ
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2024-01-31 17:57:58
* @Entity generator.org.example.pojo.TOrder
*/
public interface TOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

}

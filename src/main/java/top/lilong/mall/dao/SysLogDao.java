package top.lilong.mall.dao;


import org.apache.ibatis.annotations.Mapper;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Mapper
public interface SysLogDao {

    Integer insert(String content);

}

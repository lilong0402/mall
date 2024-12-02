package top.lilong.mall.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Mapper
public interface SysLogMapper {

    Integer insert(@Param("username") String username, @Param("content") String content, @Param("behavior") String behavior);

}

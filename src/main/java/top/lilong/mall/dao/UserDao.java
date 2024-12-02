package top.lilong.mall.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.lilong.mall.domain.User;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Select("select * from user_information where user_name=#{username} and user_password = #{newPassword}")
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("newPassword") String newPassword);
}

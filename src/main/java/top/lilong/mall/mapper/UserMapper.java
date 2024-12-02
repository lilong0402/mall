package top.lilong.mall.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.lilong.mall.domain.User;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user_information where user_name=#{username} and user_password = #{newPassword}")
    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("newPassword") String newPassword);

    @Update("update user_information set user_password = #{userPassword} where user_name = #{userName} ")
    Integer updatePassword(@Param("userName") String userName,@Param("userPassword") String userPassword);
}


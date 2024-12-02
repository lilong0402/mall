package top.lilong.mall.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Mapper
public interface PasswordAndSaltMapper {

    @Select("select salt from password_salt where user_name = #{username}")
    String selectSaltByUsername(String username);
    @Update("update password_salt set salt = #{salt} where user_name = #{userName} ")
    Integer updateSalt(@Param("salt") String salt, @Param("userName") String username);
}

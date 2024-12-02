package top.lilong.mall.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.lilong.mall.domain.PasswordAndSalt;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Mapper
public interface PasswordAndSaltDao {

    @Select("select salt from password_salt where user_name = #{username}")
    String selectSaltByUsername(String username);
    @Update("update password_salt set salt = #{salt} where user_name = #{userName} ")
    Integer updateSalt(@Param("salt") String salt, @Param("userName") String username);
}

package top.lilong.mall.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_information")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String account;
    private String QQ;
    private String wechat;
    private String useName;
    private String userPassword;
    private String userAvatar;
    private int sex;
    private Date userBirth;
    private Date createTime;
    private Date deleteTime;
    private Date updateTime;


}

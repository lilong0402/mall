package top.lilong.mall.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Timestamp;
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
    private String userName;
    private String userPassword;
    private String userAvatar;
    private int sex;
    private Timestamp userBirth;
    private Timestamp createTime;
    private Timestamp deleteTime;
    private Timestamp updateTime;


}

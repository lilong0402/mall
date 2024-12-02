package top.lilong.mall.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Data
@Builder
@TableName("password_salt")
public class PasswordAndSalt {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long adminId;
    private Long userId;
    private String userName;
    private String adminName;
    private String salt;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp deleteTime;
}

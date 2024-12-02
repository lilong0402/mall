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
@TableName("sys_log")
public class SysLog {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String content;
<<<<<<< HEAD
    private String behavior;
    private Timestamp createTime;
=======
    private Timestamp createTime;
    private Timestamp deleteTime;
>>>>>>> 4b3243338c10c184184f16128b1630d23b0436e4
}

package top.lilong.mall.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

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
    private Integer logState;
    private String content;
    private Date createTime;
    private Date deleteTime;
}

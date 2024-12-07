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
 * * @date 2024/12/7
 * @version 1.0
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@TableName("user_address")
public class userAddress {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userAddress;
    private String phone;
    private Integer isState;
    private String userLabel;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}

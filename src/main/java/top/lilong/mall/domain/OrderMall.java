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
 * * @date 2024/12/4
 * @version 1.0
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@TableName("`mall_order`")
public class OrderMall {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer orderState;
    private String orderAccount;
    private Long shoppingId;
    private Long userId;
    private Double orderPrice;
    private Integer payStyle;
    private String  commodityLogistics;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}

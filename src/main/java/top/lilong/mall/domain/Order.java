package top.lilong.mall.domain;


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
public class Order {
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

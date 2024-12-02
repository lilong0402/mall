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

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("shopping_information")
public class ShoppingInformation {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long storeId;
    private String shoppingCategory;
    private String shoppingName;
    private String shoppingNote;
    private Integer shoppingState;
    private Long shoppingClick;
    private Double shoppingPrice;
    private Timestamp createTime;
    private Timestamp deleteTime;
}

package top.lilong.mall.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lilong
 * * @date 2024/12/7
 * @version 1.0
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PayMentVO {
    private Long userId;
    private Long shoppingId;
    private Integer payStyle;
    private Integer commodityNum;
    private String commodityName;
}

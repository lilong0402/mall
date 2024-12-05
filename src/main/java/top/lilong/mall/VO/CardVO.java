package top.lilong.mall.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lilong
 * * @date 2024/12/5
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardVO {
    private Long userId;
    private Long shoppingId;
}

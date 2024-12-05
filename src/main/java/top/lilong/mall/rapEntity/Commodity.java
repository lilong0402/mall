package top.lilong.mall.rapEntity;


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
public class Commodity {
    private Long storeId;
    private String shoppingCategory;
    private String shoppingName;
    private String shoppingNote;
    private Integer shoppingState;
    private Integer shoppingNumber;
    private Long shoppingClicking;
    private Double shoppingPrice;
}

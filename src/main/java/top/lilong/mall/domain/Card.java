package top.lilong.mall.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Lilong
 * * @date 2024/12/5
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private Long id;
    private Long userId;
    private Long shoppingId;
    private Date createTime;
    private Date deleteTime;

}

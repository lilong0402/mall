package top.lilong.mall.VO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lilong
 * * @date 2024/12/3
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageVO {
    private  int currentPage;

    private  int pageSize;
}

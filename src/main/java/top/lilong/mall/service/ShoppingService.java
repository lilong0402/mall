package top.lilong.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.lilong.mall.domain.ShoppingInformation;

import java.util.List;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
public interface ShoppingService extends IService<ShoppingInformation> {

    List<ShoppingInformation> getShoppingInformation(int currentPage, int pageSize);

    Integer addShoppingCard(Long userId,Long shoppingId);
}

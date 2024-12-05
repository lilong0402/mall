package top.lilong.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lilong.mall.VO.CardVO;
import top.lilong.mall.VO.PageVO;
import top.lilong.mall.domain.Card;
import top.lilong.mall.domain.ShoppingInformation;
import top.lilong.mall.service.ShoppingService;
import top.lilong.mall.util.ResultData;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;
    @RequestMapping("/selectAllCommodity")
    public ResultData<ShoppingInformation> getShoppingInformation(PageVO pageVO) {
        return ResultData.success(shoppingService.getShoppingInformation(pageVO.getCurrentPage(), pageVO.getPageSize()));
    }

    public ResultData<Card> addShoppingCard(CardVO cardVO){

        Integer card = shoppingService.addShoppingCard(cardVO.getUserId(), cardVO.getShoppingId());
        if (card == null) return ResultData.fail("加入失败");
        return ResultData.success("加入成功");
    }
}

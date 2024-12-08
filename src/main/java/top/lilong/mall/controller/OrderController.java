package top.lilong.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lilong.mall.VO.PaymentVO;
import top.lilong.mall.domain.Order;
import top.lilong.mall.service.OrderService;
import top.lilong.mall.util.ResultData;

/**
 * @author Lilong
 * * @date 2024/12/4
 * @version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/addOrder")
    public ResultData<Order> addOrder(PaymentVO paymentVO) {
        if (paymentVO == null) return ResultData.fail("传入参数为空");
        Integer odrerno = orderService.addOrder(paymentVO);
        return ResultData.success(odrerno);
    }

}

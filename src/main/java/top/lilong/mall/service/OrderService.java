package top.lilong.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.lilong.mall.VO.PaymentVO;
import top.lilong.mall.domain.OrderMall;

/**
 * @author Lilong
 * * @date 2024/12/4
 * @version 1.0
 */
public interface OrderService extends IService<OrderMall> {

    Integer addOrder(PaymentVO paymentVO);

}

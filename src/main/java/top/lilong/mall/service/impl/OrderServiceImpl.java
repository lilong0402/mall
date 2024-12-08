package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lilong.mall.VO.PaymentVO;
import top.lilong.mall.domain.Order;
import top.lilong.mall.domain.ShoppingInformation;
import top.lilong.mall.mapper.OrderMapper;
import top.lilong.mall.mapper.ShoppingMapper;
import top.lilong.mall.mapper.SysLogMapper;
import top.lilong.mall.mapper.UserMapper;
import top.lilong.mall.service.OrderService;

import java.util.Date;

/**
 * @author Lilong
 * * @date 2024/12/4
 * @version 1.0
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private SysLogMapper sysLogMapper;
    @Autowired
    private UserMapper userMapper;
    //用于加锁
//    private static   Integer apple=1;

    @Override
    public Integer addOrder(PaymentVO paymentVO) {
        //获取商品信息
        ShoppingInformation shopping = shoppingMapper.selectById(paymentVO.getShoppingId());
        if (shopping == null) {
            return null;
        }
        //获取优惠信息

        //获取库存信息
        Integer shoppingNumber = shopping.getShoppingNumber();
        //计算运费
        //减库存
        if (shoppingNumber >0){
            shopping.setShoppingNumber(shopping.getShoppingNumber()-1);
            sysLogMapper.insert(userMapper.selectById(paymentVO.getUserId()).getUserName(),"用去了"+shopping.getShoppingName()+"商品的一个库存","库存减一");
        }
        //生成订单
        addOrder2(paymentVO,shopping);
        return 13;
    }

    private synchronized void addOrder2(PaymentVO paymentVO,ShoppingInformation shopping) {
        orderMapper.insert(Order.builder().orderState(1211)
                .orderPrice(shopping.getShoppingPrice() * paymentVO.getDiscount())
                .orderAccount((new Date()).toString())
                .commodityLogistics(paymentVO.getLogistics())
                .payStyle(paymentVO.getPayStyle())
                .userId(paymentVO.getUserId())
                .shoppingId(paymentVO.getShoppingId())
                .commodityLogistics(paymentVO.getLogistics())
                .createTime(new Date())
                .build());
        sysLogMapper.insert(userMapper.selectById(paymentVO.getUserId()).getUserName(),"生成"+shopping.getShoppingName()+"商品订单","生成订单");
    }
}

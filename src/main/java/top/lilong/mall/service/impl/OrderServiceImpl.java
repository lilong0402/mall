package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.lilong.mall.domain.Order;
import top.lilong.mall.mapper.OrderMapper;
import top.lilong.mall.service.OrderService;

/**
 * @author Lilong
 * * @date 2024/12/4
 * @version 1.0
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}

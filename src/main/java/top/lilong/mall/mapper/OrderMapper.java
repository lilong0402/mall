package top.lilong.mall.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import top.lilong.mall.domain.OrderMall;

/**
 * @author Lilong
 * * @date 2024/12/4
 * @version 1.0
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderMall> {


    Integer insertOrder(OrderMall orderMall);
}

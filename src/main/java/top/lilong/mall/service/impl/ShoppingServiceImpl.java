package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lilong.mall.domain.Card;
import top.lilong.mall.domain.ShoppingInformation;
import top.lilong.mall.domain.User;
import top.lilong.mall.mapper.CardMapper;
import top.lilong.mall.mapper.ShoppingMapper;
import top.lilong.mall.mapper.SysLogMapper;
import top.lilong.mall.mapper.UserMapper;
import top.lilong.mall.service.ShoppingService;

import java.util.Date;
import java.util.List;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
@Service
public class ShoppingServiceImpl extends ServiceImpl<ShoppingMapper, ShoppingInformation> implements ShoppingService {

    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private SysLogMapper sysLogDao;
    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<ShoppingInformation> getShoppingInformation(int currentPage, int pageSize) {
        Page<ShoppingInformation> page = new Page(currentPage, pageSize);
        IPage<ShoppingInformation> shoppingInformationPage = shoppingMapper.selectPage(page, new QueryWrapper<ShoppingInformation>());
        return shoppingInformationPage.getRecords();
    }

    /**
     * 0 : 数据为空
     * 1 ： 商品数量不足
     * @param
     * @return
     */
    @Override
    public Integer addShoppingCard(Long userId,Long shoppingId) {

        Card card = cardMapper.selectOne(new QueryWrapper<Card>().eq("user_id", userId).eq("shopping_id", shoppingId));

        if (userId == null || shoppingId == null || card != null)  return  0 ;
        User user = userMapper.selectById(userId);
        userMapper.selectById(userId);
        if (user == null)  return  0 ;

        ShoppingInformation shoppingInformation = shoppingMapper.selectById(shoppingId);
        if (shoppingInformation ==null || user == null)  return 0;
        else if (shoppingInformation.getShoppingNumber() == 0){
            return 1;
        }
        shoppingInformation.setShoppingState(2);
        cardMapper.insert(Card.builder().userId(userId).shoppingId(shoppingId).createTime(new Date()).build());
        sysLogDao.insert("用户" + user.getUserName(), "将商品" + shoppingId + "添加进了购物车", "加入购物车");
        return 2;
    }
}

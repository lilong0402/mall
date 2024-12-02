package top.lilong.mall.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lilong.mall.domain.ShoppingInformation;
import top.lilong.mall.mapper.ShoppingMapper;
import top.lilong.mall.service.ShoppingService;

import java.sql.Wrapper;
import java.util.ArrayList;
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

    @Override
    public List<ShoppingInformation> getShoppingInformation(int currentPage, int pageSize) {
        Page<ShoppingInformation> page = new Page(currentPage, pageSize);
        IPage<ShoppingInformation> shoppingInformationPage = shoppingMapper.selectPage(page, new QueryWrapper<ShoppingInformation>());
        return shoppingInformationPage.getRecords();
    }
}

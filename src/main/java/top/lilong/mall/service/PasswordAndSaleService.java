package top.lilong.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.lilong.mall.domain.PasswordAndSalt;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
public interface PasswordAndSaleService extends IService<PasswordAndSalt> {
    String selectSaltByUsername(String username);
}

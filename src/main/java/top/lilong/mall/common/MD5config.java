package top.lilong.mall.common;


import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author Lilong
 * * @date 2024/12/2
 * @version 1.0
 */
public class MD5config {

    /**
     * MD5加密
     * @param password
     * @return
     */
    public static String md5(String salt, String password) {
        String md5 = DigestUtils.md5DigestAsHex((password+salt).getBytes());
        return md5;

    }
}

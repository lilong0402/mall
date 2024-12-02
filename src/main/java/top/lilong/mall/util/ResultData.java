package top.lilong.mall.util;


/**
 * @author Lilong
 * * @date 2024/12/1
 * @version 1.0
 */

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * 配置统一返回类型
 * @param <T>
 */
@Data
@Builder
public class ResultData<T> {

    private int code;
    private String msg;
    private T data;
    private Long timestamp;
//    private ResultData() {
//        this.timestamp = System.currentTimeMillis();
//    }

    public static <T> ResultData success(T data) {
        return  ResultData.builder().code(200).msg("success").data(data).timestamp(System.currentTimeMillis()).build();
    }
    public static <T> ResultData fail(String msg) {
        return  ResultData.builder().code(200).msg(msg).data(null).timestamp(System.currentTimeMillis()).build();
    }
}



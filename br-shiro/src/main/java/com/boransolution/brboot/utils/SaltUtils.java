package com.boransolution.brboot.utils;

import java.util.Random;

/***
 * 生成随机盐工具
 *
 * @author : xy
 *
 * @date : 2021/8/5
 **/
public class SaltUtils {
    /**
     * 生成salt静态方法
     *
     * @param n salt位数
     * @return
     */
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKMNOPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}

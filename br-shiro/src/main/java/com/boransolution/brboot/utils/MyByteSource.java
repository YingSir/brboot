package com.boransolution.brboot.utils;

import org.apache.shiro.util.SimpleByteSource;

import java.io.Serializable;

/***
 * 自定义salt实现序列化接口
 *
 * @author : xy
 *
 * @date : 2021/8/12
 **/
public class MyByteSource extends SimpleByteSource implements Serializable {
    public MyByteSource(String string) {
        super(string);
    }
}

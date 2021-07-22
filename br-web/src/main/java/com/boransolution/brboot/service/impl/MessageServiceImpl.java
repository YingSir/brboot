package com.boransolution.brboot.service.impl;

import com.boransolution.brboot.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String echo(String msg) {
        return "【ECHO】" + msg;
    }

}

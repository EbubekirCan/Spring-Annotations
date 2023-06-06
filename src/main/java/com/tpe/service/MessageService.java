package com.tpe.service;

import com.tpe.domain.Message;

public interface MessageService {
    void sendMessage(Message message);
    void saveMessage(Message message);

}

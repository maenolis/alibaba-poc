package com.baeldung;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.rocketmq.common.message.MessageConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.baeldung.dto.RocketMessageDto;

@Component
public class ScheduledMessageProducer {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    StreamBridge streamBridge;

    @Scheduled(cron = "* * * * * *")
    public void scheduledMessageProduction() {
        RocketMessageDto msg = new RocketMessageDto(System.currentTimeMillis(), UUID.randomUUID().toString());
        LOG.info("Sending: {}", msg);
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_KEYS, UUID.randomUUID().toString());
        headers.put(MessageConst.PROPERTY_ORIGIN_MESSAGE_ID, System.currentTimeMillis());
        GenericMessage<RocketMessageDto> wrappedMessage = new GenericMessage<>(msg);
        streamBridge.send("producer-out-0", wrappedMessage);
    }

}

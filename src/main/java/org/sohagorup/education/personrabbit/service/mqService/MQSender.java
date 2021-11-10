package org.sohagorup.education.personrabbit.service.mqService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class MQSender {

    @Value("${rabbitmq.mq.senQueue}")
    String sendToRabbit;
    @Autowired
    RabbitTemplate rabbitTemplate;
    ObjectMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(MQSender.class);

    public void init() {
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper = mapper.registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
    }

    public boolean sendToMQ(PersonRequestEntity personRequest) {
        logger.debug("person Sending to MQ in MQSender");
        try {
            String s = mapper.writeValueAsString(personRequest);
            Gson gson = new Gson();
            String toJson = gson.toJson(personRequest);
            mapper.writeValueAsString(personRequest);
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.getHeaders().put("content_type", "application/json");
            rabbitTemplate.send(sendToRabbit, new Message(toJson.getBytes(), messageProperties));
            return true;
        } catch (Exception e) {
            logger.error("During sending message to Mq error happen ", e);
            return false;
        }
    }
}

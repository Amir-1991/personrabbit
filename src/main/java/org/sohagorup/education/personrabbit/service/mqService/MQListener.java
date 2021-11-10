package org.sohagorup.education.personrabbit.service.mqService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagorup.education.personrabbit.service.dto.PersonDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener
public class MQListener {

    @Autowired
    RabbitTemplate rabbitTemplate;
    ObjectMapper mapper;

    private final Logger logger = LoggerFactory.getLogger(MQSender.class);


    public PersonDTO getAccepter(String nationalCode) {
        PersonDTO personDTO = new PersonDTO();
        try {
            rabbitTemplate.receive();
        }catch (Exception e){

        }
        return personDTO;
    }
}

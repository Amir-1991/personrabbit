package org.sohagorup.education.personrabbit.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagorup.education.personrabbit.service.Interface.PersonServiceInterface;
import org.sohagorup.education.personrabbit.service.dto.PersonDTO;
import org.sohagorup.education.personrabbit.service.mqService.MQListener;
import org.sohagorup.education.personrabbit.service.mqService.MQSender;
import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;
import org.sohagorup.education.personrabbit.service.response.PersonResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonServiceInterface {

    private final MQSender mqSender;
    private final MQListener mqListener;
    private final Logger logger = LoggerFactory.getLogger(MQSender.class);

    public PersonServiceImpl(MQSender mqSender,
                             MQListener mqListener) {
        this.mqSender = mqSender;
        this.mqListener = mqListener;
    }

    @Override
    public boolean sendToMQ(PersonRequestEntity personRequest) {
        boolean isDone = false;
        try{
            isDone = mqSender.sendToMQ(personRequest);
        }catch (Exception e) {
            logger.error("Operation failed because :{}",e.getMessage());
        }
        return isDone;
    }

    @Override
    public PersonResponseEntity acceptPerson(String nationalCode) {
        PersonDTO personDTO = new PersonDTO();
        try {
            personDTO = mqListener.getAccepter(nationalCode);
        }catch (Exception e) {

        }
        return null;
    }
}

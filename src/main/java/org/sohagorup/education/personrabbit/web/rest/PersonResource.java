package org.sohagorup.education.personrabbit.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagorup.education.personrabbit.service.Interface.PersonServiceInterface;
import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;
import org.sohagorup.education.personrabbit.service.response.PersonResponseEntity;
import org.sohagorup.education.personrabbit.web.rest.api.PersonDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.zalando.problem.Status;

import static org.sohagorup.education.personrabbit.config.Constant.*;

@Component
public class PersonResource implements PersonDelegate {

    private final Logger logger = LoggerFactory.getLogger(PersonResource.class);
    private final PersonServiceInterface personServiceInterface;

    public PersonResource(PersonServiceInterface personServiceInterface) {
        this.personServiceInterface = personServiceInterface;
    }

    @Override
    public ResponseEntity<PersonResponseEntity> requestToRegister(PersonRequestEntity personRequest) {
        boolean isDone;
        logger.debug("request for register person on PersonResource");
        PersonResponseEntity personResponseEntity = null;
        try {
            isDone = personServiceInterface.sendToMQ(personRequest);
            if (isDone) {
                personResponseEntity = getStatusToResponcse(DATA_WILL_SEND, Status.OK.getStatusCode(), personRequest);
            }
        } catch (Exception e) {
            logger.error("operation failed because :{}", e.getMessage());
        }
        return ResponseEntity.status(personResponseEntity.getStatusCode()).body(personResponseEntity);
    }

    private PersonResponseEntity getStatusToResponcse(String message, Integer statusCode, PersonRequestEntity personRequest) {
        PersonResponseEntity personResponse = new PersonResponseEntity();
        personResponse.setStatusMessage(message);
        personResponse.setStatusCode(statusCode);
        personResponse.setPersonResponseEntity(personRequest);
        return personResponse;
    }

    @Override
    public ResponseEntity<PersonResponseEntity> acceptToRegistrationPerson(String nationalCode) {
        logger.debug("request for register person on PersonResource");
        PersonResponseEntity personResponseEntity = null;
        try {
            personResponseEntity = personServiceInterface.acceptPerson(nationalCode);
            if (personResponseEntity.getPersonResponseEntity() != null) {
                personResponseEntity = getStatusToResponcse(DATA_WILL_SEND, Status.OK.getStatusCode(), personResponseEntity.getPersonResponseEntity());
            }
        } catch (Exception e) {
            logger.error("operation failed because :{}", e.getMessage());
        }
        return ResponseEntity.status(personResponseEntity.getStatusCode()).body(personResponseEntity);
    }

}

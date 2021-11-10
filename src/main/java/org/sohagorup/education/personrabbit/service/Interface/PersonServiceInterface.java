package org.sohagorup.education.personrabbit.service.Interface;

import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;
import org.sohagorup.education.personrabbit.service.response.PersonResponseEntity;

public interface PersonServiceInterface {
    boolean sendToMQ(PersonRequestEntity personRequest);

    PersonResponseEntity acceptPerson(String nationalCode);
}

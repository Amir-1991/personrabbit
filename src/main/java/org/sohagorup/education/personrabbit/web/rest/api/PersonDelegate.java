package org.sohagorup.education.personrabbit.web.rest.api;

import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;
import org.sohagorup.education.personrabbit.service.response.PersonResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

public interface PersonDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    default ResponseEntity<PersonResponseEntity> requestToRegister(PersonRequestEntity personRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{\"data\":{\"logicalName\":\"logicalName\"},\"success\":true,\"message\":\"message\",\"statusCode\":0}";
                    ApiUtil.setExampleResponse(request,"application/json",exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<PersonResponseEntity> acceptToRegistrationPerson(String nationalCode){
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{\"data\":{\"logicalName\":\"logicalName\"},\"success\":true,\"message\":\"message\",\"statusCode\":0}";
                    ApiUtil.setExampleResponse(request,"application/json",exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}

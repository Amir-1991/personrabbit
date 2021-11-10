package org.sohagorup.education.personrabbit.web.rest.api;

import io.swagger.annotations.*;
import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;
import org.sohagorup.education.personrabbit.service.response.PersonResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Validated
@Api(value = "person")
public interface PersonApi {

    default PersonDelegate personDelegate() {
        return new PersonDelegate() {
        };
    }

    @ApiOperation(value = "", response = PersonResponseEntity.class, tags = {"person"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PersonResponseEntity.class)})
    @RequestMapping(value = "/api/registerPerson",
            produces = {"application/json"}, consumes = {"applocation/json"}, method = RequestMethod.POST)
    default ResponseEntity<PersonResponseEntity> resgister(@Valid @RequestBody PersonRequestEntity personRequest) {
        return personDelegate().requestToRegister(personRequest);
    }

    @ApiOperation(value = "", response = PersonResponseEntity.class, tags = {"person"})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = PersonResponseEntity.class)})
    @RequestMapping(value = "/api/acceptRegistrationPerson/{NationalCode}",
            produces = {"application/json"}, consumes = {"application/json"}, method = RequestMethod.POST)
    default ResponseEntity<PersonResponseEntity> acceptRegistration(@Valid @PathVariable(name = "NationalCode") String nationalCode) {
        return personDelegate().acceptToRegistrationPerson(nationalCode);
    }
}

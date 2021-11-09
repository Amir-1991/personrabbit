package org.sohagorup.education.personrabbit.web.rest.api;

public interface PersonApi {

    default PersonDelegate personDelegate(){
        return new PersonDelegate(){};
    }


}

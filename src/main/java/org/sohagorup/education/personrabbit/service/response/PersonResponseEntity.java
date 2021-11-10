package org.sohagorup.education.personrabbit.service.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.sohagorup.education.personrabbit.service.request.PersonRequestEntity;

import java.io.Serializable;
import java.util.Objects;

public class PersonResponseEntity implements Serializable {

    @JsonProperty("StatusCode")
    private int statusCode;

    @JsonProperty("StatusMessage")
    private String statusMessage;

    @JsonProperty("PersonResult")
    private PersonRequestEntity personResponseEntity;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public PersonRequestEntity getPersonResponseEntity() {
        return personResponseEntity;
    }

    public void setPersonResponseEntity(PersonRequestEntity personResponseEntity) {
        this.personResponseEntity = personResponseEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonResponseEntity)) return false;
        PersonResponseEntity that = (PersonResponseEntity) o;
        return statusCode == that.statusCode &&
                Objects.equals(statusMessage, that.statusMessage) &&
                Objects.equals(personResponseEntity, that.personResponseEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, statusMessage, personResponseEntity);
    }

    @Override
    public String toString() {
        return "PersonResponseEntity{" +
                "statusCode=" + statusCode +
                ", statusMessage='" + statusMessage + '\'' +
                ", personResponseEntity=" + personResponseEntity +
                '}';
    }
}

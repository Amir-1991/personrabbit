package org.sohagorup.education.personrabbit.service.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sohagorup.education.personrabbit.domain.PersonEntity;
import org.sohagorup.education.personrabbit.service.dto.PersonDTO;

public class PersonMapper {
    private final Logger logger = LoggerFactory.getLogger(PersonMapper.class);

    public PersonEntity personDtoToEntity(PersonDTO personDTO){
        logger.debug("personDtoToEntity in progress");
        PersonEntity entity = new PersonEntity();
        if (personDTO != null){
            entity.setFirstName(personDTO.getFirstName());
            entity.setLastName(personDTO.getLastName());
            entity.setFatherName(personDTO.getFatherName());
            entity.setNationalCode(personDTO.getNationalCode());
            entity.setPhoneNumber(personDTO.getPhoneNumber());
            entity.setGender(personDTO.getGender());
        }else{
            logger.debug("personDtoToEntity failed because personDTO is Empty :{}",personDTO);
        }
        return entity;
    }

    public PersonDTO personEntityToDTO(PersonEntity personEntity){
        logger.debug("personEntityToDTO in progress");
        PersonDTO dto = new PersonDTO();
        if (personEntity != null){
            dto.setFirstName(personEntity.getFirstName());
            dto.setLastName(personEntity.getLastName());
            dto.setFatherName(personEntity.getFatherName());
            dto.setNationalCode(personEntity.getNationalCode());
            dto.setPhoneNumber(personEntity.getPhoneNumber());
            dto.setGender(personEntity.getGender());
        }else{
            logger.debug("personEntityToDTO failed because personEntity is Empty :{}",personEntity);
        }
        return dto;
    }
}

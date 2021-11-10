package org.sohagorup.education.personrabbit.repository;

import org.sohagorup.education.personrabbit.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
}

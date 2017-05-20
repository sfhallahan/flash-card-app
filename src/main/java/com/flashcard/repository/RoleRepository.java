package com.flashcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flashcard.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}

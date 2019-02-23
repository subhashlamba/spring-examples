package com.javadeveloperzone.hateoas.repository;

import com.javadeveloperzone.hateoas.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

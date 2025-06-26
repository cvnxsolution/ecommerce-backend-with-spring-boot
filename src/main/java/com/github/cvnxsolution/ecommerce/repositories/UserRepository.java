package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
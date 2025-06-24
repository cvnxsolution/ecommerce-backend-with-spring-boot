package com.github.cvnxsolution.ecommerce.repositories.specifications;

import com.github.cvnxsolution.ecommerce.entities.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpec {
    public static Specification<User> hasName(String name){
        return ((root, query, cb) -> cb.equal(root.get("name"), name));
    }

    public static Specification<User> hasEmail(String email){
        return ((root, query, cb) -> cb.equal(root.get("email"), email));
    }


}

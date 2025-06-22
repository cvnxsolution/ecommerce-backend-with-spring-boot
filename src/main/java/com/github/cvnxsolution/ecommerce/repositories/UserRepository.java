package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(long id);
    User findByEmail(String email);
    User findByName(String name);
    User findByAddresses_Street(String street);
    User findByAddresses_City(String city);
    User findByAddresses_State(String state);
    User findByAddresses_Zip(String zip);


    @Query(value = "select * from users u join users_tags ut on u.id = ut.user_id join tags t on ut.tag_id = t.id where t.name = :tagName", nativeQuery = true)
    List<User> findUsersWithTag(@Param("tagName") String tagName);

    List<User> findByTags_Name(String name);

    @Query("select u from User u where size(u.tags) >= :minTags ")
    List<User> findUsersWithMinTagsJPQL(@Param("minTags") Byte minTags);

    @Query(value = "select * from users u join users_tags ut on u.id = ut.user_id join tags t on ut.tag_id = t.id group by u.id having count(ut.tag_id) > :minTags", nativeQuery = true)
    List<User> findUsersWithMinTagsNativeQuery(@Param("minTags") int minTags);

}

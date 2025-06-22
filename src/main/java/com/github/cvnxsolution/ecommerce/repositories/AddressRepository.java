package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findByUser_Id(Long id);


    @Query(value = "select * from addresses a where a.user_id = :id", nativeQuery = true)
    List<Address> findByUserIdNativeQuery(@Param("id") Long id);

    @Query("select a from Address a where a.user.id = :id")
    List<Address> findByUserIdJPQL(@Param("id") Long id);

    void deleteByCityEqualsIgnoreCase(String city);
}

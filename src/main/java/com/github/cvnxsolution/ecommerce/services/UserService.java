package com.github.cvnxsolution.ecommerce.services;

import com.github.cvnxsolution.ecommerce.entities.Address;
import com.github.cvnxsolution.ecommerce.entities.User;
import com.github.cvnxsolution.ecommerce.repositories.AddressRepository;
import com.github.cvnxsolution.ecommerce.repositories.ProductRepository;
import com.github.cvnxsolution.ecommerce.repositories.ProfileRepository;
import com.github.cvnxsolution.ecommerce.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ProfileRepository profileRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void fetchProducts() {
        var products = productRepository.findProducts(BigDecimal.valueOf(0), BigDecimal.valueOf(150));
        products.forEach(System.out::println);
        System.out.println(products.size());
    }

    public void fetchProductByCriteria(){
        productRepository.findProductsByCriteria(null, BigDecimal.valueOf(0), BigDecimal.valueOf(400));
    }


    public void addOneUser(User user){
        var address = Address.builder().state("state").city("city")
                .zip("zip").street("street").build();
        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public User removeAddress(Long id){
        var user = userRepository.findById(id).orElseThrow();
        var address = addressRepository.findById(id).orElseThrow();
        user.getAddresses().remove(address);
        userRepository.save(user);
        return user;
    }

    public void populate(){
        profileRepository.populateProfileAndUser();
    }

    public void findLoyals(){
        var users = userRepository.findLoyalUsers((byte) 0);
        users.forEach(System.out::println);
    }




}
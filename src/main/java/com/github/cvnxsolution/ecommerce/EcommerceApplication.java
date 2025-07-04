package com.github.cvnxsolution.ecommerce;

import com.github.cvnxsolution.ecommerce.entities.Address;
import com.github.cvnxsolution.ecommerce.entities.User;
import com.github.cvnxsolution.ecommerce.repositories.ProfileRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
      ApplicationContext context =  SpringApplication.run(EcommerceApplication.class, args);
    }

}

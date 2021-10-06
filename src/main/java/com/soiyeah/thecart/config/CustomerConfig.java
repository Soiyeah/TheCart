package com.soiyeah.thecart.config;

import com.soiyeah.thecart.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository){
        return args -> {

//            Customer sohan = new Customer();
//            Address address = new Address("25","Sagara Lane", "Egoda Uyana","10400", sohan);
//
//            sohan = new Customer("Sohan", "sohan@gmail.com", "0770053513", address);
//            repository.save(sohan);
        };
    }

}

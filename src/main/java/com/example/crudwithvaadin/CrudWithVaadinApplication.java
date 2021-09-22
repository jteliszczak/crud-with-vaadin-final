package com.example.crudwithvaadin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CrudWithVaadinApplication {

    private static final Logger log = LoggerFactory.getLogger
            (CrudWithVaadinApplication.class);

    public static void main(String[] args){
        SpringApplication.run(CrudWithVaadinApplication.class);
    }

    @Bean
    public CommandLineRunner loadData(CustomerRepository repository) {
        return (args) -> {
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("Michelle", "Dessler"));

            log.info("Customers found with findAll():");
            log.info("--------------------------");

            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }

            log.info("");

            Customer customer = repository.getById(1L);

            log.info("Customer found with findAll(1L):");
            log.info("--------------------------");
            log.info("Customer found with findByLastNameStartsWithIgnoreCase('Bauer'):");
            log.info("--------------------------");

            for (Customer bauer : repository.findByLastNameStartWithIgnoreCase("Bauer")) {
                log.info(bauer.toString());
            }
                log.info("");
        };
    }

}

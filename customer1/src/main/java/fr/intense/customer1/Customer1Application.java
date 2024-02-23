package fr.intense.customer1;

import fr.intense.customer1.entities.Customer;
import fr.intense.customer1.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Customer1Application {

    public static void main(String[] args) {

    SpringApplication.run(Customer1Application.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){

        return args -> {
            List<Customer> customerList = List.of(
                    Customer
                            .builder()
                            .firstName("Nouhaila")
                            .lastName("Ouahbani")
                            .email("nouhaila.ouahbani@gmail.com")
                            .build(),

            Customer
                    .builder()
                    .firstName("Ali")
                    .lastName("Bennis")
                    .email("ali.bennis@gmail.com")
                    .build()
            );


            customerRepository.saveAll(customerList);



        };
    }
}

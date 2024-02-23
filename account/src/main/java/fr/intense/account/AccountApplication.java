package fr.intense.account;

import fr.intense.account.entities.Account;
import fr.intense.account.enums.CurrencyType;
import fr.intense.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {

            List<Account>accountList = List.of(
                    Account
                            .builder()
                            .dateCreated(LocalDate.now())
                            .balance(Math.random()*10000)
                            .currencyType(CurrencyType.EUR)
                            .customerId(1L)

                            .build()

            );
            accountRepository.saveAll(accountList);
        };
    }


}

package fr.intense.account.entities;


import fr.intense.account.enums.CurrencyType;
import fr.intense.account.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor @ToString @Builder
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double  balance;
    private LocalDate dateCreated;
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    private Long customerId;

    @Transient

    private Customer customer;



}

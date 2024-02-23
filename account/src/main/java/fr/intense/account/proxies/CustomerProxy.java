package fr.intense.account.proxies;

import fr.intense.account.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer1", url="localhost:8091")
public interface CustomerProxy {


    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    public List<Customer> getAllCustomers();

}

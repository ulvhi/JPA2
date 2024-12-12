package com.jpatask.controller;

import com.jpatask.dao.entity.CustomerEntity;
import com.jpatask.model.request.*;
import com.jpatask.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody CreateCustomerRequest customer){
        customerService.saveCustomer(customer);
    }
    @PatchMapping("/{id}/subscriptionAmount")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSubscriptionAmount(@PathVariable long id, @RequestBody UpdateSubscriptionAmountRequest updateSubscriptionAmountRequest){
        customerService.updateSubscriptionAmount(id, updateSubscriptionAmountRequest);
    }
    @GetMapping("/{id}")
    public CustomerEntity getCustomer(@PathVariable Long id){
        return customerService.findById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
    @PatchMapping("/{id}/name")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateName(@PathVariable long id, @RequestBody UpdateNameRequest request){
        customerService.updateName(id, request);
    }
    @PatchMapping("/{id}/surname")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSurname(@PathVariable long id, @RequestBody UpdateSurnameRequest request) {
        customerService.updateSurname(id, request);
    }

    //muellim bu metodd neyi sehv yazmisam islemedi postmandan request atanda
    @GetMapping("/nameAndSurname")
    public CustomerEntity findByNameAndSurname(GetByNameAndSurnameRequest request){
        return customerService.findByNameAndSurname(request);
    }

}

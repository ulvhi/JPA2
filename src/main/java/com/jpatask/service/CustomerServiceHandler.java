package com.jpatask.service;

import com.jpatask.dao.entity.CustomerEntity;
import com.jpatask.dao.repository.CustomerRepository;
import com.jpatask.model.enums.SubscriptionStatus;
import com.jpatask.model.request.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceHandler implements CustomerService {
    private final CustomerRepository customerRepository;
    private CustomerEntity fetchCustomerIfExist(Long id) {
        return customerRepository.findByIdAndSubscriptionStatusNot(id, SubscriptionStatus.FREE).
                orElseThrow(RuntimeException::new);
    };

    @Override
    public void saveCustomer(CreateCustomerRequest request) {
        CustomerEntity builder = CustomerEntity.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .subscriptionAmount(request.getSubscriptionAmount())
                .build();
        customerRepository.save(builder);
    }

    @Override
    public void updateSubscriptionAmount(Long id, UpdateSubscriptionAmountRequest request) {
    var customer = fetchCustomerIfExist(id);
    customer.setSubscriptionAmount(request.getSubscriptionAmount());
    customerRepository.save(customer);
    }

    @Override
    public void updateName(Long id, UpdateNameRequest request) {
        var customer = findById(id);
        customer.setName(request.getName());
        customerRepository.save(customer);
    }

    @Override
    public void updateSurname(Long id, UpdateSurnameRequest request) {
        var customer = findById(id);
        customer.setSurname(request.getSurname());
        customerRepository.save(customer);
    }

    @Override
    public void updateEmail(Long id, UpdateEmailRequest request) {
        var customer = findById(id);
        customer.setEmail(request.getEmail());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        var customer = fetchCustomerIfExist(id);
        customer.setSubscriptionStatus(SubscriptionStatus.FREE);
        customerRepository.save(customer);
    }

    @Override
    public CustomerEntity findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public CustomerEntity findByIdAndPremium(Long id) {
        return fetchCustomerIfExist(id);
    }

    @Override
    public CustomerEntity findByNameAndSurname(GetByNameAndSurnameRequest request) {
        return customerRepository.findByNameAndSurname(request.getName(), request.getSurname()).orElseThrow(RuntimeException::new);
    }
}

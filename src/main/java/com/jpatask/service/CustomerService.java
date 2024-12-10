package com.jpatask.service;

import com.jpatask.dao.entity.CustomerEntity;
import com.jpatask.model.request.*;

public interface CustomerService {
    void saveCustomer(CreateCustomerRequest customer);
    void updateSubscriptionAmount(Long id, UpdateSubscriptionAmountRequest request);
    void updateName(Long id, UpdateNameRequest request);
    void updateSurname(Long id, UpdateSurnameRequest request);
    void updateEmail(Long id, UpdateEmailRequest request);
    void deleteCustomer(Long id);
    CustomerEntity findById(Long id);
    CustomerEntity findByIdAndPremium(Long id);
    CustomerEntity findByNameAndSurname(GetByNameAndSurnameRequest request);
}

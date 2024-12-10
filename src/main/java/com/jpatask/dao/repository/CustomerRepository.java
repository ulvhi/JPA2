package com.jpatask.dao.repository;

import com.jpatask.dao.entity.CustomerEntity;
import com.jpatask.model.enums.SubscriptionStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByIdAndSubscriptionStatusNot(Long id,
                                                               SubscriptionStatus status);
    Optional<CustomerEntity> findByNameAndSurname(String name, String surname);
    List<Long> findIdByName(String name);
}

package com.jpatask.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequest {
    private String name;
    private String surname;
    private String email;
    private BigDecimal subscriptionAmount;
}

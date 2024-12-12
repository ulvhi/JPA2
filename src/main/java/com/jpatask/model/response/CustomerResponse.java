package com.jpatask.model.response;

import com.jpatask.model.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private BigDecimal subscriptionAmount;
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;
}

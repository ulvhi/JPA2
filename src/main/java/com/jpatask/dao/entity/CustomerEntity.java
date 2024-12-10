package com.jpatask.dao.entity;

import com.jpatask.model.enums.SubscriptionStatus;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private BigDecimal subscriptionAmount;
    @Enumerated(EnumType.STRING)
    private SubscriptionStatus subscriptionStatus;
}

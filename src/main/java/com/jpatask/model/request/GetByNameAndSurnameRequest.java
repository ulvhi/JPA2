package com.jpatask.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByNameAndSurnameRequest {
    private String name;
    private String surname;
}

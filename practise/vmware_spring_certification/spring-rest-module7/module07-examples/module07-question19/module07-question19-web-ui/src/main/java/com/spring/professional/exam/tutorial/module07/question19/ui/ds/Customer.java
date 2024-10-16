package com.spring.professional.exam.tutorial.module07.question19.ui.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String code;
    private String firstName;
    private String lastName;

    @SuppressWarnings("unused")
    public Customer() {
    }
}

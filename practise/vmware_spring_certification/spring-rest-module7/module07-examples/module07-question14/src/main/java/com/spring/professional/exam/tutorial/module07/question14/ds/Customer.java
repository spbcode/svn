package com.spring.professional.exam.tutorial.module07.question14.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {
    private String code;
    private String firstName;
    private String lastName;

    @SuppressWarnings("unused")
    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "code='" + code + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

package com.spring.professional.exam.tutorial.module07.question19.api.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    private String code;
    private String firstName;
    private String lastName;

    @SuppressWarnings("unused")
    public Customer() {
    }
}

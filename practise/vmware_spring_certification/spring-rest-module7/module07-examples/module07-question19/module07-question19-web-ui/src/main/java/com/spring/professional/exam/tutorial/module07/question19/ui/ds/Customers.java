package com.spring.professional.exam.tutorial.module07.question19.ui.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Customers {
    private List<Customer> customers;

    @SuppressWarnings("unused")
    public Customers() {
    }
}

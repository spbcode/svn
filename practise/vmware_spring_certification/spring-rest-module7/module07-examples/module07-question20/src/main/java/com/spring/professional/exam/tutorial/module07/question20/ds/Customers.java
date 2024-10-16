package com.spring.professional.exam.tutorial.module07.question20.ds;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
public class Customers {
    private List<Customer> customers = new LinkedList<>();

    @SuppressWarnings("unused")
    public Customers() {
    }

    public Customers(Iterable<Customer> customers) {
        this.customers = StreamSupport.stream(customers.spliterator(), false)
                .collect(Collectors.toList());
    }
}

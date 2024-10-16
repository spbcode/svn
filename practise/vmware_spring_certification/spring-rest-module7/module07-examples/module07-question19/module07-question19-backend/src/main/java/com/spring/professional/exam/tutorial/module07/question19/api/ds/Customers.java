package com.spring.professional.exam.tutorial.module07.question19.api.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
public class Customers {
    private List<Customer> customers;

    @SuppressWarnings("unused")
    public Customers() {
    }

    public Customers(Spliterator<Customer> spliterator) {
        customers = StreamSupport.stream(spliterator, false)
                .collect(Collectors.toList());
    }
}

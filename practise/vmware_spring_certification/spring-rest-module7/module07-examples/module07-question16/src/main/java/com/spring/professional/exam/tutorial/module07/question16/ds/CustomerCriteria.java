package com.spring.professional.exam.tutorial.module07.question16.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerCriteria {
    private String firstNameLike;

    @SuppressWarnings("unused")
    public CustomerCriteria() {
    }
}

package com.spring.professional.exam.tutorial.module07.question09.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleCriteria {
    private String bodyLike;

    @SuppressWarnings("unused")
    public ArticleCriteria() {
    }
}

package com.spring.demo.springdemo.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {

    Optional<TicketType> findByCode(String code);
}

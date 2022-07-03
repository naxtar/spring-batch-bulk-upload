package com.example.cofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cofacil.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}

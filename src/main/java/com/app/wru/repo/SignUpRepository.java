package com.app.wru.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.wru.models.Customer;

@Repository
public interface SignUpRepository extends JpaRepository<Customer, Long> {

}

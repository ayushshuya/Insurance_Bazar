package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Bill;

public interface BillEntityRepository extends JpaRepository<Bill,Long>{

}

package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Vehicle;

public interface VehicleEntityRepository extends JpaRepository<Vehicle, Long>{

}

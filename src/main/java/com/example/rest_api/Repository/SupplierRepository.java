package com.example.rest_api.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest_api.Models.Supplier;

public interface SupplierRepository  extends JpaRepository<Supplier,Long> {
   

}

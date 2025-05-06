package com.example.rest_api.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.rest_api.Models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

 
    @Query("SELECT s FROM Supplier s WHERE s.addres = :addres")
    Optional<Supplier> findByAddres(@Param("addres") String addres);

  
    @Query("SELECT s FROM Supplier s WHERE s.supplierName = :supplierName")
    List<Supplier> findBySupplierName(@Param("supplierName") String supplierName);
}

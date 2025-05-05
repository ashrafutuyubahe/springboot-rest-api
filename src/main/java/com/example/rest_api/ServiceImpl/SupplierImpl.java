package com.example.rest_api.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest_api.Models.Supplier;
import com.example.rest_api.Repository.SupplierRepository;

@Service
public class SupplierImpl {

    @Autowired
    private SupplierRepository userRepository;


    public Supplier createSupplier(Supplier supplier) {
        return userRepository.save(supplier);
    }

    
    public Supplier getSupplierByID(Long supplierId) {
        return userRepository.findById(supplierId).orElse(null);
    }

    
    public List<Supplier> getAllSuppliers() {
        return userRepository.findAll(); 
    }

    
    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Optional<Supplier> optionalSupplier = userRepository.findById(id);

        if (optionalSupplier.isPresent()) {
            Supplier existing = optionalSupplier.get();
            existing.setSupplierName(supplierDetails.getSupplierName());
            existing.setAddres(supplierDetails.getAddres());
            return userRepository.save(existing);
        } else {
            return null;
        }
    }

    
    public void deleteSupplier(Long id) {
        userRepository.deleteById(id);
    }
}

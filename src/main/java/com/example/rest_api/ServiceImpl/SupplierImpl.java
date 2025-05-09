package com.example.rest_api.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


   public  Supplier searchByAddres(String addr){
    //  Supplier supplierFound= userRepository.findBySupplierAddress(addr);
    // return  supplierFound;
    return userRepository.findByAddres(addr).orElse(null);
    
   }
    
    public void deleteSupplier(Long id) {
        userRepository.deleteById(id);
    }



    public List<Supplier> searchBySupplierName(String name) {
        return userRepository.findBySupplierName(name);
    }

    public Page<Supplier> getAllSuppliersPaginated(Pageable pageable) {
    return userRepository.findAll(pageable);
}

public List<Supplier> getAllSuppliersSortedByName(String sortDir) {
    Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by("supplierName").descending() :
                Sort.by("supplierName").ascending();

    return userRepository.findAll(sort);
}



}

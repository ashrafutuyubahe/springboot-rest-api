package com.example.rest_api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.rest_api.Models.Supplier;
import com.example.rest_api.ServiceImpl.SupplierImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {

    @Autowired
    private SupplierImpl supplierService;

    @PostMapping
    public ResponseEntity<Supplier> create(@RequestBody Supplier supplier) {
        return ResponseEntity.ok(supplierService.createSupplier(supplier));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Supplier>> getAll() {
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @GetMapping("/get-single/{id}")
    public ResponseEntity<Supplier> getById(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierByID(id);
        if (supplier != null)
            return ResponseEntity.ok(supplier);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier updated) {
        Supplier supplier = supplierService.updateSupplier(id, updated);
        if (supplier != null)
            return ResponseEntity.ok(supplier);
        else
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/search-by-addres/{address}")
    public Supplier searchByAddress(@PathVariable String address) {
        return supplierService.searchByAddres(address);
    }


    @GetMapping("/search-by-name/{supplierName}")
    public List<Supplier> searchByName(@PathVariable("supplierName") String supplierName) {
        return supplierService.searchBySupplierName(supplierName);
    }
    

    
    @GetMapping("/paginated")
public ResponseEntity<Page<Supplier>> getAllPaginated(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {
    
    Pageable pageable = PageRequest.of(page, size);
    Page<Supplier> pagedSuppliers = supplierService.getAllSuppliersPaginated(pageable);
    return ResponseEntity.ok(pagedSuppliers);
}

//implement sorting using name 

}

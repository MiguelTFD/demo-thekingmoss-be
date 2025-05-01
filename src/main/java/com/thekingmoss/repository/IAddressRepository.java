package com.thekingmoss.repository;

import com.thekingmoss.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    
}

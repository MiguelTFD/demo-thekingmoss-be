package com.thekingmoss.repository.address;

import com.thekingmoss.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    
}

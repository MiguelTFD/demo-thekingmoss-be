package com.thekingmoss.repository;

import com.thekingmoss.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    //Lists all the registered Addresses for a especific user
    List<Address> findAddressByUser_UserId(Long id);
}

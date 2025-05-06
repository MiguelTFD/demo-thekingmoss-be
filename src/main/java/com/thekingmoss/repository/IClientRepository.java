package com.thekingmoss.repository;

import com.thekingmoss.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Long> {

}

package com.durgesh.email_address.dao;

import com.durgesh.email_address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDao extends JpaRepository<Address,Integer> {
}

package com.example.practice23.Repository;

import com.example.practice23.Entity.Phone;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends CrudRepository<Phone, Long>, JpaSpecificationExecutor<Phone> {
}

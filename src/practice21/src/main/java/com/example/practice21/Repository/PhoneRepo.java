package com.example.practice21.Repository;

import com.example.practice21.Entity.Phone;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends CrudRepository<Phone, Long>, JpaSpecificationExecutor<Phone> {
}

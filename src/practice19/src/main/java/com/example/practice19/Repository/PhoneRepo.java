package com.example.practice19.Repository;

import com.example.practice19.Entity.Phone;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends CrudRepository<Phone, Long>, JpaSpecificationExecutor<Phone> {
}

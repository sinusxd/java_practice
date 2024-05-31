package com.example.practice24.Repository;

import com.example.practice24.Entity.Manufacture;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ManufactureRepo extends CrudRepository<Manufacture, Long>, JpaSpecificationExecutor<Manufacture> {
}

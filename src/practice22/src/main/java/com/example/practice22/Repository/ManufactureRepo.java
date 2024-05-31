package com.example.practice22.Repository;

import com.example.practice22.Entity.Manufacture;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ManufactureRepo extends CrudRepository<Manufacture, Long>, JpaSpecificationExecutor<Manufacture> {
}

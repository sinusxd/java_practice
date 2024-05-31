package com.example.practice18.Repository;

import com.example.practice18.Entity.Manufacture;
import com.example.practice18.Entity.Phone;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufactureRepo extends CrudRepository<Manufacture, Long>, JpaSpecificationExecutor<Manufacture> {
}

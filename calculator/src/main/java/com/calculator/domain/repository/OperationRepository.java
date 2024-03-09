package com.calculator.domain.repository;

import com.calculator.persistence.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}

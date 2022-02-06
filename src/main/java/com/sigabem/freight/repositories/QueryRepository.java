package com.sigabem.freight.repositories;

import com.sigabem.freight.models.QueryModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<QueryModel, Long> {
    
}

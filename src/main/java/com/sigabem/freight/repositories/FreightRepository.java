package com.sigabem.freight.repositories;

import com.sigabem.freight.models.FreightModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRepository extends JpaRepository<FreightModel, Long>{
    
}

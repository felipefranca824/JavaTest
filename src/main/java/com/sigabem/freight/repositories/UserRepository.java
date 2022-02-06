package com.sigabem.freight.repositories;

import com.sigabem.freight.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}

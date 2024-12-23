package com.ipl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipl.pojos.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long> {

}

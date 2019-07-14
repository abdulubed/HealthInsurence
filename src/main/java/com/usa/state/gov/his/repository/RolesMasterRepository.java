package com.usa.state.gov.his.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.entity.RolesMasterEntity;

@Repository
public interface RolesMasterRepository extends JpaRepository<RolesMasterEntity, Serializable>{
	

}

package com.usa.state.gov.his.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.state.gov.his.entity.AdminMasterEntity;

/**  
 * this interface is for implementing database operations 
 * @author Abdul
 *
 */
@Repository
public interface AdminMasterRepository extends JpaRepository<AdminMasterEntity, Serializable>{
	
	
	

}

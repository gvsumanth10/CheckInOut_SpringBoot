package com.webapp.demo.CheckInOutDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.CheckInOut.CheckInOut;

public interface CheckInOutDao extends JpaRepository<CheckInOut,Integer >{
	
	@Query(value="select * from class_log where date= ?1",nativeQuery = true)
	List<CheckInOut> findAllByDate(String date);
}
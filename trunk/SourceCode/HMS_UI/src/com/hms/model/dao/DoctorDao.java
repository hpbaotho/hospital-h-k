/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.Doctor;

/**
 * @author huanpham
 *
 */
public interface DoctorDao {

	void save(Doctor doctor);
	void update(Doctor doctor);
	void delete(Doctor doctor);
	List<Doctor> findAll();
	Doctor findById(String id);
	List<Doctor> findByDeptId(String deptId);
	
}

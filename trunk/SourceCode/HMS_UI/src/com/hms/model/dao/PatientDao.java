/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.Item;
import com.hms.model.entity.Patient;

/**
 * @author huanpham
 *
 */
public interface PatientDao {

	void save(Patient patient);
	void update(Patient patient);
	void delete(Patient patient);
	List<Patient> findAll();
	Patient findById(String id);
	List<Patient> find(List<Item> criteria);
}

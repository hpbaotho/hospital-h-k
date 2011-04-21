/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.BasicMedicalRecord;

/**
 * @author huanpham
 *
 */
public interface BasicMedicalRecordDao {

	void save(BasicMedicalRecord basicMedicalRecord);
	void update(BasicMedicalRecord basicMedicalRecord);
	void delete(BasicMedicalRecord basicMedicalRecord);
	List<BasicMedicalRecord> findAll();
	BasicMedicalRecord findById(String id);
	List<BasicMedicalRecord> findByPatientId(String patientID);
	BasicMedicalRecord findCurrentRecordByPatientId(String patientID);
}

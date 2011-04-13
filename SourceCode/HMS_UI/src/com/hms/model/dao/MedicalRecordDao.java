/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.MedicalRecord;

/**
 * @author huanpham
 *
 */
public interface MedicalRecordDao {

	void save(MedicalRecord medicalRecord);
	void update(MedicalRecord medicalRecord);
	void delete(MedicalRecord medicalRecord);
	List<MedicalRecord> findAll();
	MedicalRecord findById(String id);

}

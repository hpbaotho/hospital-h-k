/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.MedicineGroup;

/**
 * @author huanpham
 *
 */
public interface MedicineGroupDao {

	void save(MedicineGroup medicineGroup);
	void update(MedicineGroup medicineGroup);
	void delete(MedicineGroup medicineGroup);
	List<MedicineGroup> findAll();
	MedicineGroup findById(String id);

}

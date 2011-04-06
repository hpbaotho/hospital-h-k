/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.Item;
import com.hms.model.entity.Medicine;

/**
 * @author huanpham
 *
 */
public interface MedicineDao {

	void save(Medicine medicine);
	void update(Medicine medicine);
	void delete(Medicine medicine);
	List<Medicine> findAll();
	Medicine findById(String id);
	List<Medicine> find(List<Item> criteria);
}

/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.Service;

/**
 * @author huanpham
 *
 */
public interface ServiceDao {

	void save(Service service);
	void update(Service Service);
	void delete(Service Service);
	List<Service> findAll();
	Service findById(String id);
	Service findByDeptId(String deptID);

}

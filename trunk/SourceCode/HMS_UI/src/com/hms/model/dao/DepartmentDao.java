/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.Department;

/**
 * @author huanpham
 *
 */
public interface DepartmentDao {

	void save(Department department);
	void update(Department department);
	void delete(Department department);
	List<Department> findAll();
	Department findById(String id);

}

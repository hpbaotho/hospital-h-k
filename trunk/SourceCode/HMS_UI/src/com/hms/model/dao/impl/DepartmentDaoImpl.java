/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.DepartmentDao;
import com.hms.model.entity.Department;


/**
 * @author huanpham
 *
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public void delete(Department department) {
		this.getHibernateTemplate().delete(department);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("from Department");
	}

	@Override
	public Department findById(String id) {
		@SuppressWarnings("unchecked")
		List<Department> list = this.getHibernateTemplate().find("from Department where Dept_ID=?", id);
		if (list.size() > 0) {
			return (Department) list.get(0);
		}
		
		return null;
	}

	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
	}

}

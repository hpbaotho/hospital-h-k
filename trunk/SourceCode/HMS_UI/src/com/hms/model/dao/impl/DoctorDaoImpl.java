/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.DoctorDao;
import com.hms.model.entity.Doctor;


/**
 * @author huanpham
 *
 */
public class DoctorDaoImpl extends HibernateDaoSupport implements DoctorDao {

	@Override
	public void delete(Doctor doctor) {
		this.getHibernateTemplate().delete(doctor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findAll() {
		return this.getHibernateTemplate().find("from Doctor");
	}

	@Override
	public Doctor findById(String id) {
		@SuppressWarnings("unchecked")
		List<Doctor> list = this.getHibernateTemplate().find("from Doctor where Doctor_ID=?", id);
		if (list.size() > 0) {
			return (Doctor) list.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findByDeptId(String deptId) {
		return this.getHibernateTemplate().find("from Doctor where Dept_ID=?", deptId);
	}
	
	@Override
	public void save(Doctor doctor) {
		this.getHibernateTemplate().save(doctor);
	}

	@Override
	public void update(Doctor doctor) {
		this.getHibernateTemplate().update(doctor);
	}

}

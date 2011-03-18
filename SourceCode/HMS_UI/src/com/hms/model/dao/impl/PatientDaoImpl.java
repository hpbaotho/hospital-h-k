/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.PatientDao;
import com.hms.model.entity.Patient;


/**
 * @author huanpham
 *
 */
public class PatientDaoImpl extends HibernateDaoSupport implements PatientDao {

	@Override
	public void delete(Patient patient) {
		this.getHibernateTemplate().delete(patient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAll() {
		return this.getHibernateTemplate().find("from Patient");
	}

	@Override
	public Patient findById(String id) {
		@SuppressWarnings("unchecked")
		List<Patient> list = this.getHibernateTemplate().find("from Patient where Patient_ID=?", id);
		if (list.size() > 0) {
			return (Patient) list.get(0);
		}
		
		return null;
	}

	@Override
	public void save(Patient patient) {
		this.getHibernateTemplate().save(patient);
	}

	@Override
	public void update(Patient patient) {
		this.getHibernateTemplate().update(patient);
	}

}

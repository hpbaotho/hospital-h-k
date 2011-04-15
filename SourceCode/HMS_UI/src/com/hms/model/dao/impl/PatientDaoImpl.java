/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.PatientDao;
import com.hms.model.entity.Item;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> find(List<Item> criteria) {
		String query = "from Patient";
		
		if (criteria != null && criteria.size() > 0) {
			query += " where ";
			
			query += criteria.get(0).getLabel() + " like '" + criteria.get(0).getValue() + "'";
			
			for (int i = 1; i < criteria.size(); i++) {
				query += " AND " + criteria.get(i).getLabel() + " like '" + criteria.get(i).getValue() + "'";
			}
		}
		
		return this.getHibernateTemplate().find(query);
	}

}

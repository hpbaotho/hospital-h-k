/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.BasicMedicalRecordDao;
import com.hms.model.entity.BasicMedicalRecord;


/**
 * @author huanpham
 *
 */
public class BasicMedicalRecordDaoImpl extends HibernateDaoSupport implements BasicMedicalRecordDao {

	@Override
	public void delete(BasicMedicalRecord basicMedicalRecord) {
		this.getHibernateTemplate().delete(basicMedicalRecord);
	}

	@Override
	public void save(BasicMedicalRecord basicMedicalRecord) {
		this.getHibernateTemplate().save(basicMedicalRecord);
	}

	@Override
	public void update(BasicMedicalRecord basicMedicalRecord) {
		this.getHibernateTemplate().update(basicMedicalRecord);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BasicMedicalRecord> findAll() {
		return this.getHibernateTemplate().find("from BasicMedicalRecord");
	}

	@Override
	public BasicMedicalRecord findById(String id) {
		@SuppressWarnings("unchecked")
		List<BasicMedicalRecord> list = this.getHibernateTemplate().find("from BasicMedicalRecord where Basic_Record_ID=?", id);
		if (list.size() > 0) {
			return (BasicMedicalRecord) list.get(0);
		}
		
		return null;
	}

	@Override
	public List<BasicMedicalRecord> findByPatientId(String patientID) {
		@SuppressWarnings("unchecked")
		List<BasicMedicalRecord> list = this.getHibernateTemplate().find("from BasicMedicalRecord where Patient_ID=?", patientID);
		
		return list;
	}
	
	
}

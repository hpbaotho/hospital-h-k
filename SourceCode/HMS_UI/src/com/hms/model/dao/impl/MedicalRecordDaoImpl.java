/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.MedicalRecordDao;
import com.hms.model.entity.MedicalRecord;


/**
 * @author huanpham
 *
 */
public class MedicalRecordDaoImpl extends HibernateDaoSupport implements MedicalRecordDao {

	@Override
	public void delete(MedicalRecord medicalRecord) {
		this.getHibernateTemplate().delete(medicalRecord);
	}

	@Override
	public void save(MedicalRecord medicalRecord) {
		this.getHibernateTemplate().save(medicalRecord);
	}

	@Override
	public void update(MedicalRecord medicalRecord) {
		this.getHibernateTemplate().update(medicalRecord);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicalRecord> findAll() {
		return this.getHibernateTemplate().find("from MedicalRecord");
	}

	@Override
	public MedicalRecord findById(String id) {
		@SuppressWarnings("unchecked")
		List<MedicalRecord> list = this.getHibernateTemplate().find("from MedicalRecord where Record_ID=?", id);
		if (list.size() > 0) {
			return (MedicalRecord) list.get(0);
		}
		
		return null;
	}
}

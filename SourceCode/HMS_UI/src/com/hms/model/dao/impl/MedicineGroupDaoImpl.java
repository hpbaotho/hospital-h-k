/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.MedicineGroupDao;
import com.hms.model.entity.MedicineGroup;


/**
 * @author huanpham
 *
 */
public class MedicineGroupDaoImpl extends HibernateDaoSupport implements MedicineGroupDao {

	@Override
	public void delete(MedicineGroup medicineGroup) {
		this.getHibernateTemplate().delete(medicineGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicineGroup> findAll() {
		return this.getHibernateTemplate().find("from MedicineGroup");
	}

	@Override
	public MedicineGroup findById(String id) {
		@SuppressWarnings("unchecked")
		List<MedicineGroup> list = this.getHibernateTemplate().find("from MedicineGroup where Group_ID=?", id);
		if (list.size() > 0) {
			return (MedicineGroup) list.get(0);
		}
		
		return null;
	}

	@Override
	public void save(MedicineGroup medicineGroup) {
		this.getHibernateTemplate().save(medicineGroup);
	}

	@Override
	public void update(MedicineGroup medicineGroup) {
		this.getHibernateTemplate().update(medicineGroup);
	}

}

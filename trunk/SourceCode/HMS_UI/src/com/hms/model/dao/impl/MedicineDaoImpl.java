/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.MedicineDao;
import com.hms.model.entity.Item;
import com.hms.model.entity.Medicine;


/**
 * @author huanpham
 *
 */
public class MedicineDaoImpl extends HibernateDaoSupport implements MedicineDao {

	@Override
	public void delete(Medicine medicine) {
		this.getHibernateTemplate().delete(medicine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> findAll() {
		return this.getHibernateTemplate().find("from Medicine");
	}

	@Override
	public Medicine findById(String id) {
		@SuppressWarnings("unchecked")
		List<Medicine> list = this.getHibernateTemplate().find("from Medicine where Medicine_ID=?", id);
		if (list.size() > 0) {
			return (Medicine) list.get(0);
		}
		
		return null;
	}

	@Override
	public void save(Medicine medicine) {
		this.getHibernateTemplate().save(medicine);
	}

	@Override
	public void update(Medicine medicine) {
		this.getHibernateTemplate().update(medicine);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> find(List<Item> criteria) {
		String query = "from Medicine";
		
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

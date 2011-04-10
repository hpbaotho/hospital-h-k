/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.ServiceDao;
import com.hms.model.entity.Service;


/**
 * @author huanpham
 *
 */
public class ServiceDaoImpl extends HibernateDaoSupport implements ServiceDao {

	@Override
	public void delete(Service service) {
		this.getHibernateTemplate().delete(service);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> findAll() {
		return this.getHibernateTemplate().find("from Service");
	}

	@Override
	public Service findById(String id) {
		@SuppressWarnings("unchecked")
		List<Service> list = this.getHibernateTemplate().find("from Service where Service_No=?", id);
		if (list.size() > 0) {
			return (Service) list.get(0);
		}
		
		return null;
	}

	@Override
	public void save(Service service) {
		this.getHibernateTemplate().save(service);
	}

	@Override
	public void update(Service service) {
		this.getHibernateTemplate().update(service);
	}

	@Override
	public List<Service> findByDeptId(String deptID) {
		@SuppressWarnings("unchecked")
		List<Service> list = this.getHibernateTemplate().find("from Service where Dept_ID=?", deptID);
		
		return list;
	}

}

/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.V_MaterialDao;
import com.hms.model.entity.V_Material;


/**
 * @author huanpham
 *
 */
public class V_MaterialDaoImpl extends HibernateDaoSupport implements V_MaterialDao {

	@Override
	public void delete(V_Material material) {
		this.getHibernateTemplate().delete(material);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<V_Material> findAll() {
		return this.getHibernateTemplate().find("from V_Material");
	}

	@Override
	public V_Material findById(String id) {
		@SuppressWarnings("unchecked")
		List<V_Material> list = this.getHibernateTemplate().find("from V_Material where no=?", id);
		if (list.size() > 0) {
			return (V_Material) list.get(0);
		}
		
		return null;
	}

	@Override
	public List<V_Material> findByType(String type) {
		@SuppressWarnings("unchecked")
		List<V_Material> list = this.getHibernateTemplate().find("from V_Material where type=?", type);
		
		return list;
	}
	
	@Override
	public void save(V_Material material) {
		this.getHibernateTemplate().save(material);
	}

	@Override
	public void update(V_Material material) {
		this.getHibernateTemplate().update(material);
	}

}

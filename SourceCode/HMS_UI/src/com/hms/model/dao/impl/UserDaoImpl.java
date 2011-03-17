/**
 * 
 */
package com.hms.model.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hms.model.dao.UserDao;
import com.hms.model.entity.User;


/**
 * @author huanpham
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void delete(User user) {
		this.getHibernateTemplate().delete(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		return this.getHibernateTemplate().find("from User");
	}

	@Override
	public User findByIdAndPass(String id, String password) {
		@SuppressWarnings("unchecked")
		List<User> list = this.getHibernateTemplate().find("from User where User_ID=? and Password=?", id, password);
		if (list.size() > 0) {
			return (User) list.get(0);
		}
		
		return null;
	}

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

}

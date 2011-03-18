/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.User;

/**
 * @author huanpham
 *
 */
public interface UserDao {

	void save(User user);
	void update(User user);
	void delete(User user);
	List<User> findAll();
	User findByIdAndPass(String id, String password);

}

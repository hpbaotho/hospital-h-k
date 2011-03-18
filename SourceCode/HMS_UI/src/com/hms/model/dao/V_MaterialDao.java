/**
 * 
 */
package com.hms.model.dao;

import java.util.List;

import com.hms.model.entity.V_Material;

/**
 * @author huanpham
 *
 */
public interface V_MaterialDao {

	void save(V_Material material);
	void update(V_Material material);
	void delete(V_Material material);
	List<V_Material> findAll();
	List<V_Material> findByType(String type);
	V_Material findById(String id);

}

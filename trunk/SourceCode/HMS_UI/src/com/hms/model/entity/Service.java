/**
 * 
 */
package com.hms.model.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author huanpham
 *
 */
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int serviceNo;
	private String patientID;
	private String deptID;
	private double price;
	private String register;
	private String updater;
	private Date registerDate;
	private Date updateDate;
	private String recordStatus;
	
	/**
	 * @return the serviceNo
	 */
	public int getServiceNo() {
		return serviceNo;
	}
	/**
	 * @param serviceNo the serviceNo to set
	 */
	public void setServiceNo(int serviceNo) {
		this.serviceNo = serviceNo;
	}
	/**
	 * @return the patientID
	 */
	public String getPatientID() {
		return patientID;
	}
	/**
	 * @param patientID the patientID to set
	 */
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	/**
	 * @return the deptID
	 */
	public String getDeptID() {
		return deptID;
	}
	/**
	 * @param deptID the deptID to set
	 */
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the register
	 */
	public String getRegister() {
		return register;
	}
	/**
	 * @param register the register to set
	 */
	public void setRegister(String register) {
		this.register = register;
	}
	/**
	 * @return the updater
	 */
	public String getUpdater() {
		return updater;
	}
	/**
	 * @param updater the updater to set
	 */
	public void setUpdater(String updater) {
		this.updater = updater;
	}
	/**
	 * @return the registerDate
	 */
	public Date getRegisterDate() {
		return registerDate;
	}
	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the recordStatus
	 */
	public String getRecordStatus() {
		return recordStatus;
	}
	/**
	 * @param recordStatus the recordStatus to set
	 */
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
}

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
public class Medicine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String medicineID;
	private String medicineName;
	private String groupID;
	private String parameter;
	private double price;
	private double cost;
	private String unit;
	private String manufacturer;
	private double wholeSalePrice;
	private double insurancePrice;
	
	private String register;
	private String updater;
	private Date registerDate;
	private Date updateDate;
	private String recordStatus;
	/**
	 * @return the medicineID
	 */
	public String getMedicineID() {
		return medicineID;
	}
	/**
	 * @param medicineID the medicineID to set
	 */
	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}
	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}
	/**
	 * @param medicineName the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	/**
	 * @return the groupID
	 */
	public String getGroupID() {
		return groupID;
	}
	/**
	 * @param groupID the groupID to set
	 */
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	/**
	 * @return the parameter
	 */
	public String getParameter() {
		return parameter;
	}
	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(String parameter) {
		this.parameter = parameter;
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
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return the wholeSalePrice
	 */
	public double getWholeSalePrice() {
		return wholeSalePrice;
	}
	/**
	 * @param wholeSalePrice the wholeSalePrice to set
	 */
	public void setWholeSalePrice(double wholeSalePrice) {
		this.wholeSalePrice = wholeSalePrice;
	}
	/**
	 * @return the insurancePrice
	 */
	public double getInsurancePrice() {
		return insurancePrice;
	}
	/**
	 * @param insurancePrice the insurancePrice to set
	 */
	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
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

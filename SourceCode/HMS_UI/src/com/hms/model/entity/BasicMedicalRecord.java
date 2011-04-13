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
public class BasicMedicalRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String basicRecordID;
	private String patientID;
	private double pulse;
	private double temperature;
	private double breathing;
	private double bloodPressure;
	private double height;
	private double weight;
	
	private String register;
	private String updater;
	private Date registerDate;
	private Date updateDate;
	private String recordStatus;
	
	
	/**
	 * @return the basicRecordID
	 */
	public String getBasicRecordID() {
		return basicRecordID;
	}
	/**
	 * @param basicRecordID the basicRecordID to set
	 */
	public void setBasicRecordID(String basicRecordID) {
		this.basicRecordID = basicRecordID;
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
	 * @return the pulse
	 */
	public double getPulse() {
		return pulse;
	}
	/**
	 * @param pulse the pulse to set
	 */
	public void setPulse(double pulse) {
		this.pulse = pulse;
	}
	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the breathing
	 */
	public double getBreathing() {
		return breathing;
	}
	/**
	 * @param breathing the breathing to set
	 */
	public void setBreathing(double breathing) {
		this.breathing = breathing;
	}
	/**
	 * @return the bloodPressure
	 */
	public double getBloodPressure() {
		return bloodPressure;
	}
	/**
	 * @param bloodPressure the bloodPressure to set
	 */
	public void setBloodPressure(double bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
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

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
public class MedicalRecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String recordID;
	private String patientID;
	private String doctorID;
	private String deptID;
	private String basicRecordID;
	private String clinicalSymptoms;
	private String preDiagnosis;
	private String diagnosis;
	
	private String register;
	private String updater;
	private Date registerDate;
	private Date updateDate;
	private String recordStatus;
	/**
	 * @return the recordID
	 */
	public String getRecordID() {
		return recordID;
	}
	/**
	 * @param recordID the recordID to set
	 */
	public void setRecordID(String recordID) {
		this.recordID = recordID;
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
	 * @return the doctorID
	 */
	public String getDoctorID() {
		return doctorID;
	}
	/**
	 * @param doctorID the doctorID to set
	 */
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
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
	 * @return the clinicalSymptoms
	 */
	public String getClinicalSymptoms() {
		return clinicalSymptoms;
	}
	/**
	 * @param clinicalSymptoms the clinicalSymptoms to set
	 */
	public void setClinicalSymptoms(String clinicalSymptoms) {
		this.clinicalSymptoms = clinicalSymptoms;
	}
	/**
	 * @return the preDiagnosis
	 */
	public String getPreDiagnosis() {
		return preDiagnosis;
	}
	/**
	 * @param preDiagnosis the preDiagnosis to set
	 */
	public void setPreDiagnosis(String preDiagnosis) {
		this.preDiagnosis = preDiagnosis;
	}
	/**
	 * @return the diagnosis
	 */
	public String getDiagnosis() {
		return diagnosis;
	}
	/**
	 * @param diagnosis the diagnosis to set
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
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

/**
 * 
 */
package com.hms.model.entity;

/**
 * @author huanpham
 *
 */
public class Item {
	
	private String label = "";
	private String value = "";
	
	public Item() {
		this.label = "";
		this.value = "";
	}
	
	public Item(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}

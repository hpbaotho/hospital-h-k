/**
 * 
 */
package com.hms.util;

import java.util.List;

import com.hms.model.entity.Item;

/**
 * @author huanpham
 *
 */
public class MessageBuilder {
	public static final String buildFooter(List<Item> lstItems) {
		String strResult = "";
		
		if (lstItems != null && lstItems.size() > 0) {
			strResult = lstItems.get(0).getLabel() + " <" + lstItems.get(0).getValue() + ">";
		} else {
			return strResult;
		}
		
		for (int i = 1; i < lstItems.size(); i++) {
			strResult += " - ";
			strResult += lstItems.get(i).getLabel() + " <" + lstItems.get(i).getValue() + ">";
		}
		
		return strResult;
	}
}

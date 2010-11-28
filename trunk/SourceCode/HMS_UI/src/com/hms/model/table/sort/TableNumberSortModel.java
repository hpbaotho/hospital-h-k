/**
 * 
 */
package com.hms.model.table.sort;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author huanpham
 *
 */
public class TableNumberSortModel implements Listener {

		private Table table = null;
		
		/**
		 * 
		 */
		public TableNumberSortModel(Table table) {
			this.table = table;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
		 */
		@Override
		public void handleEvent(Event event) {
			TableItem[] items = table.getItems();
	        TableColumn currentCol = ((TableColumn) event.widget);
	        int index = 0;
	        
	        for (int i = 1; i < table.getColumnCount(); i++) {
	        	if (currentCol == table.getColumn(i)) {
	        		index = i;
	        		break;
	        	}
	        }
	        
	        if (index == 0) {
	        	return;
	        }
	        
	        if (table.getSortDirection() == SWT.UP) {
		        for (int i = 1; i < items.length; i++) {
		          double value1 = Double.parseDouble(items[i].getText(index));
		          for (int j = 0; j < i; j++) {
		            double value2 = Double.parseDouble(items[j].getText(index));
		            if (value1 < value2) {
		              String[] values = { items[i].getText(0),
		                  items[i].getText(1), items[i].getText(2), items[i].getText(3), items[i].getText(4), items[i].getText(5), items[i].getText(6) };
		              items[i].dispose();
		              TableItem item = new TableItem(table, SWT.NONE, j);
		              item.setText(values);
		              items = table.getItems();
		              break;
		            }
		          }
		        }
		        table.setSortDirection(SWT.DOWN);
	        } else {
	        	for (int i = 1; i < items.length; i++) {
	        		double value1 = Double.parseDouble(items[i].getText(index));
	        		for (int j = 0; j < i; j++) {
		            	double value2 = Double.parseDouble(items[j].getText(index));
		            	if (value1 > value2) {
		            		String[] values = { items[i].getText(0),
					                  items[i].getText(1), items[i].getText(2), items[i].getText(3), items[i].getText(4), items[i].getText(5), items[i].getText(6)};
			              	items[i].dispose();
			              	TableItem item = new TableItem(table, SWT.NONE, j);
			              	item.setText(values);
			              	items = table.getItems();
			              	break;
			            }
		          	}
	        	}
	        	table.setSortDirection(SWT.UP);
	        }
	        table.setSortColumn((TableColumn) event.widget);
		}

	}

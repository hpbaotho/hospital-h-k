package com.hms.form;


import net.sf.swtaddons.autocomplete.combo.AutocompleteComboSelector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.hms.model.table.sort.TableNumberSortModel;
import com.hms.model.table.sort.TableTextSortModel;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MSSearchShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MSSearchShell shell = new MSSearchShell(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public MSSearchShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(MSSearchShell.class, "/com/hms/icon/hms-tablet-icon.png"));
		setLayout(null);
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 10, 872, 119);
		composite.setLayout(null);
		
		Button button = new Button(composite, SWT.CHECK);
		button.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button.setBounds(10, 10, 182, 16);
		button.setText(Messages.getString("HMS.MSSearchShell.label.m_s_group"));
		
		Button button_1 = new Button(composite, SWT.CHECK);
		button_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_1.setText(Messages.getString("HMS.MSSearchShell.label.m_s_name"));
		button_1.setBounds(10, 32, 182, 16);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(198, 34, 228, 19);
		
		Button button_2 = new Button(composite, SWT.CHECK);
		button_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_2.setText(Messages.getString("HMS.MSSearchShell.label.m_s_code"));
		button_2.setBounds(10, 57, 182, 16);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(198, 59, 228, 19);
		
		Button button_3 = new Button(composite, SWT.CHECK);
		button_3.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_3.setText(Messages.getString("HMS.MSSearchShell.label.parameter"));
		button_3.setBounds(10, 82, 182, 16);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(198, 84, 228, 19);
		
		Button button_4 = new Button(composite, SWT.CHECK);
		button_4.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_4.setText(Messages.getString("HMS.MSSearchShell.label.whole_sale_price_from"));
		button_4.setBounds(457, 10, 116, 16);
		
		Spinner spinner = new Spinner(composite, SWT.BORDER);
		spinner.setBounds(589, 10, 83, 21);
		
		Spinner spinner_1 = new Spinner(composite, SWT.BORDER);
		spinner_1.setBounds(751, 10, 83, 21);
		
		Label label = new Label(composite, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(696, 10, 49, 21);
		label.setText(Messages.getString("HMS.MSSearchShell.label.to"));
		
		Button button_5 = new Button(composite, SWT.CHECK);
		button_5.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_5.setText(Messages.getString("HMS.MSSearchShell.label.retail_price_from"));
		button_5.setBounds(457, 35, 116, 16);
		
		Spinner spinner_2 = new Spinner(composite, SWT.BORDER);
		spinner_2.setBounds(589, 35, 83, 21);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_1.setText(Messages.getString("HMS.MSSearchShell.label.to"));
		label_1.setBounds(696, 35, 49, 21);
		
		Spinner spinner_3 = new Spinner(composite, SWT.BORDER);
		spinner_3.setBounds(751, 35, 83, 21);
		
		Button button_6 = new Button(composite, SWT.NONE);
		button_6.setImage(SWTResourceManager.getImage(MSSearchShell.class, "/com/hms/icon/hms-search-icon.png"));
		button_6.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_6.setBounds(432, 69, 130, 36);
		button_6.setText(Messages.getString("HMS.MSSearchShell.button.search"));
		
		Button button_7 = new Button(composite, SWT.NONE);
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_7.setImage(SWTResourceManager.getImage(MSSearchShell.class, "/com/hms/icon/hms-accept-icon.png"));
		button_7.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_7.setBounds(568, 69, 130, 36);
		button_7.setText(Messages.getString("HMS.MSSearchShell.button.m_s_select"));
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setItems(new String[] {"Medicine1", "Medicine2", "aaa", "đfd", "dđ", "êtttt", "ffffffffffff", "hhhhhhhhhhhh", "jjjjjjjjjjj", "kkkkkkkk", "llllllll", "iuiiii", "iiii", "oopp"});
		combo.setBounds(198, 10, 228, 21);
		new AutocompleteComboSelector(combo);
		
		Button button_8 = new Button(composite, SWT.NONE);
		button_8.setText(Messages.getString("HMS.MSSearchShell.button.exit"));
		button_8.setImage(SWTResourceManager.getImage(MSSearchShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		button_8.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_8.setBounds(704, 69, 130, 36);
		
		Composite composite_1 = new Composite(this, SWT.BORDER);
		composite_1.setBounds(10, 135, 872, 525);
		composite_1.setLayout(null);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(0, 0, 868, 521);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(0);
		tableColumn.setText("New Column");

		TableColumn tblclmnA = new TableColumn(table, SWT.CENTER);
		tblclmnA.setWidth(160);
		tblclmnA.setText(Messages.getString("HMS.MSSearchShell.table.col.m_s_code"));
		
		TableColumn tblclmnB = new TableColumn(table, SWT.CENTER);
		tblclmnB.setWidth(191);
		tblclmnB.setText(Messages.getString("HMS.MSSearchShell.table.col.m_s_name"));
		
		TableColumn tblclmnC = new TableColumn(table, SWT.CENTER);
		tblclmnC.setWidth(107);
		tblclmnC.setText(Messages.getString("HMS.MSSearchShell.table.col.unit"));
		
		TableColumn tblclmnD = new TableColumn(table, SWT.CENTER);
		tblclmnD.setWidth(132);
		tblclmnD.setText(Messages.getString("HMS.MSSearchShell.table.col.price"));
		
		TableColumn tblclmnE = new TableColumn(table, SWT.CENTER);
		tblclmnE.setWidth(142);
		tblclmnE.setText(Messages.getString("HMS.MSSearchShell.table.col.insurance_price"));
		
		TableColumn tblclmnF = new TableColumn(table, SWT.CENTER);
		tblclmnF.setWidth(121);
		tblclmnF.setText(Messages.getString("HMS.MSSearchShell.table.col.ingredient"));
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(1, "KSDHT");
		tableItem.setText(2, "Cay - KSD(HT)");
		tableItem.setText(3, "lan");
		tableItem.setText(4, "130000");
		tableItem.setText(5, "100000");
		tableItem.setText(6, "aaaa");
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText(1, "KSDP");
		tableItem_1.setText(2, "Cay - KSD Phan");
		tableItem_1.setText(3, "lan");
		tableItem_1.setText(4, "120000");
		tableItem_1.setText(5, "100000");
		tableItem_1.setText(6, "bb");
		
		Listener textSortListener = new TableTextSortModel(this.table);
		Listener numberSortListener = new TableNumberSortModel(this.table);
		
		tblclmnA.addListener(SWT.Selection, textSortListener);
		tblclmnB.addListener(SWT.Selection, textSortListener);
		tblclmnC.addListener(SWT.Selection, textSortListener);
		tblclmnD.addListener(SWT.Selection, numberSortListener);
		tblclmnE.addListener(SWT.Selection, numberSortListener);
		tblclmnF.addListener(SWT.Selection, textSortListener);
		table.setSortColumn(tblclmnA);
		//table.setSortDirection(SWT.UP);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.MSSearchShell.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

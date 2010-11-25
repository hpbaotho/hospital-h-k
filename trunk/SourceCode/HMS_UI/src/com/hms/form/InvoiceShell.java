package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;

public class InvoiceShell extends Shell {
	private Text text;
	private Text text_2;
	private Text text_4;
	private Text text_5;
	private Table table;
	private Text text_1;
	private Text text_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			InvoiceShell shell = new InvoiceShell(display);
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
	public InvoiceShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(InvoiceShell.class, "/com/hms/icon/hms-invoice-io-icon.png"));
		
		Group grpImportInvoiceInformation = new Group(this, SWT.SHADOW_ETCHED_IN);
		grpImportInvoiceInformation.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpImportInvoiceInformation.setToolTipText("");
		grpImportInvoiceInformation.setText("Patient information");
		grpImportInvoiceInformation.setBounds(10, 10, 872, 147);
		
		Label lblInvoiceNumber = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblInvoiceNumber.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInvoiceNumber.setBounds(10, 34, 130, 21);
		lblInvoiceNumber.setText("Patient ID");
		
		text = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text.setBounds(146, 34, 200, 21);
		
		Label lblWarehouse = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblWarehouse.setText("Day of birth");
		lblWarehouse.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWarehouse.setBounds(10, 88, 130, 21);
		
		text_2 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_2.setBounds(146, 88, 200, 21);
		
		Label lblTotal = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblTotal.setText("Date");
		lblTotal.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTotal.setBounds(10, 115, 130, 21);
		
		text_4 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_4.setBounds(511, 35, 200, 21);
		
		Label lblAddress = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblAddress.setText("Address");
		lblAddress.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblAddress.setBounds(10, 61, 100, 21);
		
		text_5 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_5.setBounds(146, 61, 479, 21);
		
		Label lblDate = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblDate.setText("Pattient name");
		lblDate.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblDate.setBounds(405, 34, 100, 21);
		
		CalendarCombo calendarCombo = new CalendarCombo(grpImportInvoiceInformation, SWT.NONE);
		calendarCombo.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		calendarCombo.setBounds(146, 115, 114, 21);
		
		Label lblPrice = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblPrice.setText("Sex");
		lblPrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPrice.setBounds(405, 88, 58, 21);
		
		Button btnMale = new Button(grpImportInvoiceInformation, SWT.RADIO);
		btnMale.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		btnMale.setBounds(489, 87, 58, 21);
		btnMale.setText("Male");
		
		Button btnFemale = new Button(grpImportInvoiceInformation, SWT.RADIO);
		btnFemale.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		btnFemale.setText("Female");
		btnFemale.setBounds(553, 88, 72, 21);
		
		Button btnResident = new Button(grpImportInvoiceInformation, SWT.CHECK);
		btnResident.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		btnResident.setBounds(266, 115, 80, 21);
		btnResident.setText("Resident");
		
		Label lblRoom = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblRoom.setText("Room");
		lblRoom.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblRoom.setBounds(367, 115, 58, 21);
		
		Label lblBed = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblBed.setText("Bed");
		lblBed.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblBed.setBounds(553, 115, 49, 21);
		
		Combo combo = new Combo(grpImportInvoiceInformation, SWT.NONE);
		combo.setBounds(431, 115, 103, 21);
		
		Combo combo_1 = new Combo(grpImportInvoiceInformation, SWT.NONE);
		combo_1.setBounds(608, 115, 103, 21);
		
		Group grpMedicineMenu = new Group(this, SWT.NONE);
		grpMedicineMenu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpMedicineMenu.setText("Medicine menu");
		grpMedicineMenu.setBounds(10, 163, 872, 354);
		
		table = new Table(grpMedicineMenu, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(10, 24, 834, 322);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("New Column");
		
		TableColumn tblclmnName = new TableColumn(table, SWT.CENTER);
		tblclmnName.setWidth(100);
		tblclmnName.setText("ID");
		
		TableColumn tblclmnName_1 = new TableColumn(table, SWT.CENTER);
		tblclmnName_1.setWidth(218);
		tblclmnName_1.setText("Name");
		
		TableColumn tblclmnUnit = new TableColumn(table, SWT.CENTER);
		tblclmnUnit.setWidth(82);
		tblclmnUnit.setText("Unit");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(161);
		tblclmnPrice.setText("Price");
		
		TableColumn tblclmnQuantity = new TableColumn(table, SWT.CENTER);
		tblclmnQuantity.setWidth(81);
		tblclmnQuantity.setText("Quantity");
		
		TableColumn tblclmnTotal = new TableColumn(table, SWT.CENTER);
		tblclmnTotal.setWidth(185);
		tblclmnTotal.setText("Total");
		
		ToolBar toolBar = new ToolBar(grpMedicineMenu, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setBounds(844, 24, 24, 44);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setImage(SWTResourceManager.getImage(InvoiceShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(InvoiceShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setImage(SWTResourceManager.getImage(InvoiceShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnSave.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnSave.setBounds(545, 614, 134, 46);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.setImage(SWTResourceManager.getImage(InvoiceShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnCancel.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnCancel.setBounds(710, 614, 134, 46);
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 523, 872, 85);
		
		Label lblTotal_1 = new Label(composite, SWT.NONE);
		lblTotal_1.setText("Total");
		lblTotal_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTotal_1.setBounds(10, 10, 130, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(146, 10, 200, 21);
		
		Label lblInsurance = new Label(composite, SWT.NONE);
		lblInsurance.setText("Insurance");
		lblInsurance.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInsurance.setBounds(10, 37, 130, 21);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(146, 37, 200, 21);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Invoice");
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

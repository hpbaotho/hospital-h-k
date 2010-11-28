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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EXInvoiceShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			EXInvoiceShell shell = new EXInvoiceShell(display);
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
	public EXInvoiceShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(EXInvoiceShell.class, "/com/hms/icon/hms-invoice-io-icon.png"));
		
		Group grpImportInvoiceInformation = new Group(this, SWT.SHADOW_ETCHED_IN);
		grpImportInvoiceInformation.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpImportInvoiceInformation.setToolTipText("");
		grpImportInvoiceInformation.setText("Export invoice information");
		grpImportInvoiceInformation.setBounds(10, 10, 872, 238);
		
		Label lblInvoiceNumber = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblInvoiceNumber.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInvoiceNumber.setBounds(10, 34, 130, 21);
		lblInvoiceNumber.setText("Invoice number");
		
		text = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text.setBounds(146, 34, 200, 21);
		
		Label lblSupplier = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblSupplier.setText("Customer");
		lblSupplier.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblSupplier.setBounds(10, 61, 130, 21);
		
		text_1 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_1.setBounds(146, 61, 200, 21);
		
		Label lblWarehouse = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblWarehouse.setText("Warehouse");
		lblWarehouse.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWarehouse.setBounds(10, 88, 130, 21);
		
		text_2 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_2.setBounds(146, 88, 200, 21);
		
		Label lblTax = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblTax.setText("Tax");
		lblTax.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTax.setBounds(10, 115, 130, 21);
		
		text_3 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_3.setBounds(146, 115, 200, 21);
		
		Label lblTotal = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblTotal.setText("Total");
		lblTotal.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTotal.setBounds(10, 142, 130, 21);
		
		text_4 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_4.setBounds(146, 142, 200, 21);
		
		Label lblAddress = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblAddress.setText("Address");
		lblAddress.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblAddress.setBounds(405, 61, 100, 21);
		
		text_5 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_5.setBounds(511, 62, 200, 21);
		
		Label lblDate = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblDate.setText("Date");
		lblDate.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblDate.setBounds(405, 34, 100, 21);
		
		CalendarCombo calendarCombo = new CalendarCombo(grpImportInvoiceInformation, SWT.NONE);
		calendarCombo.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		calendarCombo.setBounds(511, 34, 114, 21);
		
		Label lblPrice = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPrice.setBounds(405, 115, 100, 21);
		
		text_6 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_6.setBounds(511, 116, 200, 21);
		
		Label lblPrepay = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblPrepay.setText("Prepay");
		lblPrepay.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPrepay.setBounds(405, 142, 100, 21);
		
		text_7 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_7.setBounds(511, 143, 200, 21);
		
		Label lblNotices = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblNotices.setText("Notices");
		lblNotices.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNotices.setBounds(10, 169, 130, 21);
		
		text_8 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_8.setBounds(146, 169, 565, 59);
		
		Group grpMedicineMenu = new Group(this, SWT.NONE);
		grpMedicineMenu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpMedicineMenu.setText("Medicine menu");
		grpMedicineMenu.setBounds(10, 254, 872, 354);
		
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
		toolItem.setImage(SWTResourceManager.getImage(EXInvoiceShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(EXInvoiceShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setImage(SWTResourceManager.getImage(EXInvoiceShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnSave.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnSave.setBounds(545, 614, 134, 46);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnCancel.setText("Cancel");
		btnCancel.setImage(SWTResourceManager.getImage(EXInvoiceShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnCancel.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnCancel.setBounds(710, 614, 134, 46);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Export Invoice");
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

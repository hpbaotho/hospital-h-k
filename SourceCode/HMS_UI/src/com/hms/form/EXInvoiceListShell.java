package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import com.hms.bundle.Messages;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EXInvoiceListShell extends Shell {
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			EXInvoiceListShell shell = new EXInvoiceListShell(display);
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
	public EXInvoiceListShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(EXInvoiceListShell.class, "/com/hms/icon/hms-invoice-io-icon.png"));
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 10, 872, 650);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(0, 0, 868, 584);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("New Column");
		
		TableColumn tblclmnDate = new TableColumn(table, SWT.CENTER);
		tblclmnDate.setWidth(116);
		tblclmnDate.setText("Date");
		
		TableColumn tblclmnInvoiceNumber = new TableColumn(table, SWT.CENTER);
		tblclmnInvoiceNumber.setWidth(122);
		tblclmnInvoiceNumber.setText("Invoice Number");
		
		TableColumn tblclmnSupplier = new TableColumn(table, SWT.CENTER);
		tblclmnSupplier.setWidth(133);
		tblclmnSupplier.setText("Customer");
		
		TableColumn tblclmnAddress = new TableColumn(table, SWT.CENTER);
		tblclmnAddress.setWidth(338);
		tblclmnAddress.setText("Address");
		
		TableColumn tblclmnWarehouse = new TableColumn(table, SWT.CENTER);
		tblclmnWarehouse.setWidth(154);
		tblclmnWarehouse.setText("Warehouse");
		
		Button btnAdd = new Button(composite, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EXInvoiceShell exInvoice = new EXInvoiceShell(getDisplay());
				exInvoice.setLocation(250, 50);
				exInvoice.open();
				exInvoice.layout();
			}
		});
		btnAdd.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnAdd.setImage(SWTResourceManager.getImage(EXInvoiceListShell.class, "/com/hms/icon/hms-add-icon.png"));
		btnAdd.setBounds(236, 590, 133, 46);
		btnAdd.setText("Add");
		
		Button btnEdit = new Button(composite, SWT.NONE);
		btnEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EXInvoiceShell exInvoice = new EXInvoiceShell(getDisplay());
				exInvoice.setLocation(250, 50);
				exInvoice.open();
				exInvoice.layout();
			}
		});
		btnEdit.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnEdit.setText("Edit");
		btnEdit.setImage(SWTResourceManager.getImage(EXInvoiceListShell.class, "/com/hms/icon/hms-edit-icon.png"));
		btnEdit.setBounds(394, 590, 133, 46);
		
		Button btnExit = new Button(composite, SWT.NONE);
		btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnExit.setText("Exit");
		btnExit.setImage(SWTResourceManager.getImage(EXInvoiceListShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnExit.setBounds(709, 590, 133, 46);
		
		Button btnDelete = new Button(composite, SWT.NONE);
		btnDelete.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnDelete.setText("Delete");
		btnDelete.setImage(SWTResourceManager.getImage(EXInvoiceListShell.class, "/com/hms/icon/hms-delete-icon.png"));
		btnDelete.setBounds(552, 590, 133, 46);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.EXInvoiceListShell.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

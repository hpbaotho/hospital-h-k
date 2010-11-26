package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PatientListShell extends Shell {
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PatientListShell shell = new PatientListShell(display);
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
	public PatientListShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(PatientListShell.class, "/com/hms/icon/hms-patient-icon.png"));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBounds(10, 10, 872, 650);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 852, 563);
		table.setLinesVisible(true);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setHeaderVisible(true);
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setText("New Column");
		
		TableColumn tblclmnMBnhNhn = new TableColumn(table, SWT.CENTER);
		tblclmnMBnhNhn.setWidth(108);
		tblclmnMBnhNhn.setText(Messages.getString("HMS.PatientManagementShell.table.header.id"));
		
		TableColumn tblclmnHTn = new TableColumn(table, SWT.CENTER);
		tblclmnHTn.setWidth(212);
		tblclmnHTn.setText(Messages.getString("HMS.PatientManagementShell.table.header.name"));
		
		TableColumn tblclmnNgySinh = new TableColumn(table, SWT.CENTER);
		tblclmnNgySinh.setWidth(100);
		tblclmnNgySinh.setText(Messages.getString("HMS.PatientManagementShell.table.header.day_of_birth"));
		
		TableColumn tblclmnGiiTnh = new TableColumn(table, SWT.CENTER);
		tblclmnGiiTnh.setWidth(88);
		tblclmnGiiTnh.setText(Messages.getString("HMS.PatientManagementShell.table.header.sex"));
		
		TableColumn tblclmnaCh = new TableColumn(table, SWT.CENTER);
		tblclmnaCh.setWidth(340);
		tblclmnaCh.setText(Messages.getString("HMS.PatientManagementShell.table.header.address"));
		
		Button button = new Button(composite_1, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PatientShell patient = new PatientShell(getDisplay());
				patient.setLocation(250, 50);
				patient.open();
				patient.layout();
			}
		});
		button.setText("Add");
		button.setImage(SWTResourceManager.getImage(PatientListShell.class, "/com/hms/icon/hms-add-icon.png"));
		button.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button.setBounds(256, 594, 133, 46);
		
		Button button_1 = new Button(composite_1, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PatientShell patient = new PatientShell(getDisplay());
				patient.setLocation(250, 50);
				patient.open();
				patient.layout();
			}
		});
		button_1.setText("Edit");
		button_1.setImage(SWTResourceManager.getImage(PatientListShell.class, "/com/hms/icon/hms-edit-icon.png"));
		button_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_1.setBounds(414, 594, 133, 46);
		
		Button button_2 = new Button(composite_1, SWT.NONE);
		button_2.setText("Delete");
		button_2.setImage(SWTResourceManager.getImage(PatientListShell.class, "/com/hms/icon/hms-delete-icon.png"));
		button_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_2.setBounds(572, 594, 133, 46);
		
		Button button_3 = new Button(composite_1, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		button_3.setText("Exit");
		button_3.setImage(SWTResourceManager.getImage(PatientListShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		button_3.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_3.setBounds(729, 594, 133, 46);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.PatientManagementShell.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

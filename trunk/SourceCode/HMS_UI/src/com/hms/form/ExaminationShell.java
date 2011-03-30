package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;

public class ExaminationShell extends Shell {
	private Table table_1;
	private Text txtPatientID;
	private Text txtPatientName;
	private Text txtPatientSex;
	private Text txtPatientAge;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ExaminationShell shell = new ExaminationShell(display);
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
	public ExaminationShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(ExaminationShell.class, "/com/hms/icon/hms-invoice-io-icon.png"));
		
		Group grpImportInvoiceInformation = new Group(this, SWT.SHADOW_ETCHED_IN);
		grpImportInvoiceInformation.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpImportInvoiceInformation.setToolTipText("");
		grpImportInvoiceInformation.setText("Information");
		grpImportInvoiceInformation.setBounds(10, 10, 922, 210);
		
		Label lblInvoiceNumber = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblInvoiceNumber.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInvoiceNumber.setBounds(10, 29, 100, 21);
		lblInvoiceNumber.setText("Department");
		
		Label label_1 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR);
		label_1.setBounds(328, 10, 2, 199);
		
		Label label_3 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(0, 84, 330, 2);
		
		Combo cmbDepartment = new Combo(grpImportInvoiceInformation, SWT.NONE);
		cmbDepartment.setBounds(116, 29, 200, 21);
		
		Label label = new Label(grpImportInvoiceInformation, SWT.NONE);
		label.setText("Doctor");
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(10, 57, 100, 21);
		
		Combo cmbDoctor = new Combo(grpImportInvoiceInformation, SWT.NONE);
		cmbDoctor.setBounds(116, 57, 200, 21);
		
		table_1 = new Table(grpImportInvoiceInformation, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(0, 84, 330, 125);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(table_1, SWT.NONE);
		tblclmnId.setWidth(90);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnName = new TableColumn(table_1, SWT.NONE);
		tblclmnName.setWidth(82);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnSex = new TableColumn(table_1, SWT.NONE);
		tblclmnSex.setWidth(76);
		tblclmnSex.setText("Sex");
		
		TableColumn tblclmnAge = new TableColumn(table_1, SWT.NONE);
		tblclmnAge.setWidth(73);
		tblclmnAge.setText("Age");
		
		Label lblMedicalCode = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblMedicalCode.setText("Patient ID");
		lblMedicalCode.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicalCode.setBounds(336, 29, 109, 21);
		
		txtPatientID = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientID.setEditable(false);
		txtPatientID.setBounds(451, 30, 164, 21);
		
		Label lblPatientName = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblPatientName.setText("Patient name");
		lblPatientName.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPatientName.setBounds(336, 56, 109, 21);
		
		txtPatientName = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientName.setEditable(false);
		txtPatientName.setBounds(451, 57, 164, 21);
		
		txtPatientSex = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientSex.setEditable(false);
		txtPatientSex.setBounds(451, 84, 62, 21);
		
		Label lblSex = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblSex.setText("Sex");
		lblSex.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblSex.setBounds(336, 84, 39, 21);
		
		txtPatientAge = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientAge.setEditable(false);
		txtPatientAge.setBounds(451, 111, 62, 21);
		
		Label lblAge = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblAge.setText("Age");
		lblAge.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblAge.setBounds(336, 111, 39, 21);
		
		Label label_2 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_2.setText("Pulse");
		label_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_2.setBounds(334, 151, 89, 21);
		
		Label label_5 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_5.setText("Temperature");
		label_5.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_5.setBounds(334, 178, 92, 21);
		
		text_4 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_4.setEditable(false);
		text_4.setBounds(429, 179, 79, 21);
		
		text_5 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_5.setEditable(false);
		text_5.setBounds(429, 152, 79, 21);
		
		Label label_6 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_6.setText("Breathing");
		label_6.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_6.setBounds(514, 150, 101, 21);
		
		Label label_7 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_7.setText("Blood pressure");
		label_7.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_7.setBounds(514, 177, 101, 21);
		
		text_6 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_6.setEditable(false);
		text_6.setBounds(621, 179, 79, 21);
		
		text_8 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_8.setEditable(false);
		text_8.setBounds(621, 152, 79, 21);
		
		Label label_8 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_8.setText("Height");
		label_8.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_8.setBounds(712, 151, 89, 21);
		
		Label label_9 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_9.setText("Weight");
		label_9.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_9.setBounds(712, 178, 92, 21);
		
		text_9 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_9.setEditable(false);
		text_9.setBounds(807, 152, 79, 21);
		
		text_10 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_10.setEditable(false);
		text_10.setBounds(807, 179, 79, 21);
		
		Label label_10 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(328, 138, 594, 2);
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setImage(SWTResourceManager.getImage(ExaminationShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnSave.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnSave.setBounds(545, 631, 134, 29);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnCancel.setText("Cancel");
		btnCancel.setImage(SWTResourceManager.getImage(ExaminationShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnCancel.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnCancel.setBounds(710, 631, 134, 29);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 226, 922, 399);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmExamination = new CTabItem(tabFolder, SWT.NONE);
		tbtmExamination.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tbtmExamination.setText("Examination");
		
		tabFolder.setSelection(tbtmExamination);
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmExamination.setControl(composite);
		
		text = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		text.setBounds(175, 11, 731, 69);
		
		Label lblClinicalSympto = new Label(composite, SWT.NONE);
		lblClinicalSympto.setText("Clinical Symptoms");
		lblClinicalSympto.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblClinicalSympto.setBounds(10, 10, 159, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(175, 87, 731, 21);
		
		Label lblPreliminary = new Label(composite, SWT.NONE);
		lblPreliminary.setText("Preliminary diagnosis");
		lblPreliminary.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPreliminary.setBounds(10, 86, 159, 21);
		
		text_2 = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		text_2.setBounds(175, 115, 731, 172);
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("Clinical Symptoms");
		label_4.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_4.setBounds(10, 114, 159, 21);
		
		CTabItem tbtmPrescription = new CTabItem(tabFolder, SWT.NONE);
		tbtmPrescription.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tbtmPrescription.setText("Prescription");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmPrescription.setControl(composite_1);
		
		Label label_11 = new Label(composite_1, SWT.NONE);
		label_11.setText("Medicine name");
		label_11.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_11.setBounds(10, 11, 109, 21);
		
		text_3 = new Text(composite_1, SWT.BORDER);
		text_3.setBounds(125, 12, 177, 21);
		
		Button button = new Button(composite_1, SWT.NONE);
		button.setText("...");
		button.setBounds(308, 10, 29, 23);
		
		Label label_12 = new Label(composite_1, SWT.NONE);
		label_12.setText("Morning");
		label_12.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_12.setBounds(343, 12, 69, 21);
		
		Spinner spinner = new Spinner(composite_1, SWT.BORDER);
		spinner.setBounds(428, 10, 47, 21);
		
		Label label_13 = new Label(composite_1, SWT.NONE);
		label_13.setText("Afternoon");
		label_13.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_13.setBounds(481, 11, 69, 21);
		
		Spinner spinner_1 = new Spinner(composite_1, SWT.BORDER);
		spinner_1.setBounds(556, 10, 47, 21);
		
		Label label_14 = new Label(composite_1, SWT.NONE);
		label_14.setText("Evening");
		label_14.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_14.setBounds(481, 38, 69, 21);
		
		Spinner spinner_2 = new Spinner(composite_1, SWT.BORDER);
		spinner_2.setBounds(556, 37, 47, 21);
		
		Label label_15 = new Label(composite_1, SWT.NONE);
		label_15.setText("No of date");
		label_15.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_15.setBounds(343, 39, 69, 21);
		
		Spinner spinner_3 = new Spinner(composite_1, SWT.BORDER);
		spinner_3.setBounds(428, 38, 47, 21);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(10, 69, 834, 294);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("New Column");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("ID");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.CENTER);
		tableColumn_2.setWidth(218);
		tableColumn_2.setText("Name");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.CENTER);
		tableColumn_3.setWidth(82);
		tableColumn_3.setText("Unit");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.CENTER);
		tableColumn_4.setWidth(161);
		tableColumn_4.setText("Price");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.CENTER);
		tableColumn_5.setWidth(81);
		tableColumn_5.setText("Quantity");
		
		TableColumn tableColumn_6 = new TableColumn(table, SWT.CENTER);
		tableColumn_6.setWidth(185);
		tableColumn_6.setText("Total");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Examination");
		setSize(950, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

package com.hms.form;

import java.text.SimpleDateFormat;
import java.util.List;

import net.sf.swtaddons.autocomplete.combo.AutocompleteComboSelector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.form.lov.MedicineLOV;
import com.hms.model.dao.DepartmentDao;
import com.hms.model.dao.DoctorDao;
import com.hms.model.dao.PatientDao;
import com.hms.model.dao.ServiceDao;
import com.hms.model.entity.Department;
import com.hms.model.entity.Doctor;
import com.hms.model.entity.Patient;
import com.hms.model.entity.Service;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
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
import org.eclipse.nebula.widgets.tablecombo.TableCombo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class ExaminationShell extends Shell {
	private Table tblPatient;
	private Text txtPatientID;
	private Text txtPatientName;
	private Text txtPatientSex;
	private Text txtPatientAge;
	private Text text_4;
	private Text txtPulse;
	private Text text_6;
	private Text text_8;
	private Text text_9;
	private Text text_10;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Table table;
	private Combo cmbDepartment;
	private Combo cmbDoctor;
	
	//List
	private String[] lstDept = null;
	private String[] lstDeptID = null;
	private String[] lstDoctor = null;
	private String[] lstDoctorID = null;
	
	//Database context
	private ApplicationContext appContext = null;
	private DepartmentDao departmentDao = null;
	private DoctorDao doctorDao = null;
	private ServiceDao serviceDao = null;
	private PatientDao patientDao = null;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	//Boolean
	private boolean isEntered = false;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ExaminationShell shell = new ExaminationShell(display, SWT.SHELL_TRIM, new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml"));
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
	public ExaminationShell(Display display, int style, ApplicationContext appContext) {
		super(display, style);
		
		this.appContext = appContext;
		this.departmentDao = (DepartmentDao) appContext.getBean("departmentDao");
		this.doctorDao = (DoctorDao) appContext.getBean("doctorDao");
		this.serviceDao = (ServiceDao) appContext.getBean("serviceDao");
		this.patientDao = (PatientDao) appContext.getBean("patientDao");
		
		createContents();
		
		this.initial();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Examination");
		setSize(950, 700);
		setImage(SWTResourceManager.getImage(ExaminationShell.class, "/com/hms/icon/hms-invoice-io-icon.png"));
		
		Group grpImportInvoiceInformation = new Group(this, SWT.SHADOW_ETCHED_IN);
		grpImportInvoiceInformation.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpImportInvoiceInformation.setToolTipText("");
		grpImportInvoiceInformation.setText("Information");
		grpImportInvoiceInformation.setBounds(10, 10, 922, 210);
		
		Label lblInvoiceNumber = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblInvoiceNumber.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblInvoiceNumber.setBounds(10, 31, 100, 14);
		lblInvoiceNumber.setText("Department");
		
		Label label_1 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR);
		label_1.setBounds(328, 10, 2, 199);
		
		Label label_3 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(0, 84, 330, 2);
		
		cmbDepartment = new Combo(grpImportInvoiceInformation, SWT.NONE);
		cmbDepartment.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if (isEntered) {
					selectDepartment();
					isEntered = false;
				}
			}
		});
		cmbDepartment.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					isEntered = true;
				}
			}
		});
		cmbDepartment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Selection");
				selectDepartment();
			}
		});
		cmbDepartment.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

			}
		});

		cmbDepartment.setBounds(116, 29, 200, 21);
		//Auto combo
		new AutocompleteComboSelector(cmbDepartment);
		
		Label label = new Label(grpImportInvoiceInformation, SWT.NONE);
		label.setText("Doctor");
		label.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label.setBounds(10, 59, 100, 14);
		
		cmbDoctor = new Combo(grpImportInvoiceInformation, SWT.NONE);
		cmbDoctor.setBounds(116, 57, 200, 21);
		new AutocompleteComboSelector(cmbDoctor);
		
		tblPatient = new Table(grpImportInvoiceInformation, SWT.BORDER | SWT.FULL_SELECTION);
		tblPatient.setBounds(0, 84, 330, 125);
		tblPatient.setHeaderVisible(true);
		tblPatient.setLinesVisible(true);
		
		TableColumn tblclmnId = new TableColumn(tblPatient, SWT.NONE);
		tblclmnId.setWidth(90);
		tblclmnId.setText("ID");
		
		TableColumn tblclmnName = new TableColumn(tblPatient, SWT.NONE);
		tblclmnName.setWidth(82);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnSex = new TableColumn(tblPatient, SWT.NONE);
		tblclmnSex.setWidth(76);
		tblclmnSex.setText("Sex");
		
		TableColumn tblclmnAge = new TableColumn(tblPatient, SWT.NONE);
		tblclmnAge.setWidth(73);
		tblclmnAge.setText("Age");
		
		Label lblMedicalCode = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblMedicalCode.setText("Patient ID");
		lblMedicalCode.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicalCode.setBounds(336, 31, 109, 14);
		
		txtPatientID = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientID.setEditable(false);
		txtPatientID.setBounds(451, 30, 164, 21);
		
		Label lblPatientName = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblPatientName.setText("Patient name");
		lblPatientName.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblPatientName.setBounds(336, 59, 109, 14);
		
		txtPatientName = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientName.setEditable(false);
		txtPatientName.setBounds(451, 57, 164, 21);
		
		txtPatientSex = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientSex.setEditable(false);
		txtPatientSex.setBounds(451, 84, 62, 21);
		
		Label lblSex = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblSex.setText("Sex");
		lblSex.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblSex.setBounds(336, 86, 39, 14);
		
		txtPatientAge = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPatientAge.setEditable(false);
		txtPatientAge.setBounds(451, 111, 62, 21);
		
		Label lblAge = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblAge.setText("Age");
		lblAge.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblAge.setBounds(336, 113, 39, 14);
		
		Label label_2 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_2.setText("Pulse");
		label_2.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_2.setBounds(337, 154, 89, 14);
		
		Label label_5 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_5.setText("Temperature");
		label_5.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_5.setBounds(334, 181, 92, 14);
		
		text_4 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_4.setEditable(false);
		text_4.setBounds(429, 179, 79, 21);
		
		txtPulse = new Text(grpImportInvoiceInformation, SWT.BORDER);
		txtPulse.setEditable(false);
		txtPulse.setBounds(429, 152, 79, 21);
		
		Label label_6 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_6.setText("Breathing");
		label_6.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_6.setBounds(514, 154, 101, 14);
		
		Label label_7 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_7.setText("Blood pressure");
		label_7.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_7.setBounds(514, 181, 101, 14);
		
		text_6 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_6.setEditable(false);
		text_6.setBounds(621, 179, 79, 21);
		
		text_8 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_8.setEditable(false);
		text_8.setBounds(621, 152, 79, 21);
		
		Label label_8 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_8.setText("Height");
		label_8.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_8.setBounds(706, 154, 89, 14);
		
		Label label_9 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_9.setText("Weight");
		label_9.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_9.setBounds(706, 181, 92, 14);
		
		text_9 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_9.setEditable(false);
		text_9.setBounds(807, 152, 79, 21);
		
		text_10 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_10.setEditable(false);
		text_10.setBounds(807, 179, 79, 21);
		
		Label label_10 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_10.setBounds(328, 138, 594, 2);
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setImage(null);
		btnSave.setFont(SWTResourceManager.getFont("Tahoma", 8, SWT.NORMAL));
		btnSave.setBounds(750, 631, 88, 23);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnCancel.setText("Cancel");
		btnCancel.setImage(null);
		btnCancel.setFont(SWTResourceManager.getFont("Tahoma", 8, SWT.NORMAL));
		btnCancel.setBounds(844, 631, 88, 23);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 226, 922, 399);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmExamination = new CTabItem(tabFolder, SWT.NONE);
		tbtmExamination.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tbtmExamination.setText("Examination");
		
		tabFolder.setSelection(tbtmExamination);
		
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
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MedicineLOV medicineLOV = new MedicineLOV(getDisplay(), SWT.DIALOG_TRIM, appContext);
				medicineLOV.setLocation(250, 50);
				medicineLOV.open();
			}
		});
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
		
		TableCombo tableCombo = new TableCombo(composite_1, SWT.BORDER);
		tableCombo.setBounds(125, 38, 177, 21);
		tableCombo.defineColumns(new String[] {"ID", "Name"});
		tableCombo.setShowTableHeader(true);
		tableCombo.setTableVisible(true);
		
		CTabItem tabItem = new CTabItem(tabFolder, SWT.NONE);
		tabItem.setText("New Item");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(composite);
		
		text = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		text.setBounds(175, 11, 731, 69);
		
		Label lblClinicalSympto = new Label(composite, SWT.NONE);
		lblClinicalSympto.setText("Clinical Symptoms");
		lblClinicalSympto.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblClinicalSympto.setBounds(10, 10, 159, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(175, 87, 731, 21);
		
		Label lblPreliminary = new Label(composite, SWT.NONE);
		lblPreliminary.setText("Preliminary diagnosis");
		lblPreliminary.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblPreliminary.setBounds(10, 89, 159, 14);
		
		text_2 = new Text(composite, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		text_2.setBounds(175, 115, 731, 172);
		
		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setText("Clinical Symptoms");
		label_4.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_4.setBounds(10, 114, 159, 21);
		TableItem itemCmb = new TableItem(tableCombo.getTable(), SWT.NONE);
		itemCmb.setText(new String[]{"id1", "name1"});
	}

	private void initial() {
		List<Department> lstDepartment= departmentDao.findAll();
    	
    	// Fill list departments
    	lstDept = new String[lstDepartment.size() + 1];
    	lstDeptID = new String[lstDepartment.size() + 1];
    	lstDept[0] = "";
    	lstDeptID[0] = "";
    	
    	for (int i = 0; i < lstDept.length - 1; i++) {
    		lstDept[i + 1] = lstDepartment.get(i).getDeptName();
    		lstDeptID[i + 1] = lstDepartment.get(i).getDeptID();
    	}
    	
    	this.cmbDepartment.setItems(lstDept);
    	
	}
	
	private void selectDepartment() {
		int index = -1;
		
		if (cmbDepartment.getText().trim().equals("")) {
			cmbDoctor.removeAll();
			tblPatient.removeAll();
			return;
		}
		
		for (int i = 1; i < lstDept.length; i++) {
			if (cmbDepartment.getText().equals(lstDept[i])) {
				index = i;
				break;
			}
		}
		
		if (index > 0) {
			//Fill data to doctor combobox
			List<Doctor> listDoctor = doctorDao.findByDeptId(lstDeptID[index]);
	    	
	    	// Fill list departments
	    	lstDoctor = new String[listDoctor.size() + 1];
	    	lstDoctorID = new String[listDoctor.size() + 1];
	    	lstDoctor[0] = "";
	    	lstDoctorID[0] = "";
	    	
	    	for (int i = 0; i < listDoctor.size(); i++) {
	    		lstDoctor[i + 1] = listDoctor.get(i).getDoctorName();
	    		lstDoctorID[i + 1] = listDoctor.get(i).getDoctorID();
	    	}
	    	
	    	cmbDoctor.setItems(lstDoctor);

	    	//Get patients of current department
	    	List<Service> listService = serviceDao.findByDeptId(lstDeptID[index]);
	    	TableItem item = null;
	    	Patient patient = null;
	    	String[] txtRow = null;
	    	
	    	tblPatient.removeAll();
	    	
	    	for (Service service: listService) {
	    		item = new TableItem(tblPatient, SWT.NONE);
	    		patient = patientDao.findById(service.getPatientID());
	    		txtRow = new String[4];
	    		txtRow[0] = service.getPatientID();
	    		txtRow[1] = patient.getPatientName();
	    		txtRow[2] = patient.getSex();
	    		if (patient.getDayOfBirth() != null) {
	    			txtRow[3] = formatter.format(patient.getDayOfBirth());
	    		} else {
	    			txtRow[3] = "";
	    		}
	    		
	    		item.setText(txtRow);
	    	}
		}
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

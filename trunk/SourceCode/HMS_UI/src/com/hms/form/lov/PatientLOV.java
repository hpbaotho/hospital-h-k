package com.hms.form.lov;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.nebula.widgets.pgroup.PGroup;
import org.eclipse.nebula.widgets.pgroup.ChevronsToggleRenderer;
import org.eclipse.nebula.widgets.pgroup.RectangleGroupStrategy;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

import com.hms.model.dao.PatientDao;
import com.hms.model.entity.Patient;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PatientLOV extends Shell {
	private Text txtID;
	private Text txtName;
	private Table tblPatient;
	
	// DAO
	private PatientDao patientDao = null;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PatientLOV shell = new PatientLOV(display);
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
	public PatientLOV(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		// Get beans
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml");
		patientDao = (PatientDao) appContext.getBean("patientDao");
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setSingle(true);
		tabFolder.setBounds(10, 10, 472, 351);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmPatient = new CTabItem(tabFolder, SWT.NONE);
		tbtmPatient.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		tbtmPatient.setText("Patient");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmPatient.setControl(composite);
		
		PGroup grpSearch = new PGroup(composite, SWT.SMOOTH);
		grpSearch.setBounds(10, 10, 446, 46);
		grpSearch.setStrategy(new RectangleGroupStrategy());
		grpSearch.setToggleRenderer(new ChevronsToggleRenderer());
		grpSearch.setText("Search");
		
		txtID = new Text(grpSearch, SWT.BORDER);
		txtID.setBounds(27, 24, 117, 19);
		
		txtName = new Text(grpSearch, SWT.BORDER);
		txtName.setBounds(194, 24, 168, 19);
		
		Label lblId = new Label(grpSearch, SWT.NONE);
		lblId.setAlignment(SWT.RIGHT);
		lblId.setBounds(10, 27, 11, 13);
		lblId.setText("ID");
		
		Label lblName = new Label(grpSearch, SWT.NONE);
		lblName.setText("Name");
		lblName.setAlignment(SWT.RIGHT);
		lblName.setBounds(161, 27, 27, 13);
		
		Button btnSearch = new Button(grpSearch, SWT.NONE);
		btnSearch.setBounds(368, 23, 68, 21);
		btnSearch.setText("Search");
		
		tblPatient = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tblPatient.setBounds(10, 62, 446, 226);
		tblPatient.setHeaderVisible(true);
		tblPatient.setLinesVisible(true);
		
		TableColumn tblcolId = new TableColumn(tblPatient, SWT.NONE);
		tblcolId.setWidth(160);
		tblcolId.setText("ID");
		
		TableColumn tblcolName = new TableColumn(tblPatient, SWT.NONE);
		tblcolName.setWidth(280);
		tblcolName.setText("Name");
		
		//Fill table
		this.fillTable(tblPatient);
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setBounds(388, 294, 68, 23);
		btnCancel.setText("Cancel");
		
		Button btnOk = new Button(composite, SWT.NONE);
		btnOk.setBounds(314, 294, 68, 23);
		btnOk.setText("OK");
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("List of values");
		setSize(500, 401);

	}

	protected void fillTable(Table table) {
		TableItem tableItem = null;
		
		if (patientDao != null) {
			for (Patient patient : patientDao.findAll()) {
				tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {patient.getPatientID(), patient.getPatientName()});
			}
		}
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

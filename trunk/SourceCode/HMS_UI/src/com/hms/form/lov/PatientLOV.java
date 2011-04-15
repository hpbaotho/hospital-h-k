package com.hms.form.lov;

import java.util.LinkedList;
import java.util.List;

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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import com.hms.model.dao.PatientDao;
import com.hms.model.entity.Item;
import com.hms.model.entity.Patient;
import com.swtdesigner.SWTResourceManager;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class PatientLOV extends Dialog {
	protected Object result;
	protected Shell shell;
	
	private Text txtID;
	private Text txtName;
	private Table tblPatient;
	
	// DAO
	private ApplicationContext appContext = null;
	private PatientDao patientDao = null;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display, SWT.SHELL_TRIM);
			
			PatientLOV dialog = new PatientLOV(shell, SWT.SHELL_TRIM, new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml"));
			Object result = dialog.open();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public PatientLOV(Shell parent, int style, ApplicationContext appContext) {
		super(parent, style);
		
		this.appContext = appContext;
		// Get beans
		patientDao = (PatientDao) this.appContext.getBean("patientDao");
				
		createContents();
		
		//Fill table
		if (patientDao != null) {
			this.fillTable(this.tblPatient, patientDao.findAll());
		}
		
		this.initial();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("List of values");
		
		shell = new Shell(getParent(), getStyle());
		shell.setSize(500, 401);
		shell.setText(getText());

		CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER);
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
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					search();
				}
			}
		});
		
		txtName = new Text(grpSearch, SWT.BORDER);
		txtName.setBounds(194, 24, 168, 19);
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					search();
				}
			}
		});
		
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
		tblPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				ok();
			}
		});
		tblPatient.setBounds(10, 62, 446, 226);
		tblPatient.setHeaderVisible(true);
		tblPatient.setLinesVisible(true);
		
		TableColumn tblcolId = new TableColumn(tblPatient, SWT.NONE);
		tblcolId.setWidth(160);
		tblcolId.setText("ID");
		
		TableColumn tblcolName = new TableColumn(tblPatient, SWT.NONE);
		tblcolName.setWidth(280);
		tblcolName.setText("Name");
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
		btnCancel.setBounds(388, 294, 68, 23);
		btnCancel.setText("Cancel");
		
		Button btnOk = new Button(composite, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ok();
			}
		});
		btnOk.setBounds(314, 294, 68, 23);
		btnOk.setText("OK");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}
	
	public void setLocation(int x, int y) {
		if (this.shell != null) {
			this.shell.setLocation(x, y);
		}
	}
	
	private void initial() {
		this.tblPatient.forceFocus();
		if (this.tblPatient.getSelectionCount() > 0) {
			this.tblPatient.select(0);
		}
		this.txtID.setFocus();
	}
	
	protected void fillTable(Table table, List<Patient> lstPatient) {
		TableItem tableItem = null;
		
		if (lstPatient != null) {
			for (Patient patient : lstPatient) {
				tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {patient.getPatientID(), patient.getPatientName()});
			}
		}
	}
	
	protected void search() {
		List<Item> lstCriteria = new LinkedList<Item>();
		
		if (!txtID.getText().equals("")) {
			lstCriteria.add(new Item("MEDICINE_ID", txtID.getText()));
		}
		
		if (!txtName.getText().equals("")) {
			lstCriteria.add(new Item("MEDICINE_NAME", txtName.getText()));
		}
		
		this.tblPatient.removeAll();
		this.fillTable(this.tblPatient, this.patientDao.find(lstCriteria));
	}
	
	private void ok() {
		if (tblPatient.getSelectionCount() > 0) {
			result = new Item();
			
			((Item) result).setLabel(tblPatient.getSelection()[0].getText(0));
			((Item) result).setValue(tblPatient.getSelection()[0].getText(1));
		}
		
		shell.dispose();
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

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

import com.hms.model.dao.MedicineDao;
import com.hms.model.entity.Item;
import com.hms.model.entity.Medicine;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class MedicineLOV extends Shell {
	private Text txtID;
	private Text txtName;
	private Table tblMedicine;
	
	// DAO
	private ApplicationContext appContext = null;
	private MedicineDao medicineDao = null;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			
			MedicineLOV shell = new MedicineLOV(display, SWT.SHELL_TRIM, new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml"));
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
	public MedicineLOV(Display display, int style, ApplicationContext appContext) {
		super(display, style);
		
		this.appContext = appContext;
		
		// Get beans
		this.medicineDao = (MedicineDao) this.appContext.getBean("medicineDao");
		
		createContents();
		
		if (medicineDao != null) {
			//Fill table
			this.fillTable(tblMedicine, medicineDao.findAll());
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("List of values");
		setSize(500, 401);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setSingle(true);
		tabFolder.setBounds(10, 10, 472, 351);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmPatient = new CTabItem(tabFolder, SWT.NONE);
		tbtmPatient.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		tbtmPatient.setText("Medicine");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmPatient.setControl(composite);
		
		PGroup grpSearch = new PGroup(composite, SWT.SMOOTH);
		grpSearch.setBounds(10, 10, 446, 46);
		grpSearch.setStrategy(new RectangleGroupStrategy());
		grpSearch.setToggleRenderer(new ChevronsToggleRenderer());
		grpSearch.setText("Search");
		
		txtID = new Text(grpSearch, SWT.BORDER);
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					search();
				}
			}
		});
		txtID.setBounds(27, 24, 117, 19);
		
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
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(368, 23, 68, 21);
		btnSearch.setText("Search");
		
		tblMedicine = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		tblMedicine.setBounds(10, 62, 446, 226);
		tblMedicine.setHeaderVisible(true);
		tblMedicine.setLinesVisible(true);
		
		TableColumn tblcolId = new TableColumn(tblMedicine, SWT.NONE);
		tblcolId.setWidth(160);
		tblcolId.setText("ID");
		
		TableColumn tblcolName = new TableColumn(tblMedicine, SWT.NONE);
		tblcolName.setWidth(280);
		tblcolName.setText("Name");
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(388, 294, 68, 23);
		btnCancel.setText("Cancel");
		
		Button btnOk = new Button(composite, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(314, 294, 68, 23);
		btnOk.setText("OK");

	}

	protected void fillTable(Table table, List<Medicine> lstMedicine) {
		TableItem tableItem = null;
		
		if (lstMedicine != null) {
			for (Medicine medicine : lstMedicine) {
				tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {medicine.getMedicineID(), medicine.getMedicineName()});
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
		
		this.tblMedicine.removeAll();
		this.fillTable(tblMedicine, this.medicineDao.find(lstCriteria));
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

package com.hms.form;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.form.lov.PatientLOV;
import com.hms.model.dao.DepartmentDao;
import com.hms.model.dao.PatientDao;
import com.hms.model.dao.ServiceDao;
import com.hms.model.dao.V_MaterialDao;
import com.hms.model.entity.Item;
import com.hms.model.entity.Service;
import com.hms.model.entity.V_Material;
import com.swtdesigner.SWTResourceManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

public class ServicesShell extends Shell {
	private Table table;
	private String[] lstDept = null;
	private String[] lstDeptID = null;
	private TableItem tblitemEditing = null;
	
	//Row editor
	private Composite compPatient = null;
	private Text txtPatient = null;
	private Button btnPatient = null;
	private CCombo cmbDepartment = null;
	private Text txtPrice = null;
	private KeyAdapter keyAdapter = null;
	
	//DAO
	private ApplicationContext appContext = null;
	private ServiceDao serviceDao = null;
	private DepartmentDao departmentDao = null;
	private V_MaterialDao materialDao = null;
	private PatientDao patientDao = null;
	
	private HibernateTransactionManager transaction = null;
	private TransactionStatus status = null;
	private DefaultTransactionDefinition def = null;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ServicesShell shell = new ServicesShell(display, SWT.SHELL_TRIM, new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml"));
			shell.setLocation(50, 50);
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
	public ServicesShell(Display display, int style, ApplicationContext appContext) {
		super(display, style);
		
		// -------------------------Get beans------------------------------------
		this.appContext = appContext;
	
    	serviceDao = (ServiceDao) appContext.getBean("serviceDao");
    	departmentDao = (DepartmentDao) appContext.getBean("departmentDao");
    	materialDao = (V_MaterialDao) appContext.getBean("materialDao");
    	patientDao = (PatientDao) appContext.getBean("patientDao");
    	transaction = (HibernateTransactionManager) appContext.getBean("transactionManager");
    	
    	def = new DefaultTransactionDefinition();
    	
    	// explicitly setting the transaction name is something that can only be done programmatically
    	def.setName("Service transaction");
    	def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

    	status = transaction.getTransaction(def);

		// -----------------------------------------------------------------------
		createContents();
		
		this.initial();
		
		//Load data into table
		this.fillTable(table);
		
	}

	private void initial() {
		//Initialize KeyAdapter
    	keyAdapter = new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if (e.keyCode == SWT.ESC || e.keyCode == 13) {
    				if (tblitemEditing != null) {
    					unsetTableItemEditor(tblitemEditing);
    					tblitemEditing = null;
    				}
    			}
    		}
    	};
    	
    	List<V_Material> lstMaterial= materialDao.findByType("department");
    	
    	// Fill list departments
    	lstDept = new String[lstMaterial.size()];
    	lstDeptID = new String[lstMaterial.size()];
    	
    	for (int i = 0; i < lstDept.length; i++) {
    		lstDept[i] = lstMaterial.get(i).getValueDisp();
    		lstDeptID[i] = lstMaterial.get(i).getValue();
    	}
	}
	
	private void setTableItemEditor(final TableItem item) {
		TableEditor editor = new TableEditor(item.getParent());
	    
		compPatient = new Composite(item.getParent(), SWT.NONE);
	    txtPatient = new Text(compPatient, SWT.CENTER);
	    txtPatient.setBounds(0, 0, 150, 21);
	    txtPatient.setText(item.getText(1));
		txtPatient.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		txtPatient.addKeyListener(keyAdapter);
		btnPatient = new Button(compPatient, SWT.CENTER);
		btnPatient.setBounds(150, 0, 24, 20);
		btnPatient.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-search-icon.png"));
		btnPatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PatientLOV patientLOV = new PatientLOV(getShell(), SWT.DIALOG_TRIM, appContext);
				patientLOV.getParent().setLocation(250, 50);
				
				Item result = (Item) patientLOV.open();
				
				if (result != null) {
					txtPatient.setText(result.getValue());
					item.setText(4, result.getLabel());
				}
			}
		});
		editor.grabHorizontal = true;
		editor.setEditor(compPatient, item, 1);
		
		editor = new TableEditor(item.getParent());
		cmbDepartment = new CCombo(item.getParent(), SWT.CENTER);
		cmbDepartment.setItems(lstDept);
		cmbDepartment.setText(item.getText(2));
		cmbDepartment.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));	
		cmbDepartment.addKeyListener(keyAdapter);
		cmbDepartment.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CCombo cmbObj = (CCombo) e.widget;
				Table tblOjb = (Table) cmbObj.getParent();
				TableItem tblitemCurrent = tblOjb.getSelection()[0];
				System.out.println("Dept ID: " + lstDeptID[cmbObj.getSelectionIndex()]);
				tblitemCurrent.setText(5, lstDeptID[cmbObj.getSelectionIndex()]);
			}
		});
		editor.grabHorizontal = true;
		editor.setEditor(cmbDepartment, item, 2);
		
		editor = new TableEditor(item.getParent());
		txtPrice = new Text(item.getParent(), SWT.CENTER);
		txtPrice.setFont(SWTResourceManager.getFont("Tahoma",10, SWT.NORMAL));
		txtPrice.setText(item.getText(3));
		txtPrice.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.minimumWidth = txtPrice.getSize().x;
		editor.setEditor(txtPrice, item, 3);
		
		txtPatient.setFocus();
	}

	private void unsetTableItemEditor(TableItem item) {
		//Return if item is null
		if (item == null) {
			return;
		}
		
		if (txtPatient != null && cmbDepartment != null && txtPrice != null) {
			item.setText(1, txtPatient.getText());
			item.setText(2, cmbDepartment.getText());
			item.setText(3, txtPrice.getText());
			
			Service curService = serviceDao.findById(item.getText(0));
			
			if (curService != null) {
				curService.setPatientID(item.getText(4));
				curService.setDeptID(item.getText(5));
				curService.setPrice(Double.valueOf(item.getText(3)));
				serviceDao.update(curService);
			} else {
				curService = new Service();
				curService.setPatientID(item.getText(4));
				curService.setDeptID(item.getText(5));
				curService.setPrice(Double.valueOf(item.getText(3)));
				serviceDao.save(curService);
				item.setText(0, String.valueOf(curService.getServiceNo()));
			}
			
			//Destroy row editor
			txtPatient.dispose();
			btnPatient.dispose();
			compPatient.dispose();
			cmbDepartment.dispose();
			txtPrice.dispose();
			
			txtPatient = null;
			btnPatient = null;
			compPatient = null;
			cmbDepartment = null;
			txtPrice = null;
		}
	}
	
	protected void fillTable(Table table) {
		TableItem tableItem = null;
		
		if (serviceDao != null) {
			for (Service service : serviceDao.findAll()) {
				tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {
						String.valueOf(service.getServiceNo()), 
						patientDao.findById(service.getPatientID()).getPatientName(), 
						departmentDao.findById(service.getDeptID()).getDeptName(), 
						String.valueOf(service.getPrice()), 
						service.getPatientID(), 
						service.getDeptID()});
			}
		}
	}
	
	private void ok() {
		transaction.commit(status);
		status = transaction.getTransaction(def);
		dispose();
	}
	
	private void cancel() {
		MessageBox mb = new MessageBox(this, SWT.ICON_QUESTION | SWT.YES | SWT.NO | SWT.CANCEL);
		mb.setText("Confirm");
		mb.setMessage("Do you want to save ?");
		
		int val = mb.open();
		
		switch (val) {
		case SWT.YES:
			ok();
			break;
		case SWT.NO:
			transaction.rollback(status);
			dispose();
		}
		
	}
	
	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Services");
		setSize(700, 500);
		setLocation(50, 200);
		
		setLocation(-28, -63);
		setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-subclinical-icon.png"));
		setLayout(null);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 10, 672, 450);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmServices = new CTabItem(tabFolder, SWT.NONE);
		tbtmServices.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.BOLD));
		tbtmServices.setText("Services");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmServices.setControl(composite);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 622, 375);
		table.setLinesVisible(true);
		
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tblitemEditing != null) {
					unsetTableItemEditor(tblitemEditing);
					tblitemEditing = null;
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (tblitemEditing == null) {
					tblitemEditing = table.getSelection()[0];
					setTableItemEditor(tblitemEditing);
				}
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					if (tblitemEditing == null) {
						tblitemEditing = table.getSelection()[0];
						setTableItemEditor(tblitemEditing);
					}
				}
			}
		});
		table.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		table.setHeaderVisible(true);
		
		TableColumn tblclmnNo = new TableColumn(table, SWT.NONE);
		tblclmnNo.setText("No");
		tblclmnNo.setWidth(38);
		
		TableColumn tblColPatientName = new TableColumn(table, SWT.CENTER);
		tblColPatientName.setWidth(176);
		tblColPatientName.setText("Patient");
		
		TableColumn tblcolDeptName = new TableColumn(table, SWT.CENTER);
		tblcolDeptName.setWidth(253);
		tblcolDeptName.setText("Department");
		
		TableColumn tblcolPrice = new TableColumn(table, SWT.CENTER);
		tblcolPrice.setWidth(149);
		tblcolPrice.setText("Price");
		
		TableColumn tblcolPatientID = new TableColumn(table, SWT.NONE);
		tblcolPatientID.setText("New Column");
		
		TableColumn tblcolDeptID = new TableColumn(table, SWT.NONE);
		tblcolDeptID.setText("New Column");
		
	
		ToolBar tbControl = new ToolBar(composite, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		tbControl.setBounds(632, 10, 24, 66);
		
		ToolItem tbiAdd = new ToolItem(tbControl, SWT.NONE);
		tbiAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem newItem = new TableItem(table, SWT.NONE);
				
				tblitemEditing = newItem;
				table.setSelection(newItem);
				
				setTableItemEditor(tblitemEditing);
			}
		});
		tbiAdd.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem tbiEdit = new ToolItem(tbControl, SWT.NONE);
		tbiEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tblitemEditing == null) {
					tblitemEditing = table.getSelection()[0];
					setTableItemEditor(tblitemEditing);
				} else {
					unsetTableItemEditor(tblitemEditing);
					tblitemEditing = null;
				}
				
			}
		});
		tbiEdit.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-edit-icon.png"));
		
		ToolItem tbiDelete = new ToolItem(tbControl, SWT.NONE);
		tbiDelete.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(542, 391, 90, 23);
		btnCancel.setText("Cancel");
		
		Button btnOk = new Button(composite, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ok();
			}
		});
		btnOk.setBounds(446, 391, 90, 23);
		btnOk.setText("OK");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

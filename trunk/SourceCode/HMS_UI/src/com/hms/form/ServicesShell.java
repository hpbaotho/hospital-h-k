package com.hms.form;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.model.dao.DepartmentDao;
import com.hms.model.dao.ServiceDao;
import com.hms.model.dao.V_MaterialDao;
import com.hms.model.entity.Service;
import com.hms.model.entity.V_Material;
import com.swtdesigner.SWTResourceManager;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;

public class ServicesShell extends Shell {
	private Table table;
	private List<Control> selectedRowEditor = null;
	private int selectedRowIndex = -1;
	private String[] lstDept = null;
	
	private ServiceDao serviceDao = null;
	private DepartmentDao departmentDao = null;
	private V_MaterialDao materialDao = null;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ServicesShell shell = new ServicesShell(display);
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
	public ServicesShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		// -------------------------Get beans------------------------------------
		ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml");
	
    	serviceDao = (ServiceDao) appContext.getBean("serviceDao");
    	departmentDao = (DepartmentDao) appContext.getBean("departmentDao");
    	materialDao = (V_MaterialDao) appContext.getBean("materialDao");
		// -----------------------------------------------------------------------
		
    	List<V_Material> lstMaterial= materialDao.findByType("department");
    	
    	// Fill list departments
    	lstDept = new String[lstMaterial.size()];
    	for (int i = 0; i < lstDept.length; i++) {
    		lstDept[i] = lstMaterial.get(i).getValueDisp();
    	}
    	
		setLocation(-28, -63);
		setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-subclinical-icon.png"));
		setLayout(null);
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 10, 672, 450);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmServices = new CTabItem(tabFolder, SWT.NONE);
		tbtmServices.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.BOLD));
		tbtmServices.setText("Services");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmServices.setControl(composite);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 622, 407);
		table.setLinesVisible(true);
		
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if (selectedRowIndex != -1) {
					disableTableEditor((Table) e.widget, selectedRowIndex);
				}
				
				selectedRowIndex = ((Table) e.widget).getSelectionIndex();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				enableTableEditor((Table) e.widget);
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					enableTableEditor((Table) e.widget);
				}
			}
		});
		table.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		table.setHeaderVisible(true);
		
		TableColumn tblclmnNo = new TableColumn(table, SWT.NONE);
		tblclmnNo.setText("No");
		tblclmnNo.setWidth(38);
		
		TableColumn tblColPatient = new TableColumn(table, SWT.CENTER);
		tblColPatient.setWidth(176);
		tblColPatient.setText("Patient");
		
		TableColumn tblclmnServices = new TableColumn(table, SWT.CENTER);
		tblclmnServices.setWidth(253);
		tblclmnServices.setText("Services");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(146);
		tblclmnPrice.setText("Price");
		
		this.fillTable(table);
		
	
		ToolBar toolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setBounds(632, 10, 24, 44);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		createContents();
	}

	protected void enableTableEditor(final Table table) {
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ESC) {
					disableTableEditor(table, table.getSelectionIndex());
				}
			}
		};
		
		if (this.selectedRowEditor == null) {
			this.selectedRowEditor = new LinkedList<Control>();
		} else {
			this.selectedRowEditor.clear();
		}

		TableEditor editor = new TableEditor(table);
	    
		Composite compPatient = new Composite(table, SWT.NONE);
	    Text txtPatient = new Text(compPatient, SWT.CENTER);
	    txtPatient.setBounds(0, 0, 150, 21);
	    txtPatient.setText("HUAN");
		txtPatient.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		Button btnPatient = new Button(compPatient, SWT.CENTER);
		btnPatient.setBounds(150, 0, 24, 20);
		btnPatient.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-search-icon.png"));
		btnPatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PatientListShell patientList = new PatientListShell(getDisplay());
				patientList.setLocation(250, 50);
				patientList.open();
				patientList.layout();
			}
		});
		editor.grabHorizontal = true;
		editor.setEditor(compPatient, table.getSelection()[0], 1);
		this.selectedRowEditor.add(compPatient);
		
		editor = new TableEditor(table);
		CCombo comboEditor = new CCombo(table, SWT.CENTER);
		comboEditor.setItems(lstDept);
		comboEditor.setText(table.getSelection()[0].getText(2));
		comboEditor.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		comboEditor.addKeyListener(keyAdapter);		
		editor.grabHorizontal = true;
		editor.setEditor(comboEditor, table.getSelection()[0], 2);
		this.selectedRowEditor.add(comboEditor);
		
		editor = new TableEditor(table);
		Text text = new Text(table, SWT.CENTER);
		text.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		text.setText(table.getSelection()[0].getText(3));
		editor.grabHorizontal = true;
		editor.minimumWidth = text.getSize().x;
		editor.setEditor(text, table.getSelection()[0], 3);
		this.selectedRowEditor.add(text);
		
		comboEditor.setFocus();
	}
	
	protected void disableTableEditor(Table table, int indexEditor) {
		TableItem selectedItem = null;
		Control editor = null;
		
		if (table == null) {
			return;
		}
		
		if (indexEditor != -1) {
			selectedItem = table.getItem(indexEditor);
		} else {
			return;
		}

		if (selectedRowEditor != null && (selectedRowEditor.size() == table.getColumnCount() - 1)) {
			for (int i = 1; i < table.getColumnCount(); i++) {
				editor = selectedRowEditor.get(i - 1);
				
				if ( editor!= null) {
					if (editor.getClass().toString().equalsIgnoreCase("class org.eclipse.swt.custom.CCombo")) {
						selectedItem.setText(i, ((CCombo) editor).getText());
					} else if (editor.getClass().toString().equalsIgnoreCase("class org.eclipse.swt.widgets.Text")) {
						selectedItem.setText(i, ((Text) editor).getText());
					}
					editor.dispose();
				}
			}
			
			selectedRowEditor.clear();
		}
	}

	protected void fillTable(Table table) {
		TableItem tableItem = null;
		
		if (serviceDao != null) {
			for (Service service : serviceDao.findAll()) {
				tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {String.valueOf(service.getServiceNo()), "HUAN", departmentDao.findById(service.getDeptID()).getDeptName(), String.valueOf(service.getPrice())});
			}
		}
	}
	
	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Services");
		setSize(700, 500);
		setLocation(50, 200);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

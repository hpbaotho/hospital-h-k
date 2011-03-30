package com.hms.form;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.hms.model.dao.MedicineDao;
import com.hms.model.dao.MedicineGroupDao;
import com.hms.model.dao.V_MaterialDao;
import com.hms.model.entity.Medicine;
import com.hms.model.entity.MedicineGroup;
import com.hms.model.entity.V_Material;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.nebula.widgets.pgroup.PGroup;
import org.eclipse.nebula.widgets.pgroup.ChevronsToggleRenderer;
import org.eclipse.swt.events.ExpandAdapter;
import org.eclipse.swt.events.ExpandEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MSManagementShell extends Shell {
	private MSManagementShell me = this;
	
	private Text txtMedicineName;
	private Text txtMedicineID;
	private Text txtParameter;
	private Text txtPrice;
	private Text txtCost;
	private Text txtWholePrice;
	private Text txtInsurancePrice;
	private Table tblMedicine;
	private Composite compMedicine;
	private PGroup grpDetail;
	private Composite compDetail;
	private Combo cmbGroup;
	private Button btnSearch;
	private Combo cmbUnit;
	
	private String[] lstGroup = null;
	private String[] lstGroupID = null;
	private String[] lstUnit = null;
	private String[] lstUnitID = null;
	
	private MedicineGroupDao medicGroupDao;
	private MedicineDao medicineDao;
	private V_MaterialDao materialDao = null;
	
	private static final int SMALL_MODE_Y = 224;
	private static final int SMALL_MODE_HEIGHT = 436;
	private static final int FULL_MODE_Y = 36;
	private static final int FULL_MODE_HEIGHT = 624;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MSManagementShell shell = new MSManagementShell(display);
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
	public MSManagementShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml");
		medicGroupDao = (MedicineGroupDao) appContext.getBean("medicineGroupDao");
		medicineDao = (MedicineDao) appContext.getBean("medicineDao");
		materialDao = (V_MaterialDao) appContext.getBean("materialDao");
		
		//Get values for Group Combobox
		List<MedicineGroup>  lstMedicineGroup = medicGroupDao.findAll();
		
		lstGroup = new String[lstMedicineGroup.size()];
		lstGroupID = new String[lstMedicineGroup.size()];
    	
		for (int i = 0; i < lstGroup.length; i++) {
			lstGroup[i] = lstMedicineGroup.get(i).getGroupName();
			lstGroupID[i] = lstMedicineGroup.get(i).getGroupID();
    	}
		
		List<V_Material>  lstV_Materials = materialDao.findByType("unit");
		
		lstUnit = new String[lstV_Materials.size()];
		lstUnitID = new String[lstV_Materials.size()];
    	
		for (int i = 0; i < lstUnit.length; i++) {
			lstUnit[i] = lstV_Materials.get(i).getValueDisp();
			lstUnitID[i] = lstV_Materials.get(i).getValue();
    	}
		
		createContents();
		
		this.fillTable(tblMedicine);
		
		initial();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.MSManagementShell.title"));
		setSize(900, 700);
		setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-pill-icon.png"));
		
		compMedicine = new Composite(this, SWT.BORDER);
		compMedicine.setBounds(10, 36, 872, 624);
		
		tblMedicine = new Table(compMedicine, SWT.BORDER | SWT.FULL_SELECTION);
		tblMedicine.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.NORMAL));
		tblMedicine.setBounds(0, 0, 844, 620);
		tblMedicine.setHeaderVisible(true);
		tblMedicine.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(tblMedicine, SWT.NONE);
		tableColumn.setText("New Column");
		
		TableColumn tblclmnMSGroup = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnMSGroup.setWidth(100);
		tblclmnMSGroup.setText("Group");
		
		TableColumn tblclmnMSId = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnMSId.setWidth(100);
		tblclmnMSId.setText("ID");
		
		TableColumn tblclmnMSName = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnMSName.setWidth(100);
		tblclmnMSName.setText("Name");
		
		TableColumn tblclmnUnit = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnUnit.setWidth(100);
		tblclmnUnit.setText("Unit");
		
		TableColumn tblclmnPrice = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnPrice.setWidth(100);
		tblclmnPrice.setText("Price");
		
		TableColumn tblclmnInsurancePrice = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnInsurancePrice.setWidth(125);
		tblclmnInsurancePrice.setText("Insurance Price");
		
		TableColumn tblclmnWholeSalePrice = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnWholeSalePrice.setWidth(212);
		tblclmnWholeSalePrice.setText("Whole sale price");
		
		ToolBar tbControl = new ToolBar(compMedicine, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		tbControl.setBounds(844, 0, 24, 132);
		
		ToolItem toolItem = new ToolItem(tbControl, SWT.NONE);
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnSearch.setText("Add");
				btnSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
				grpDetail.setExpanded(true);
				compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
				compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
				tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
			}
		});
		toolItem.setToolTipText("Add");
		toolItem.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem tbiEdit = new ToolItem(tbControl, SWT.NONE);
		tbiEdit.setToolTipText("Edit");
		tbiEdit.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-edit-icon.png"));
		
		ToolItem tbiDelete = new ToolItem(tbControl, SWT.NONE);
		tbiDelete.setToolTipText("Delete");
		tbiDelete.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		ToolItem toolItem_3 = new ToolItem(tbControl, SWT.NONE);
		toolItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnSearch.setText("Search");
				btnSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-search-icon.png"));
				grpDetail.setExpanded(true);
				compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
				compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
				tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
			}
		});
		toolItem_3.setToolTipText("Search");
		toolItem_3.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-search-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(tbControl, SWT.NONE);
		toolItem_1.setToolTipText("Save");
		toolItem_1.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-save-icon.png"));
		
		ToolItem toolItem_2 = new ToolItem(tbControl, SWT.NONE);
		toolItem_2.setToolTipText("Cancel");
		toolItem_2.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		
		grpDetail = new PGroup(this, SWT.SMOOTH);
		grpDetail.addExpandListener(new ExpandAdapter() {
			@Override
			public void itemExpanded(ExpandEvent e) {
				compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
				compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
				tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
				
			}
			@Override
			public void itemCollapsed(ExpandEvent e) {
				compMedicine.setLocation(compMedicine.getLocation().x, FULL_MODE_Y);
				compMedicine.setSize(compMedicine.getSize().x, FULL_MODE_HEIGHT);
				tblMedicine.setSize(tblMedicine.getSize().x, FULL_MODE_HEIGHT - 4);
			}
		});
		grpDetail.setToggleRenderer(new ChevronsToggleRenderer());
		grpDetail.setBounds(10, 10, 872, 208);
		grpDetail.setText("Medicine Details");
		
		compDetail = new Composite(grpDetail, SWT.BORDER);
		compDetail.setBounds(0, 22, 872, 186);
		
		Label lblMedicineGroup = new Label(compDetail, SWT.NONE);
		lblMedicineGroup.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicineGroup.setBounds(10, 12, 120, 14);
		lblMedicineGroup.setText("Group");
		
		cmbGroup = new Combo(compDetail, SWT.NONE);
		cmbGroup.setBounds(136, 10, 210, 21);
		
		Label lblMedicineName = new Label(compDetail, SWT.NONE);
		lblMedicineName.setText("Name");
		lblMedicineName.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicineName.setBounds(554, 12, 60, 14);
		
		txtMedicineName = new Text(compDetail, SWT.BORDER);
		txtMedicineName.setBounds(620, 10, 210, 21);
		
		Label lblMedicineId = new Label(compDetail, SWT.NONE);
		lblMedicineId.setText("ID");
		lblMedicineId.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicineId.setBounds(362, 12, 36, 14);
		
		txtMedicineID = new Text(compDetail, SWT.BORDER);
		txtMedicineID.setBounds(404, 10, 120, 21);
		
		Label lblParameter = new Label(compDetail, SWT.NONE);
		lblParameter.setText("Parameter");
		lblParameter.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblParameter.setBounds(10, 39, 120, 14);
		
		txtParameter = new Text(compDetail, SWT.BORDER);
		txtParameter.setBounds(136, 37, 694, 21);
		
		Label label = new Label(compDetail, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 64, 868, 2);
		
		Label lblPrice = new Label(compDetail, SWT.NONE);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblPrice.setBounds(10, 75, 120, 14);
		
		txtPrice = new Text(compDetail, SWT.BORDER);
		txtPrice.setBounds(136, 72, 120, 21);
		
		Label lblCost = new Label(compDetail, SWT.NONE);
		lblCost.setText("Cost");
		lblCost.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblCost.setBounds(262, 75, 60, 14);
		
		txtCost = new Text(compDetail, SWT.BORDER);
		txtCost.setBounds(328, 72, 120, 21);
		
		Label lblWholeSalePrice = new Label(compDetail, SWT.NONE);
		lblWholeSalePrice.setText("Whole Sale Price");
		lblWholeSalePrice.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblWholeSalePrice.setBounds(10, 101, 120, 14);
		
		txtWholePrice = new Text(compDetail, SWT.BORDER);
		txtWholePrice.setBounds(136, 99, 120, 21);
		
		Label lblInsurancePrice = new Label(compDetail, SWT.NONE);
		lblInsurancePrice.setText("Insurance Price");
		lblInsurancePrice.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblInsurancePrice.setBounds(454, 101, 120, 14);
		
		txtInsurancePrice = new Text(compDetail, SWT.BORDER);
		txtInsurancePrice.setBounds(580, 99, 120, 21);
		
		cmbUnit = new Combo(compDetail, SWT.NONE);
		cmbUnit.setBounds(328, 99, 120, 21);
		
		Label lblUnit = new Label(compDetail, SWT.NONE);
		lblUnit.setText("Unit");
		lblUnit.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblUnit.setBounds(262, 101, 60, 14);
		
		Combo cmbManufacturer = new Combo(compDetail, SWT.NONE);
		cmbManufacturer.setBounds(580, 73, 250, 21);
		
		Label lblManu = new Label(compDetail, SWT.NONE);
		lblManu.setText("Manufacturers");
		lblManu.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblManu.setBounds(454, 75, 120, 14);
		
		btnSearch = new Button(compDetail, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnSearch.getText().equals("Add")) {
					if (cmbGroup.getSelectionIndex() < 0) {
						MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
						mb.setText("Warning");
						mb.setMessage("Group name isn't selected yet!");
						mb.open();
					}
				}
			}
		});
		btnSearch.setText("Search");
		btnSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-search-icon.png"));
		btnSearch.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.BOLD));
		btnSearch.setBounds(740, 99, 89, 26);
	}

	protected void initial() {
		//Initial mode
		grpDetail.setExpanded(true);
		compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
		compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
		tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
		
		//Fill values for Group Combobox
		cmbGroup.setItems(lstGroup);
		cmbUnit.setItems(lstUnit);
	}
	
	protected void fillTable(Table table) {
		TableItem tableItem = null;
		
		if (medicineDao != null) {
			for (Medicine medicine : medicineDao.findAll()) {
				tableItem = new TableItem(table, SWT.NONE);
				tableItem.setText(new String[] {"", medicine.getGroupID(), medicine.getMedicineID(), medicine.getMedicineName(),
						medicine.getUnit(), String.valueOf(medicine.getPrice()), String.valueOf(medicine.getInsurancePrice()), 
						String.valueOf(medicine.getWholeSalePrice())});
			}
		}
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

package com.hms.form;

import java.util.LinkedList;
import java.util.List;

import net.sf.swtaddons.autocomplete.combo.AutocompleteComboSelector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.hms.model.dao.MedicineDao;
import com.hms.model.dao.MedicineGroupDao;
import com.hms.model.dao.V_MaterialDao;
import com.hms.model.entity.Item;
import com.hms.model.entity.Medicine;
import com.hms.model.entity.MedicineGroup;
import com.hms.model.entity.V_Material;
import com.hms.util.MessageBuilder;
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
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class MSManagementShell extends Shell {
	private MSManagementShell me = this;
	
	private Text txtMedicineID;
	private Text txtMedicineName;
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
	private Combo cmbManufacturer;
	
	private String[] lstGroup = null;
	private String[] lstGroupID = null;
	private String[] lstUnit = null;
	private String[] lstUnitID = null;
	
	private MedicineGroupDao medicGroupDao = null;
	private MedicineDao medicineDao = null;
	private V_MaterialDao materialDao = null;
	private HibernateTransactionManager transaction = null;
	private TransactionStatus status = null;
	private DefaultTransactionDefinition def = null;
	
	private static final int SMALL_MODE_Y = 175;
	private static final int SMALL_MODE_HEIGHT = 485;
	private static final int FULL_MODE_Y = 36;
	private static final int FULL_MODE_HEIGHT = 624;
	private Text txtFooter;

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
		
		//Transaction
    	transaction = (HibernateTransactionManager) appContext.getBean("transactionManager");
    	def = new DefaultTransactionDefinition();
    	
    	// explicitly setting the transaction name is something that can only be done programmatically
    	def.setName("Medicine transaction");
    	def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    	
    	//Start a transaction
    	status = transaction.getTransaction(def);
    	
		//Get values for Group Combobox
		List<MedicineGroup>  lstMedicineGroup = medicGroupDao.findAll();
		
		lstGroup = new String[lstMedicineGroup.size() + 1];
		lstGroupID = new String[lstMedicineGroup.size() + 1];
    	lstGroup[0] = "";
    	lstGroupID[0] = "";
    	
		for (int i = 0; i < lstGroup.length - 1; i++) {
			lstGroup[i + 1] = lstMedicineGroup.get(i).getGroupName();
			lstGroupID[i + 1] = lstMedicineGroup.get(i).getGroupID();
    	}
		
		List<V_Material>  lstV_Materials = materialDao.findByType("unit");
		
		lstUnit = new String[lstV_Materials.size() + 1];
		lstUnitID = new String[lstV_Materials.size() + 1];
    	
		lstUnit[0] = "";
		lstUnitID[0] = "";
		
		for (int i = 0; i < lstUnit.length - 1; i++) {
			lstUnit[i + 1] = lstV_Materials.get(i).getValueDisp();
			lstUnitID[i + 1] = lstV_Materials.get(i).getValue();
    	}
		
		createContents();
		
		this.fillTable(tblMedicine, medicineDao.findAll());
		
		txtFooter = new Text(this, SWT.NONE);
		txtFooter.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		txtFooter.setText("Search <F2>");
		txtFooter.setEditable(false);
		txtFooter.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		txtFooter.setBounds(10, 691, 872, 19);
		
		initial();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.MSManagementShell.title"));
		setSize(900, 750);
		setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-pill-icon.png"));
		
		compMedicine = new Composite(this, SWT.BORDER);
		compMedicine.setBounds(10, 175, 872, 485);
		
		tblMedicine = new Table(compMedicine, SWT.BORDER | SWT.FULL_SELECTION);
		tblMedicine.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<Item> lstItems = new LinkedList<Item>();
				
				lstItems.add(new Item("Add", "F5"));
				lstItems.add(new Item("Search", "F8"));
				
				txtFooter.setText(MessageBuilder.buildFooter(lstItems));
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtFooter.setText("");
			}
		});
		tblMedicine.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
					case SWT.F2:
						save();
						break;
					case SWT.F4:
						cancel();
						break;
					case SWT.F5:
						add();
						break;
					case SWT.F6:
						edit();
						break;
					case SWT.F7:
						delete();
						break;
					case SWT.F8:
						search();
				
				}
			}
		});
		tblMedicine.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.NORMAL));
		tblMedicine.setBounds(0, 0, 844, 481);
		tblMedicine.setHeaderVisible(true);
		tblMedicine.setLinesVisible(true);
		
		TableColumn tblclmnGroupId = new TableColumn(tblMedicine, SWT.NONE);
		tblclmnGroupId.setText("Group ID");
		
		TableColumn tblclmnMSGroup = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnMSGroup.setWidth(72);
		tblclmnMSGroup.setText("Group");
		
		TableColumn tblclmnMSId = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnMSId.setWidth(96);
		tblclmnMSId.setText("ID");
		
		TableColumn tblclmnMSName = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnMSName.setWidth(162);
		tblclmnMSName.setText("Name");
		
		TableColumn tblclmnParameter = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnParameter.setWidth(224);
		tblclmnParameter.setText("Parameter");
		
		TableColumn tblclmnUnit = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnUnit.setWidth(63);
		tblclmnUnit.setText("Unit");
		
		TableColumn tblclmnPrice = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnPrice.setWidth(88);
		tblclmnPrice.setText("Price");
		
		TableColumn tblclmnInsurancePrice = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnInsurancePrice.setText("Insurance Price");
		
		TableColumn tblclmnWholeSalePrice = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnWholeSalePrice.setText("Whole sale price");
		
		TableColumn tblclmnManufacturers = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnManufacturers.setWidth(134);
		tblclmnManufacturers.setText("Manufacturer");
		
		TableColumn tblclmnCost = new TableColumn(tblMedicine, SWT.CENTER);
		tblclmnCost.setText("Cost");
		
		ToolBar tbControl = new ToolBar(compMedicine, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		tbControl.setBounds(844, 0, 24, 132);
		
		ToolItem tbiAdd = new ToolItem(tbControl, SWT.NONE);
		tbiAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				add();
			}
		});
		tbiAdd.setToolTipText("Add (F5)");
		tbiAdd.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem tbiEdit = new ToolItem(tbControl, SWT.NONE);
		tbiEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				edit();
			}
		});
		tbiEdit.setToolTipText("Edit (F6)");
		tbiEdit.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-edit-icon.png"));
		
		ToolItem tbiDelete = new ToolItem(tbControl, SWT.NONE);
		tbiDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				delete();
			}
		});
		tbiDelete.setToolTipText("Delete (F7)");
		tbiDelete.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		ToolItem tbiSearch = new ToolItem(tbControl, SWT.NONE);
		tbiSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				search();
			}
		});
		tbiSearch.setToolTipText("Search (F8)");
		tbiSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-search-icon.png"));
		
		ToolItem tbiSave = new ToolItem(tbControl, SWT.NONE);
		tbiSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				save();
			}
		});
		tbiSave.setToolTipText("Save (F2)");
		tbiSave.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-save-icon.png"));
		
		ToolItem tbiCancel = new ToolItem(tbControl, SWT.NONE);
		tbiCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cancel();
			}
		});
		tbiCancel.setToolTipText("Cancel (F4)");
		tbiCancel.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		
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
		grpDetail.setBounds(10, 10, 872, 155);
		grpDetail.setText("Medicine Details");
		
		compDetail = new Composite(grpDetail, SWT.NONE);
		compDetail.setBounds(2, 22, 868, 130);
		
		Label lblMedicineGroup = new Label(compDetail, SWT.NONE);
		lblMedicineGroup.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicineGroup.setBounds(10, 12, 120, 14);
		lblMedicineGroup.setText("Group");
		
		cmbGroup = new Combo(compDetail, SWT.NONE);
		cmbGroup.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		cmbGroup.setBounds(136, 10, 210, 21);
		//Autocomplete function for combobox
		new AutocompleteComboSelector(cmbGroup);
		
		Label lblMedicineId = new Label(compDetail, SWT.NONE);
		lblMedicineId.setText("ID");
		lblMedicineId.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicineId.setBounds(362, 12, 36, 14);
		
		txtMedicineID = new Text(compDetail, SWT.BORDER);
		txtMedicineID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtMedicineID.setBounds(404, 10, 120, 21);
		
		Label lblMedicineName = new Label(compDetail, SWT.NONE);
		lblMedicineName.setText("Name");
		lblMedicineName.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblMedicineName.setBounds(554, 12, 60, 14);
		
		txtMedicineName = new Text(compDetail, SWT.BORDER);
		txtMedicineName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtMedicineName.setBounds(620, 10, 210, 21);
		
		Label lblParameter = new Label(compDetail, SWT.NONE);
		lblParameter.setText("Parameter");
		lblParameter.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblParameter.setBounds(10, 39, 120, 14);
		
		txtParameter = new Text(compDetail, SWT.BORDER);
		txtParameter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtParameter.setBounds(136, 37, 694, 21);
		
		Label label = new Label(compDetail, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 64, 868, 2);
		
		Label lblPrice = new Label(compDetail, SWT.NONE);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblPrice.setBounds(10, 75, 120, 14);
		
		txtPrice = new Text(compDetail, SWT.BORDER);
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtPrice.setBounds(136, 72, 120, 21);
		
		Label lblCost = new Label(compDetail, SWT.NONE);
		lblCost.setText("Cost");
		lblCost.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblCost.setBounds(262, 75, 60, 14);
		
		txtCost = new Text(compDetail, SWT.BORDER);
		txtCost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtCost.setBounds(328, 72, 120, 21);
		
		Label lblWholeSalePrice = new Label(compDetail, SWT.NONE);
		lblWholeSalePrice.setText("Whole Sale Price");
		lblWholeSalePrice.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblWholeSalePrice.setBounds(10, 101, 120, 14);
		
		txtWholePrice = new Text(compDetail, SWT.BORDER);
		txtWholePrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtWholePrice.setBounds(136, 99, 120, 21);
		
		Label lblInsurancePrice = new Label(compDetail, SWT.NONE);
		lblInsurancePrice.setText("Insurance Price");
		lblInsurancePrice.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblInsurancePrice.setBounds(454, 101, 120, 14);
		
		txtInsurancePrice = new Text(compDetail, SWT.BORDER);
		txtInsurancePrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		txtInsurancePrice.setBounds(580, 99, 120, 21);
		
		cmbUnit = new Combo(compDetail, SWT.NONE);
		cmbUnit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		cmbUnit.setBounds(328, 99, 120, 21);
		
		Label lblUnit = new Label(compDetail, SWT.NONE);
		lblUnit.setText("Unit");
		lblUnit.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblUnit.setBounds(262, 101, 60, 14);
		
		cmbManufacturer = new Combo(compDetail, SWT.NONE);
		cmbManufacturer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					doAction();
				}
			}
		});
		cmbManufacturer.setBounds(580, 73, 250, 21);
		
		Label lblManu = new Label(compDetail, SWT.NONE);
		lblManu.setText("Manufacturers");
		lblManu.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		lblManu.setBounds(454, 75, 120, 14);
		
		btnSearch = new Button(compDetail, SWT.NONE);
		btnSearch.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doAction();
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
		
		//Fill values for Group Combobox
		cmbGroup.setItems(lstGroup);
		cmbUnit.setItems(lstUnit);
	}
	
	protected void fillTable(Table table, List<Medicine> lstMedicine) {
		TableItem tableItem = null;
		
		if (medicineDao != null) {
			for (Medicine medicine : lstMedicine) {
				tableItem = new TableItem(table, SWT.NONE);
				
				tableItem.setText(new String[] { 
						medicine.getGroupID(), 
						medicGroupDao.findById(medicine.getGroupID()).getGroupName(), 
						medicine.getMedicineID(), 
						medicine.getMedicineName(), 
						medicine.getParameter(),
						medicine.getUnit(), 
						String.valueOf(medicine.getPrice()), 
						String.valueOf(medicine.getInsurancePrice()), 
						String.valueOf(medicine.getWholeSalePrice()), 
						medicine.getManufacturer(),
						String.valueOf(medicine.getCost())
						});
			}
		}
	}
	
	protected void clearDetailPanel() {
		cmbGroup.select(-1);
		txtMedicineID.setText("");
		txtMedicineName.setText("");
		txtParameter.setText("");
		txtPrice.setText("");
		txtCost.setText("");
		cmbUnit.select(-1);
		cmbManufacturer.select(-1);
		txtWholePrice.setText("");
		txtInsurancePrice.setText("");
		
		cmbGroup.setFocus();
	}
	
	protected void addRow() {
		//Validating: show message if having any errors
		if (cmbGroup.getText().trim().equals("")) {
			MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
			mb.setText("Warning");
			mb.setMessage("Group name isn't selected yet!");
			mb.open();
			cmbGroup.setFocus();
			return;
		} else if (txtMedicineID.getText().trim().equals("")) {
			MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
			mb.setText("Warning");
			mb.setMessage("Medicine ID isn't valid!");
			mb.open();
			txtMedicineID.setFocus();
			return;
		} else if (medicineDao.findById(txtMedicineID.getText().trim()) != null) {
			MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
			mb.setText("Warning");
			mb.setMessage("Medicine ID is existing!");
			mb.open();
			txtMedicineID.setFocus();
			return;
		} else if (txtMedicineName.getText().trim().equals("")) {
			MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
			mb.setText("Warning");
			mb.setMessage("Medicine name is empty!");
			mb.open();
			txtMedicineName.setFocus();
			return;
		}
		
		//All values are valid. Adding new row into table
		Medicine newMedicine = new Medicine();
		
		int index = -1;
		
		for (int i = 0; i < lstGroup.length; i++) {
			if (cmbGroup.getText().equals(lstGroup[i])) {
				index = i;
				break;
			}
		}
		
		newMedicine.setMedicineID(txtMedicineID.getText());
		newMedicine.setMedicineName(txtMedicineName.getText());
		if (index > 0) {
			newMedicine.setGroupID(lstGroupID[index]);
		} else {
			newMedicine.setGroupID("");
		}
		newMedicine.setParameter(txtParameter.getText());
		newMedicine.setPrice(Double.valueOf(txtPrice.getText()));
		newMedicine.setCost(Double.valueOf(txtCost.getText()));
		newMedicine.setUnit(cmbUnit.getText());
		newMedicine.setManufacturer(cmbManufacturer.getText());
		newMedicine.setWholeSalePrice((Double.valueOf(txtWholePrice.getText())));
		newMedicine.setInsurancePrice((Double.valueOf(txtInsurancePrice.getText())));
		
		medicineDao.save(newMedicine);
		
		TableItem newTableItem = new TableItem(tblMedicine, SWT.NONE);
		newTableItem.setText(new String[] {
				newMedicine.getGroupID(), 
				medicGroupDao.findById(newMedicine.getGroupID()).getGroupName(), 
				newMedicine.getMedicineID(), 
				newMedicine.getMedicineName(),
				newMedicine.getParameter(), 
				newMedicine.getUnit(), 
				String.valueOf(newMedicine.getPrice()), 
				String.valueOf(newMedicine.getInsurancePrice()), 
				String.valueOf(newMedicine.getWholeSalePrice()), 
				newMedicine.getManufacturer(), 
				String.valueOf(newMedicine.getCost())});
		
	}
	
	protected void updateRow() {
		//Validating: show message if having any errors
		if (cmbGroup.getText().trim().equals("")) {
			MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
			mb.setText("Warning");
			mb.setMessage("Group name isn't selected yet!");
			mb.open();
			cmbGroup.setFocus();
			return;
		} else if (txtMedicineName.getText().trim().equals("")) {
			MessageBox mb = new MessageBox(me, SWT.ICON_ERROR | SWT.OK);
			mb.setText("Warning");
			mb.setMessage("Medicine name is empty!");
			mb.open();
			txtMedicineName.setFocus();
			return;
		}
		
		//All values are valid. Adding new row into table
		Medicine updatedMedicine = medicineDao.findById(txtMedicineID.getText());
		
		int index = -1;
		
		for (int i = 0; i < lstGroup.length; i++) {
			if (cmbGroup.getText().equals(lstGroup[i])) {
				index = i;
				break;
			}
		}
		
		if (updatedMedicine != null) {
			updatedMedicine.setMedicineName(txtMedicineName.getText());
			if (index > 0) {
				updatedMedicine.setGroupID(lstGroupID[index]);
			} else {
				updatedMedicine.setGroupID("");
			}
			updatedMedicine.setParameter(txtParameter.getText());
			updatedMedicine.setPrice(Double.valueOf(txtPrice.getText()));
			updatedMedicine.setCost(Double.valueOf(txtCost.getText()));
			updatedMedicine.setUnit(cmbUnit.getText());
			updatedMedicine.setManufacturer(cmbManufacturer.getText());
			updatedMedicine.setWholeSalePrice((Double.valueOf(txtWholePrice.getText())));
			updatedMedicine.setInsurancePrice((Double.valueOf(txtInsurancePrice.getText())));
			
			medicineDao.update(updatedMedicine);
		}
		
		TableItem selectedRow = tblMedicine.getSelection()[0];
		
		selectedRow.setText(new String[] {
				updatedMedicine.getGroupID(),
				cmbGroup.getText(),
				updatedMedicine.getMedicineID(), 
				updatedMedicine.getMedicineName(),
				updatedMedicine.getParameter(), 
				updatedMedicine.getUnit(), 
				String.valueOf(updatedMedicine.getPrice()), 
				String.valueOf(updatedMedicine.getInsurancePrice()), 
				String.valueOf(updatedMedicine.getWholeSalePrice()), 
				updatedMedicine.getManufacturer(), 
				String.valueOf(updatedMedicine.getCost())});
	}
	
	protected void searchInTable() {
		List<Item> lstCriteria = new LinkedList<Item>();
		
		if (!cmbGroup.getText().equals("")) {
			int index = -1;
			
			for (int i = 1; i < lstGroup.length; i++) {
				if (cmbGroup.getText().equals(lstGroup[i])) {
					index = i;
					break;
				}
			}
			
			if (index > 0) {
				lstCriteria.add(new Item("GROUP_ID", lstGroupID[index]));
			}
			
		}
		
		if (!txtMedicineID.getText().equals("")) {
			lstCriteria.add(new Item("MEDICINE_ID", txtMedicineID.getText()));
		}
		
		if (!txtMedicineName.getText().equals("")) {
			lstCriteria.add(new Item("MEDICINE_NAME", txtMedicineName.getText()));
		}
		
		if (!txtParameter.getText().equals("")) {
			lstCriteria.add(new Item("PARAMETER", txtParameter.getText()));
		}
		
		if (!txtPrice.getText().equals("")) {
			lstCriteria.add(new Item("PRICE", txtPrice.getText()));
		}
		
		if (!cmbUnit.getText().equals("")) {
			lstCriteria.add(new Item("UNIT", cmbUnit.getText()));
		}
		
		if (!cmbManufacturer.getText().equals("")) {
			lstCriteria.add(new Item("MANUFACTURER", cmbManufacturer.getText()));
		}
		
		this.tblMedicine.removeAll();
		this.fillTable(tblMedicine, this.medicineDao.find(lstCriteria));
	}
	
	private void add() {
		btnSearch.setText("Add");
		btnSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		//Reset fields
		clearDetailPanel();
		
		grpDetail.setExpanded(true);
		compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
		compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
		tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
		
		cmbGroup.setFocus();
	}
	
	private void edit() {
		if (tblMedicine.getSelectionIndex() < 0) {
			return;
		}
		
		btnSearch.setText("Update");
		btnSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-edit-icon.png"));
		
		//Show detail
		TableItem selectedRow = tblMedicine.getSelection()[0];
		
		for (int i = 0; i < lstGroupID.length; i++) {
			if (selectedRow.getText(0).equals(lstGroupID[i])) {
				cmbGroup.select(i);
				break;
			}
		}
		
		txtMedicineID.setText(selectedRow.getText(2));
		txtMedicineName.setText(selectedRow.getText(3));
		txtParameter.setText(selectedRow.getText(4));
		cmbUnit.setText(selectedRow.getText(5));
		txtPrice.setText(selectedRow.getText(6));
		txtInsurancePrice.setText(selectedRow.getText(7));
		txtWholePrice.setText(selectedRow.getText(8));
		cmbManufacturer.setText(selectedRow.getText(9));
		txtCost.setText(selectedRow.getText(10));
		
		grpDetail.setExpanded(true);
		compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
		compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
		tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
		
		cmbGroup.setFocus();
	}
	
	private void delete() {
		medicineDao.delete(medicineDao.findById(tblMedicine.getSelection()[0].getText(2)));
		tblMedicine.remove(tblMedicine.getSelectionIndex());
	}
	
	private void search() {
		btnSearch.setText("Search");
		btnSearch.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-search-icon.png"));
		
		//Reset fields
		clearDetailPanel();
		
		grpDetail.setExpanded(true);
		compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
		compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
		tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
		
		cmbGroup.setFocus();
	}
	
	private void save() {
		transaction.commit(status);
		status = transaction.getTransaction(def);
		
		MessageBox mb = new MessageBox(me, SWT.ICON_INFORMATION | SWT.OK);
		mb.setText("Confirm");
		mb.setMessage("Save successfully!");
		mb.open();
	}
	
	private void cancel() {
		MessageBox mb = new MessageBox(me, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		mb.setText("Confirm");
		mb.setMessage("Are you sure ?");
		int val = mb.open();
		switch (val) {
		case SWT.YES:
			transaction.rollback(status);
			dispose();
		}
		
	}
	
	private void doAction() {
		if (btnSearch.getText().equals("Add")) {
			addRow();
		} else if (btnSearch.getText().equals("Update")) {
			updateRow();
		} else if (btnSearch.getText().equals("Search")) {
			searchInTable();
		}
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

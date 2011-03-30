package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
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

public class MSManagementShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table tblMedicine;
	private Composite compMedicine;
	private PGroup grpDetail;
	private Composite compDetail;
	
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
		
		createContents();
		
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
		tblMedicine.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
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
		toolItem.setToolTipText("Add");
		toolItem.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem tbiEdit = new ToolItem(tbControl, SWT.NONE);
		tbiEdit.setToolTipText("Edit");
		tbiEdit.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-edit-icon.png"));
		
		ToolItem tbiDelete = new ToolItem(tbControl, SWT.NONE);
		tbiDelete.setToolTipText("Delete");
		tbiDelete.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		ToolItem toolItem_3 = new ToolItem(tbControl, SWT.NONE);
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
		
		Label lblMedicinegroup = new Label(compDetail, SWT.NONE);
		lblMedicinegroup.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicinegroup.setBounds(10, 10, 120, 21);
		lblMedicinegroup.setText("Group ID");
		
		Combo combo = new Combo(compDetail, SWT.NONE);
		combo.setBounds(136, 10, 210, 21);
		
		Label lblMedicineName = new Label(compDetail, SWT.NONE);
		lblMedicineName.setText("Name");
		lblMedicineName.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicineName.setBounds(554, 10, 60, 21);
		
		text = new Text(compDetail, SWT.BORDER);
		text.setBounds(620, 10, 210, 21);
		
		Label lblMedicineId = new Label(compDetail, SWT.NONE);
		lblMedicineId.setText("ID");
		lblMedicineId.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicineId.setBounds(362, 10, 36, 21);
		
		text_1 = new Text(compDetail, SWT.BORDER);
		text_1.setBounds(404, 10, 120, 21);
		
		Label lblParameter = new Label(compDetail, SWT.NONE);
		lblParameter.setText("Parameter");
		lblParameter.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblParameter.setBounds(10, 37, 120, 21);
		
		text_2 = new Text(compDetail, SWT.BORDER);
		text_2.setBounds(136, 37, 694, 21);
		
		Label label = new Label(compDetail, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 64, 868, 2);
		
		Label lblPrice = new Label(compDetail, SWT.NONE);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPrice.setBounds(10, 72, 120, 21);
		
		text_3 = new Text(compDetail, SWT.BORDER);
		text_3.setBounds(136, 72, 120, 21);
		
		Label lblCost = new Label(compDetail, SWT.NONE);
		lblCost.setText("Cost");
		lblCost.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblCost.setBounds(262, 72, 60, 21);
		
		text_4 = new Text(compDetail, SWT.BORDER);
		text_4.setBounds(328, 72, 120, 21);
		
		Label lblWholeSalePrice = new Label(compDetail, SWT.NONE);
		lblWholeSalePrice.setText("Whole Sale Price");
		lblWholeSalePrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWholeSalePrice.setBounds(10, 99, 120, 21);
		
		text_5 = new Text(compDetail, SWT.BORDER);
		text_5.setBounds(136, 99, 120, 21);
		
		Label lblInsurancePrice = new Label(compDetail, SWT.NONE);
		lblInsurancePrice.setText("Insurance Price");
		lblInsurancePrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInsurancePrice.setBounds(454, 99, 120, 21);
		
		text_6 = new Text(compDetail, SWT.BORDER);
		text_6.setBounds(580, 100, 120, 21);
		
		Combo combo_1 = new Combo(compDetail, SWT.NONE);
		combo_1.setBounds(328, 99, 120, 21);
		
		Label lblUnit = new Label(compDetail, SWT.NONE);
		lblUnit.setText("Unit");
		lblUnit.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblUnit.setBounds(262, 99, 60, 21);
		
		Combo combo_2 = new Combo(compDetail, SWT.NONE);
		combo_2.setBounds(580, 73, 250, 21);
		
		Label lblManu = new Label(compDetail, SWT.NONE);
		lblManu.setText("Manufacturers");
		lblManu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblManu.setBounds(454, 72, 120, 21);
		
		Button btnAdd = new Button(compDetail, SWT.NONE);
		btnAdd.setText("Search");
		btnAdd.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-search-icon.png"));
		btnAdd.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.BOLD));
		btnAdd.setBounds(740, 99, 89, 26);
	}

	protected void initial() {
		//Initial mode
		grpDetail.setExpanded(true);
		compMedicine.setLocation(compMedicine.getLocation().x, SMALL_MODE_Y);
		compMedicine.setSize(compMedicine.getSize().x, SMALL_MODE_HEIGHT);
		tblMedicine.setSize(tblMedicine.getSize().x, SMALL_MODE_HEIGHT - 4);
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

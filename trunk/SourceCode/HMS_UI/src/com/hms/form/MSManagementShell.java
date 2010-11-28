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

public class MSManagementShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table table;

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
		setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-pill-icon.png"));
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 10, 872, 267);
		
		Label lblMedicinegroup = new Label(composite, SWT.NONE);
		lblMedicinegroup.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicinegroup.setBounds(10, 10, 120, 21);
		lblMedicinegroup.setText("Medicine Group");
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(136, 10, 210, 21);
		
		Label lblMedicineName = new Label(composite, SWT.NONE);
		lblMedicineName.setText("Medicine Name");
		lblMedicineName.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicineName.setBounds(10, 37, 120, 21);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(136, 37, 210, 21);
		
		Label lblMedicineId = new Label(composite, SWT.NONE);
		lblMedicineId.setText("Medicine ID");
		lblMedicineId.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicineId.setBounds(378, 37, 94, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(478, 37, 120, 21);
		
		Label lblParameter = new Label(composite, SWT.NONE);
		lblParameter.setText("Parameter");
		lblParameter.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblParameter.setBounds(10, 64, 120, 21);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(136, 64, 462, 21);
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 91, 868, 2);
		
		Label lblPrice = new Label(composite, SWT.NONE);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPrice.setBounds(10, 99, 120, 21);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(136, 99, 210, 21);
		
		Label lblCost = new Label(composite, SWT.NONE);
		lblCost.setText("Cost");
		lblCost.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblCost.setBounds(10, 126, 120, 21);
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.setBounds(136, 126, 210, 21);
		
		Label lblWholeSalePrice = new Label(composite, SWT.NONE);
		lblWholeSalePrice.setText("Whole Sale Price");
		lblWholeSalePrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWholeSalePrice.setBounds(10, 153, 120, 21);
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setBounds(136, 153, 210, 21);
		
		Label lblInsurancePrice = new Label(composite, SWT.NONE);
		lblInsurancePrice.setText("Insurance Price");
		lblInsurancePrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInsurancePrice.setBounds(10, 180, 120, 21);
		
		text_6 = new Text(composite, SWT.BORDER);
		text_6.setBounds(136, 180, 210, 21);
		
		Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setBounds(478, 100, 210, 21);
		
		Label lblUnit = new Label(composite, SWT.NONE);
		lblUnit.setText("Unit");
		lblUnit.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblUnit.setBounds(378, 99, 94, 21);
		
		Combo combo_2 = new Combo(composite, SWT.NONE);
		combo_2.setBounds(478, 154, 210, 21);
		
		Label lblManu = new Label(composite, SWT.NONE);
		lblManu.setText("Manufacturers");
		lblManu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblManu.setBounds(378, 153, 94, 21);
		
		Button btnAdd = new Button(composite, SWT.NONE);
		btnAdd.setText("Add");
		btnAdd.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
		btnAdd.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnAdd.setBounds(79, 207, 132, 47);
		
		Button btnDelete = new Button(composite, SWT.NONE);
		btnDelete.setText("Delete");
		btnDelete.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-delete-icon.png"));
		btnDelete.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnDelete.setBounds(250, 207, 132, 47);
		
		Button btnSave = new Button(composite, SWT.NONE);
		btnSave.setText("Save");
		btnSave.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnSave.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnSave.setBounds(422, 207, 132, 47);
		
		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.setImage(SWTResourceManager.getImage(MSManagementShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnCancel.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnCancel.setBounds(594, 207, 132, 47);
		
		Composite composite_1 = new Composite(this, SWT.BORDER);
		composite_1.setBounds(10, 283, 872, 377);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(0, 0, 868, 373);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("New Column");
		
		TableColumn tblclmnMSGroup = new TableColumn(table, SWT.CENTER);
		tblclmnMSGroup.setWidth(100);
		tblclmnMSGroup.setText("M S Group");
		
		TableColumn tblclmnMSId = new TableColumn(table, SWT.CENTER);
		tblclmnMSId.setWidth(100);
		tblclmnMSId.setText("M S ID");
		
		TableColumn tblclmnMSName = new TableColumn(table, SWT.CENTER);
		tblclmnMSName.setWidth(100);
		tblclmnMSName.setText("M S Name");
		
		TableColumn tblclmnUnit = new TableColumn(table, SWT.CENTER);
		tblclmnUnit.setWidth(100);
		tblclmnUnit.setText("Unit");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(100);
		tblclmnPrice.setText("Price");
		
		TableColumn tblclmnInsurancePrice = new TableColumn(table, SWT.CENTER);
		tblclmnInsurancePrice.setWidth(100);
		tblclmnInsurancePrice.setText("Insurance Price");
		
		TableColumn tblclmnWholeSalePrice = new TableColumn(table, SWT.CENTER);
		tblclmnWholeSalePrice.setWidth(262);
		tblclmnWholeSalePrice.setText("Whole sale price");
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.MSManagementShell.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

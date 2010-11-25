package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.nebula.widgets.calendarcombo.CalendarCombo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Spinner;

public class PrescriptionShell extends Shell {
	private Text text;
	private Text text_2;
	private Table table;
	private Text text_4;
	private Text text_1;
	private Text text_3;
	private Text text_5;
	private Text text_6;
	private Text text_7;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PrescriptionShell shell = new PrescriptionShell(display);
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
	public PrescriptionShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(PrescriptionShell.class, "/com/hms/icon/hms-invoice-io-icon.png"));
		
		Group grpImportInvoiceInformation = new Group(this, SWT.SHADOW_ETCHED_IN);
		grpImportInvoiceInformation.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpImportInvoiceInformation.setToolTipText("");
		grpImportInvoiceInformation.setText("Prescription information");
		grpImportInvoiceInformation.setBounds(10, 10, 872, 279);
		
		Label lblInvoiceNumber = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblInvoiceNumber.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblInvoiceNumber.setBounds(10, 34, 130, 21);
		lblInvoiceNumber.setText("Prescription No");
		
		text = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text.setBounds(146, 34, 200, 21);
		
		Label lblWarehouse = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblWarehouse.setText("Patient");
		lblWarehouse.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWarehouse.setBounds(10, 70, 130, 21);
		
		text_2 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_2.setBounds(146, 70, 200, 21);
		
		Label label = new Label(grpImportInvoiceInformation, SWT.NONE);
		label.setText("Date");
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(529, 34, 72, 21);
		
		CalendarCombo calendarCombo_1 = new CalendarCombo(grpImportInvoiceInformation, SWT.NONE);
		calendarCombo_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		calendarCombo_1.setBounds(612, 34, 114, 21);
		
		Label label_1 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(0, 61, 872, 3);
		
		Button button = new Button(grpImportInvoiceInformation, SWT.NONE);
		button.setBounds(352, 69, 29, 23);
		button.setText("...");
		
		Label lblSymptom = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblSymptom.setText("Symptom");
		lblSymptom.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblSymptom.setBounds(10, 97, 130, 21);
		
		text_4 = new Text(grpImportInvoiceInformation, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		text_4.setBounds(146, 97, 580, 55);
		
		Label lblDiagnosis = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblDiagnosis.setText("Diagnosis");
		lblDiagnosis.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblDiagnosis.setBounds(10, 158, 130, 21);
		
		text_1 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_1.setBounds(146, 158, 580, 21);
		
		Label label_3 = new Label(grpImportInvoiceInformation, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(0, 185, 872, 3);
		
		Label lblDoctor = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblDoctor.setText("Doctor");
		lblDoctor.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblDoctor.setBounds(10, 195, 130, 21);
		
		text_3 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_3.setBounds(146, 195, 200, 21);
		
		Button button_1 = new Button(grpImportInvoiceInformation, SWT.NONE);
		button_1.setText("...");
		button_1.setBounds(352, 194, 29, 23);
		
		Label lblNote = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblNote.setText("Comments");
		lblNote.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNote.setBounds(10, 222, 130, 21);
		
		text_5 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_5.setBounds(146, 222, 580, 21);
		
		Label lblNotes = new Label(grpImportInvoiceInformation, SWT.NONE);
		lblNotes.setText("Notes");
		lblNotes.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNotes.setBounds(10, 249, 130, 21);
		
		text_6 = new Text(grpImportInvoiceInformation, SWT.BORDER);
		text_6.setBounds(146, 249, 257, 21);
		
		Button btnReexamination = new Button(grpImportInvoiceInformation, SWT.CHECK);
		btnReexamination.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnReexamination.setBounds(409, 249, 114, 21);
		btnReexamination.setText("Re-exam");
		
		Label label_2 = new Label(grpImportInvoiceInformation, SWT.NONE);
		label_2.setText("Date");
		label_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_2.setBounds(529, 249, 72, 21);
		
		CalendarCombo calendarCombo = new CalendarCombo(grpImportInvoiceInformation, SWT.NONE);
		calendarCombo.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		calendarCombo.setBounds(612, 249, 114, 21);
		
		Group grpMedicineMenu = new Group(this, SWT.NONE);
		grpMedicineMenu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		grpMedicineMenu.setText("Medicine menu");
		grpMedicineMenu.setBounds(10, 295, 872, 306);
		
		table = new Table(grpMedicineMenu, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(10, 112, 834, 184);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setText("New Column");
		
		TableColumn tblclmnName = new TableColumn(table, SWT.CENTER);
		tblclmnName.setWidth(100);
		tblclmnName.setText("ID");
		
		TableColumn tblclmnName_1 = new TableColumn(table, SWT.CENTER);
		tblclmnName_1.setWidth(218);
		tblclmnName_1.setText("Name");
		
		TableColumn tblclmnUnit = new TableColumn(table, SWT.CENTER);
		tblclmnUnit.setWidth(82);
		tblclmnUnit.setText("Unit");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(161);
		tblclmnPrice.setText("Price");
		
		TableColumn tblclmnQuantity = new TableColumn(table, SWT.CENTER);
		tblclmnQuantity.setWidth(81);
		tblclmnQuantity.setText("Quantity");
		
		TableColumn tblclmnTotal = new TableColumn(table, SWT.CENTER);
		tblclmnTotal.setWidth(185);
		tblclmnTotal.setText("Total");
		
		ToolBar toolBar = new ToolBar(grpMedicineMenu, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setBounds(842, 112, 24, 44);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setImage(SWTResourceManager.getImage(PrescriptionShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(PrescriptionShell.class, "/com/hms/icon/hms-delete-icon.png"));
		
		Label lblMedicineName = new Label(grpMedicineMenu, SWT.NONE);
		lblMedicineName.setText("Medicine name");
		lblMedicineName.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicineName.setBounds(10, 25, 109, 21);
		
		text_7 = new Text(grpMedicineMenu, SWT.BORDER);
		text_7.setBounds(125, 26, 177, 21);
		
		Button button_2 = new Button(grpMedicineMenu, SWT.NONE);
		button_2.setText("...");
		button_2.setBounds(308, 24, 29, 23);
		
		Label lblMorning = new Label(grpMedicineMenu, SWT.NONE);
		lblMorning.setText("Morning");
		lblMorning.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMorning.setBounds(343, 26, 69, 21);
		
		Spinner spinner = new Spinner(grpMedicineMenu, SWT.BORDER);
		spinner.setBounds(418, 25, 47, 21);
		
		Spinner spinner_1 = new Spinner(grpMedicineMenu, SWT.BORDER);
		spinner_1.setBounds(546, 25, 47, 21);
		
		Label lblNoon = new Label(grpMedicineMenu, SWT.NONE);
		lblNoon.setText("Afternoon");
		lblNoon.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNoon.setBounds(471, 26, 69, 21);
		
		Spinner spinner_2 = new Spinner(grpMedicineMenu, SWT.BORDER);
		spinner_2.setBounds(674, 25, 47, 21);
		
		Label lblEvening = new Label(grpMedicineMenu, SWT.NONE);
		lblEvening.setText("Evening");
		lblEvening.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblEvening.setBounds(599, 26, 69, 21);
		
		Label lblNoOfDate = new Label(grpMedicineMenu, SWT.NONE);
		lblNoOfDate.setText("No of date");
		lblNoOfDate.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNoOfDate.setBounds(727, 25, 69, 21);
		
		Spinner spinner_3 = new Spinner(grpMedicineMenu, SWT.BORDER);
		spinner_3.setBounds(802, 25, 47, 21);
		
		Button btnAdd = new Button(grpMedicineMenu, SWT.NONE);
		btnAdd.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnAdd.setImage(SWTResourceManager.getImage(PrescriptionShell.class, "/com/hms/icon/hms-add-icon.png"));
		btnAdd.setBounds(377, 61, 132, 36);
		btnAdd.setText("Add");
		
		Label label_4 = new Label(grpMedicineMenu, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_4.setBounds(0, 103, 872, 3);
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.setImage(SWTResourceManager.getImage(PrescriptionShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnSave.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnSave.setBounds(545, 614, 134, 46);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setText("Cancel");
		btnCancel.setImage(SWTResourceManager.getImage(PrescriptionShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnCancel.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnCancel.setBounds(710, 614, 134, 46);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Prescription");
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

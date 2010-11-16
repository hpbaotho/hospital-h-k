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

public class PatientManagementShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PatientManagementShell shell = new PatientManagementShell(display);
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
	public PatientManagementShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(PatientManagementShell.class, "/com/hms/icon/hms-patient-icon.png"));
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 10, 872, 240);
		
		Label lblHTn = new Label(composite, SWT.NONE);
		lblHTn.setText(Messages.getString("HMS.PatientManagementShell.label.name"));
		lblHTn.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblHTn.setBounds(10, 10, 120, 21);
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(136, 11, 240, 21);
		
		Label lblM = new Label(composite, SWT.NONE);
		lblM.setText(Messages.getString("HMS.PatientManagementShell.label.id"));
		lblM.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblM.setBounds(396, 10, 100, 21);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(502, 11, 240, 21);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(136, 37, 240, 21);
		
		Label label = new Label(composite, SWT.NONE);
		label.setText(Messages.getString("HMS.PatientManagementShell.label.city"));
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(10, 37, 120, 21);
		
		Label lblGiiTnh = new Label(composite, SWT.NONE);
		lblGiiTnh.setText(Messages.getString("HMS.PatientManagementShell.label.sex"));
		lblGiiTnh.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblGiiTnh.setBounds(396, 37, 100, 21);
		
		Button btnNam = new Button(composite, SWT.RADIO);
		btnNam.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnNam.setBounds(502, 37, 60, 21);
		btnNam.setText(Messages.getString("HMS.PatientManagementShell.label.male"));
		
		Button btnN = new Button(composite, SWT.RADIO);
		btnN.setText(Messages.getString("HMS.PatientManagementShell.label.female"));
		btnN.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnN.setBounds(568, 37, 78, 21);
		
		Label lblaCh = new Label(composite, SWT.NONE);
		lblaCh.setText(Messages.getString("HMS.PatientManagementShell.label.address"));
		lblaCh.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblaCh.setBounds(10, 64, 120, 21);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(136, 64, 240, 21);
		
		Label lblSinThoi = new Label(composite, SWT.NONE);
		lblSinThoi.setText(Messages.getString("HMS.PatientManagementShell.label.phone_number"));
		lblSinThoi.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblSinThoi.setBounds(396, 64, 100, 21);
		
		text_3 = new Text(composite, SWT.BORDER);
		text_3.setBounds(502, 65, 240, 21);
		
		Label lblTinSBnh = new Label(composite, SWT.NONE);
		lblTinSBnh.setText(Messages.getString("HMS.PatientManagementShell.label.history"));
		lblTinSBnh.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTinSBnh.setBounds(10, 91, 120, 21);
		
		text_4 = new Text(composite, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
		text_4.setBounds(136, 91, 606, 82);
		
		Button btnThmMi = new Button(composite, SWT.NONE);
		btnThmMi.setImage(SWTResourceManager.getImage(PatientManagementShell.class, "/com/hms/icon/hms-add-icon.png"));
		btnThmMi.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnThmMi.setBounds(73, 179, 132, 47);
		btnThmMi.setText(Messages.getString("HMS.PatientManagementShell.button.add"));
		
		Button btnXa = new Button(composite, SWT.NONE);
		btnXa.setImage(SWTResourceManager.getImage(PatientManagementShell.class, "/com/hms/icon/hms-delete-icon.png"));
		btnXa.setText(Messages.getString("HMS.PatientManagementShell.button.delete"));
		btnXa.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnXa.setBounds(244, 179, 132, 47);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setImage(SWTResourceManager.getImage(PatientManagementShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnLu.setText(Messages.getString("HMS.PatientManagementShell.button.save"));
		btnLu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnLu.setBounds(416, 179, 132, 47);
		
		Button btnHy = new Button(composite, SWT.NONE);
		btnHy.setImage(SWTResourceManager.getImage(PatientManagementShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnHy.setText(Messages.getString("HMS.PatientManagementShell.button.cancel"));
		btnHy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnHy.setBounds(588, 179, 132, 47);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBounds(10, 256, 872, 404);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(0, 0, 872, 404);
		table.setHeaderVisible(true);
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setText("New Column");
		
		TableColumn tblclmnMBnhNhn = new TableColumn(table, SWT.CENTER);
		tblclmnMBnhNhn.setWidth(108);
		tblclmnMBnhNhn.setText(Messages.getString("HMS.PatientManagementShell.table.header.id"));
		
		TableColumn tblclmnHTn = new TableColumn(table, SWT.CENTER);
		tblclmnHTn.setWidth(212);
		tblclmnHTn.setText(Messages.getString("HMS.PatientManagementShell.table.header.name"));
		
		TableColumn tblclmnNgySinh = new TableColumn(table, SWT.CENTER);
		tblclmnNgySinh.setWidth(100);
		tblclmnNgySinh.setText(Messages.getString("HMS.PatientManagementShell.table.header.day_of_birth"));
		
		TableColumn tblclmnGiiTnh = new TableColumn(table, SWT.CENTER);
		tblclmnGiiTnh.setWidth(88);
		tblclmnGiiTnh.setText(Messages.getString("HMS.PatientManagementShell.table.header.sex"));
		
		TableColumn tblclmnaCh = new TableColumn(table, SWT.CENTER);
		tblclmnaCh.setWidth(359);
		tblclmnaCh.setText(Messages.getString("HMS.PatientManagementShell.table.header.address"));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.HistoryShell.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

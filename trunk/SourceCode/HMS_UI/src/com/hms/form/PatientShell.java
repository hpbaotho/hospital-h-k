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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class PatientShell extends Shell {
	private Text txtID;
	private Text txtName;
	private Text txtDayOfBirth;
	private Button btnDayOfBirth;
	private Button rdoMale;
	private Button rdoFemale;
	private Text txtPhoneNumber;
	private Text txtEmail;
	private Text txtJob;
	private Text txtStreet;
	private Combo cmbWard;
	private Combo cmbDistrict;
	private Combo cmbCity;
	private Text txtAddress;
	private Button chkSocialInsurance; 
	private Text txtType;
	private Text txtFrom;
	private Button btnFrom;
	private Text txtTo;
	private Button btnTo;
	private Text txtPlace;
	private Composite composite_1;
	
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			PatientShell shell = new PatientShell(display);
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
	public PatientShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(PatientShell.class, "/com/hms/icon/hms-patient-icon.png"));
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 10, 622, 500);
		
		Label lblHTn = new Label(composite, SWT.NONE);
		lblHTn.setText("ID");
		lblHTn.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblHTn.setBounds(10, 10, 120, 21);
		
		txtID = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		txtID.setEditable(false);
		txtID.setBounds(136, 11, 240, 21);
		
		Label lblName = new Label(composite, SWT.NONE);
		lblName.setText("Name");
		lblName.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblName.setBounds(10, 37, 120, 21);
		
		txtName = new Text(composite, SWT.BORDER);
		txtName.setBounds(136, 37, 240, 21);
		txtName.setFocus();
		
		Label lblDayOfBirth = new Label(composite, SWT.NONE);
		lblDayOfBirth.setText("Day of birth");
		lblDayOfBirth.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblDayOfBirth.setBounds(10, 64, 120, 21);
		
		txtDayOfBirth = new Text(composite, SWT.BORDER);
		txtDayOfBirth.setTextLimit(10);
		txtDayOfBirth.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		txtDayOfBirth.setBounds(136, 65, 100, 21);
		
		btnDayOfBirth = new Button(composite, SWT.NONE);
		btnDayOfBirth.setImage(SWTResourceManager.getImage(PatientShell.class, "/com/hms/icon/hms-calendar-icon.png"));
		btnDayOfBirth.setBounds(242, 64, 26, 23);
		
		Label lblSex = new Label(composite, SWT.NONE);
		lblSex.setText("Sex");
		lblSex.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblSex.setBounds(10, 91, 120, 21);
		
		composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setBounds(136, 91, 144, 21);
		
		rdoMale = new Button(composite_1, SWT.RADIO);
		rdoMale.setBounds(0, 0, 60, 21);
		rdoMale.setSelection(true);
		rdoMale.setText("Male");
		rdoMale.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		
		rdoFemale = new Button(composite_1, SWT.RADIO);
		rdoFemale.setBounds(66, 0, 78, 21);
		rdoFemale.setText("Female");
		rdoFemale.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		
		Label lblPhoneNumber = new Label(composite, SWT.NONE);
		lblPhoneNumber.setText("Phone number");
		lblPhoneNumber.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPhoneNumber.setBounds(10, 117, 120, 21);
		
		txtPhoneNumber = new Text(composite, SWT.BORDER);
		txtPhoneNumber.setBounds(136, 118, 240, 21);
		
		Label lblEmail = new Label(composite, SWT.NONE);
		lblEmail.setText("Email");
		lblEmail.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblEmail.setBounds(10, 145, 120, 21);
		
		txtEmail = new Text(composite, SWT.BORDER);
		txtEmail.setBounds(136, 146, 240, 21);
		
		Label lblJob = new Label(composite, SWT.NONE);
		lblJob.setText("Career");
		lblJob.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblJob.setBounds(10, 172, 120, 21);
		
		txtJob = new Text(composite, SWT.BORDER);
		txtJob.setBounds(136, 173, 240, 21);
		
		Label lblStreet = new Label(composite, SWT.NONE);
		lblStreet.setText("Street No");
		lblStreet.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblStreet.setBounds(10, 199, 120, 21);
		
		txtStreet = new Text(composite, SWT.BORDER);
		txtStreet.setBounds(136, 200, 240, 21);
		
		Label lblWard = new Label(composite, SWT.NONE);
		lblWard.setText("Ward");
		lblWard.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWard.setBounds(10, 227, 120, 21);
		
		cmbWard = new Combo(composite, SWT.NONE);
		cmbWard.setBounds(136, 227, 240, 21);
		
		Label lblDistrict = new Label(composite, SWT.NONE);
		lblDistrict.setText("District");
		lblDistrict.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblDistrict.setBounds(10, 254, 120, 21);
		
		cmbDistrict = new Combo(composite, SWT.NONE);
		cmbDistrict.setBounds(136, 254, 240, 21);
		
		Label lblCity = new Label(composite, SWT.NONE);
		lblCity.setText("City");
		lblCity.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblCity.setBounds(10, 281, 120, 21);
		
		cmbCity = new Combo(composite, SWT.NONE);
		cmbCity.setBounds(136, 281, 240, 21);
		
		Label lblAddress = new Label(composite, SWT.NONE);
		lblAddress.setText("Address");
		lblAddress.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblAddress.setBounds(10, 308, 120, 21);
		
		txtAddress = new Text(composite, SWT.BORDER);
		txtAddress.setEditable(false);
		txtAddress.setBounds(136, 308, 440, 21);
		
		Label lblSocialInsurance = new Label(composite, SWT.NONE);
		lblSocialInsurance.setText("Social insurance");
		lblSocialInsurance.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblSocialInsurance.setBounds(10, 335, 120, 21);
		
		chkSocialInsurance = new Button(composite, SWT.CHECK);
		chkSocialInsurance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					if (chkSocialInsurance.getSelection()) {
						chkSocialInsurance.setSelection(false);
					} else {
						chkSocialInsurance.setSelection(true);
					}
				}
			}
		});
		chkSocialInsurance.setBounds(136, 336, 19, 20);
		
		Label lblType = new Label(composite, SWT.NONE);
		lblType.setText("Type");
		lblType.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblType.setBounds(10, 362, 120, 21);
		
		txtType = new Text(composite, SWT.BORDER);
		txtType.setBounds(136, 363, 240, 21);
		
		Label lblFrom = new Label(composite, SWT.NONE);
		lblFrom.setText("From");
		lblFrom.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblFrom.setBounds(10, 389, 120, 21);
		
		txtFrom = new Text(composite, SWT.BORDER);
		txtFrom.setTextLimit(10);
		txtFrom.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		txtFrom.setBounds(136, 390, 100, 21);
		
		btnFrom = new Button(composite, SWT.NONE);
		btnFrom.setImage(SWTResourceManager.getImage(PatientShell.class, "/com/hms/icon/hms-calendar-icon.png"));
		btnFrom.setBounds(242, 389, 26, 23);
		
		Label lblTo = new Label(composite, SWT.NONE);
		lblTo.setText("To");
		lblTo.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTo.setBounds(289, 391, 45, 21);
		
		txtTo = new Text(composite, SWT.BORDER);
		txtTo.setTextLimit(10);
		txtTo.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		txtTo.setBounds(340, 391, 100, 21);
		
		btnTo = new Button(composite, SWT.NONE);
		btnTo.setImage(SWTResourceManager.getImage(PatientShell.class, "/com/hms/icon/hms-calendar-icon.png"));
		btnTo.setBounds(446, 390, 26, 23);
		
		Label lblPlace = new Label(composite, SWT.NONE);
		lblPlace.setText("Place");
		lblPlace.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPlace.setBounds(10, 416, 120, 21);
		
		txtPlace = new Text(composite, SWT.BORDER);
		txtPlace.setBounds(136, 417, 240, 21);
		
		
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setImage(SWTResourceManager.getImage(PatientShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnLu.setText(Messages.getString("HMS.PatientManagementShell.button.save"));
		btnLu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnLu.setBounds(136, 450, 132, 35);
		
		Button btnHy = new Button(composite, SWT.NONE);
		btnHy.setImage(SWTResourceManager.getImage(PatientShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnHy.setText(Messages.getString("HMS.PatientManagementShell.button.cancel"));
		btnHy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnHy.setBounds(307, 450, 132, 35);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.HistoryShell.title"));
		setSize(650, 550);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

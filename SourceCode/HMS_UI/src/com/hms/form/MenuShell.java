package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MenuShell extends Shell {

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			MenuShell shell = new MenuShell(display);
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
	 * 
	 * @param display
	 */
	public MenuShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-hospital-icon.png"));

		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);

		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText("Reception");

		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);
		
		MenuItem mntmPatientmanagement = new MenuItem(menu_1, SWT.NONE);
		mntmPatientmanagement.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PatientListShell patientList = new PatientListShell(getDisplay());
				patientList.setLocation(250, 50);
				patientList.open();
				patientList.layout();
			}
		});
		mntmPatientmanagement.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-patient-icon.png"));
		mntmPatientmanagement.setText("PatientManagement");
		
		MenuItem mntmServices = new MenuItem(menu_1, SWT.NONE);
		mntmServices.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ServicesShell services = new ServicesShell(getDisplay());
				services.setLocation(250, 50);
				services.open();
				services.layout();
			}
		});
		mntmServices.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-subclinical-icon.png"));
		mntmServices.setText("Services");
		
		MenuItem mntmCashier = new MenuItem(menu, SWT.CASCADE);
		mntmCashier.setText("Examine");
		
		Menu menu_4 = new Menu(mntmCashier);
		mntmCashier.setMenu(menu_4);
		
		MenuItem mntmBasicExamination = new MenuItem(menu_4, SWT.NONE);
		mntmBasicExamination.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BasicExamShell basicExam = new BasicExamShell(getDisplay());
				basicExam.setLocation(250, 50);
				basicExam.open();
				basicExam.layout();
			}
		});
		mntmBasicExamination.setText("Basic examination");
		
		MenuItem mntmExamination = new MenuItem(menu_4, SWT.NONE);
		mntmExamination.setText("Examination");

		MenuItem mntmMedical = new MenuItem(menu, SWT.CASCADE);
		mntmMedical.setText("Medical");

		Menu menu_2 = new Menu(mntmMedical);
		mntmMedical.setMenu(menu_2);

		MenuItem menuItem_8 = new MenuItem(menu_2, SWT.NONE);
		menuItem_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrescriptionListShell prescription = new PrescriptionListShell(getDisplay());
				prescription.setLocation(250, 50);
				prescription.open();
				prescription.layout();
			}
		});
		menuItem_8.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-prescription-icon.png"));
		menuItem_8.setText(Messages
				.getString("HMS.MenuFrame.menu.doctor.prescription"));

		MenuItem menuItem_10 = new MenuItem(menu_2, SWT.NONE);
		menuItem_10.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-subclinical-icon.png"));
		menuItem_10.setText(Messages
				.getString("HMS.MenuFrame.menu.doctor.subclinical"));

		MenuItem menuItem_11 = new MenuItem(menu_2, SWT.NONE);
		menuItem_11.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-medical-test-icon.png"));
		menuItem_11.setText(Messages
				.getString("HMS.MenuFrame.menu.doctor.medical_test"));

		MenuItem mntmCashier_1 = new MenuItem(menu, SWT.CASCADE);
		mntmCashier_1.setText("Cashier");

		Menu menu_3 = new Menu(mntmCashier_1);
		mntmCashier_1.setMenu(menu_3);

		MenuItem menuItem_13 = new MenuItem(menu_3, SWT.NONE);
		menuItem_13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				InvoiceListShell invoice = new InvoiceListShell(getDisplay());
				invoice.setLocation(250, 50);
				invoice.open();
				invoice.layout();
			}
		});
		menuItem_13.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-invoice-icon.png"));
		menuItem_13.setText(Messages
				.getString("HMS.MenuFrame.menu.invoice.medicine_service"));

		MenuItem menuItem_14 = new MenuItem(menu_3, SWT.NONE);
		menuItem_14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				IMInvoiceListShell imInvoice = new IMInvoiceListShell(getDisplay());
				imInvoice.setLocation(250, 50);
				imInvoice.open();
				imInvoice.layout();
			}
		});
		menuItem_14.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-invoice-io-icon.png"));
		menuItem_14.setText(Messages
				.getString("HMS.MenuFrame.menu.invoice.import"));

		MenuItem menuItem_15 = new MenuItem(menu_3, SWT.NONE);
		menuItem_15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EXInvoiceListShell exInvoice = new EXInvoiceListShell(getDisplay());
				exInvoice.setLocation(250, 50);
				exInvoice.open();
				exInvoice.layout();
			}
		});
		menuItem_15.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-invoice-io-icon.png"));
		menuItem_15.setText(Messages
				.getString("HMS.MenuFrame.menu.invoice.export"));
		
		MenuItem mntmAdministrator = new MenuItem(menu, SWT.CASCADE);
		mntmAdministrator.setText("Administrator");
		
		Menu menu_5 = new Menu(mntmAdministrator);
		mntmAdministrator.setMenu(menu_5);
		
		MenuItem menuItem_1 = new MenuItem(menu_5, SWT.NONE);
		menuItem_1.setText("!HMS.MenuFrame.menu.admin.hospital_info!");
		menuItem_1.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-information-icon.png"));
		
		MenuItem menuItem_2 = new MenuItem(menu_5, SWT.NONE);
		menuItem_2.setText("!HMS.MenuFrame.menu.admin.exit!");
		menuItem_2.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-exit-button-icon.png"));
		
		MenuItem menuItem_3 = new MenuItem(menu_5, SWT.NONE);
		menuItem_3.setText("!HMS.MenuFrame.menu.admin.restore!");
		menuItem_3.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-restore-icon.png"));
		
		MenuItem menuItem_4 = new MenuItem(menu_5, SWT.NONE);
		menuItem_4.setText("!HMS.MenuFrame.menu.admin.backup!");
		menuItem_4.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-backup-icon.png"));
		
		MenuItem menuItem_5 = new MenuItem(menu_5, SWT.NONE);
		menuItem_5.setText("!HMS.MenuFrame.menu.admin.history!");
		menuItem_5.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-history-icon.png"));
		
		MenuItem menuItem_6 = new MenuItem(menu_5, SWT.NONE);
		menuItem_6.setText("!HMS.MenuFrame.menu.admin.admin!");
		menuItem_6.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/hms-admin-icon.png"));

		MenuItem menuItem_9 = new MenuItem(menu, SWT.NONE);
		menuItem_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		menuItem_9.setText(Messages.getString("HMS.MenuFrame.menu.logout"));

		CoolBar coolBar = new CoolBar(this, SWT.FLAT);
		coolBar.setBounds(0, 0, 601, 30);

		CoolItem coolItem = new CoolItem(coolBar, SWT.DROP_DOWN);
		coolItem.setSize(new Point(200, 30));

		ToolBar toolBar = new ToolBar(coolBar, SWT.FLAT | SWT.RIGHT);
		toolBar.setSize(200, 21);

		coolItem.setControl(toolBar);

		ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				InformationShell infoShell = new InformationShell(getDisplay());
				infoShell.setLocation(300, 150);
				infoShell.open();
				infoShell.layout();
			}
		});
		toolItem.setToolTipText(Messages
				.getString("HMS.MenuFrame.menu.admin.hospital_info"));
		toolItem.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-information-icon.png"));

		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setToolTipText(Messages
				.getString("HMS.MenuFrame.menu.admin.admin"));
		toolItem_1.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-admin-icon.png"));

		ToolItem toolItem_2 = new ToolItem(toolBar, SWT.NONE);
		toolItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HistoryShell history = new HistoryShell(getDisplay());
				history.setLocation(250, 50);
				history.open();
				history.layout();
			}
		});
		toolItem_2.setToolTipText(Messages
				.getString("HMS.MenuFrame.menu.admin.history"));
		toolItem_2.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-history-icon.png"));

		ToolItem toolItem_3 = new ToolItem(toolBar, SWT.NONE);
		toolItem_3.setToolTipText(Messages
				.getString("HMS.MenuFrame.menu.admin.backup"));
		toolItem_3.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-backup-icon.png"));

		ToolItem toolItem_4 = new ToolItem(toolBar, SWT.NONE);
		toolItem_4.setToolTipText(Messages
				.getString("HMS.MenuFrame.menu.admin.restore"));
		toolItem_4.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-restore-icon.png"));

		CoolItem coolItem_1 = new CoolItem(coolBar, SWT.DROP_DOWN);
		coolItem_1.setSize(new Point(100, 30));

		ToolBar toolBar_1 = new ToolBar(coolBar, SWT.FLAT | SWT.RIGHT);
		coolItem_1.setControl(toolBar_1);

		ToolItem toolItem_5 = new ToolItem(toolBar_1, SWT.NONE);
		toolItem_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PrescriptionListShell prescriptionShell = new PrescriptionListShell(getDisplay());
				prescriptionShell.setLocation(250, 50);
				prescriptionShell.open();
				prescriptionShell.layout();
			}
		});
		toolItem_5.setToolTipText(Messages
				.getString("HMS.MenuFrame.menu.doctor.prescription"));
		toolItem_5.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-prescription-icon.png"));

		ToolItem toolItem_6 = new ToolItem(toolBar_1, SWT.NONE);
		toolItem_6.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-subclinical-icon.png"));

		ToolItem toolItem_7 = new ToolItem(toolBar_1, SWT.NONE);
		toolItem_7.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-medical-test-icon.png"));

		CoolItem coolItem_2 = new CoolItem(coolBar, SWT.DROP_DOWN);
		coolItem_2.setSize(new Point(150, 30));

		ToolBar toolBar_2 = new ToolBar(coolBar, SWT.FLAT | SWT.RIGHT);
		coolItem_2.setControl(toolBar_2);
		toolBar_2.setSize(100, 21);
		
		final PrintDialog dialog = new PrintDialog(this);

		ToolItem toolItem_8 = new ToolItem(toolBar_2, SWT.NONE);
		toolItem_8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// Opens a dialog and let use user select the
				// target printer and configure various settings.
				PrinterData printerData = dialog.open();
				if (printerData != null) { // If a printer is selected
					// Creates a printer.
					Printer printer = new Printer(printerData);

					// Starts the print job.
					if (printer.startJob("Text")) {
						GC gc = new GC(printer);

						// Starts a new page.
						if (printer.startPage()) {
							gc.drawString("Hospital Management System", 200, 200);

							// Finishes the page.
							printer.endPage();
						}

						gc.dispose();

						// Ends the job.
						printer.endJob();
					}

					// Disposes the printer object after use.
					printer.dispose();
				}
			}
		});
		toolItem_8.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-printer-icon.png"));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.MenuFrame.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

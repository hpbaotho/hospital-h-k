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
		menuItem.setText(Messages.getString("HMS.MenuFrame.menu.admin"));

		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);

		MenuItem menuItem_2 = new MenuItem(menu_1, SWT.NONE);
		menuItem_2.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-information-icon.png"));
		menuItem_2.setText(Messages
				.getString("HMS.MenuFrame.menu.admin.hospital_info"));

		MenuItem menuItem_3 = new MenuItem(menu_1, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AdministratorShell adminShell = new AdministratorShell(getDisplay());
				adminShell.setLocation(250, 50);
				adminShell.open();
				adminShell.layout();
			}
		});
		menuItem_3.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-admin-icon.png"));
		menuItem_3
				.setText(Messages.getString("HMS.MenuFrame.menu.admin.admin"));

		MenuItem menuItem_4 = new MenuItem(menu_1, SWT.NONE);
		menuItem_4.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-history-icon.png"));
		menuItem_4.setText(Messages
				.getString("HMS.MenuFrame.menu.admin.history"));

		MenuItem menuItem_5 = new MenuItem(menu_1, SWT.NONE);
		menuItem_5.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-backup-icon.png"));
		menuItem_5.setText(Messages
				.getString("HMS.MenuFrame.menu.admin.backup"));

		MenuItem menuItem_6 = new MenuItem(menu_1, SWT.NONE);
		menuItem_6.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-restore-icon.png"));
		menuItem_6.setText(Messages
				.getString("HMS.MenuFrame.menu.admin.restore"));

		MenuItem menuItem_7 = new MenuItem(menu_1, SWT.NONE);
		menuItem_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		menuItem_7.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-exit-button-icon.png"));
		menuItem_7.setText(Messages.getString("HMS.MenuFrame.menu.admin.exit"));

		MenuItem menuItem_1 = new MenuItem(menu, SWT.CASCADE);
		menuItem_1.setText(Messages.getString("HMS.MenuFrame.menu.doctor"));

		Menu menu_2 = new Menu(menuItem_1);
		menuItem_1.setMenu(menu_2);

		MenuItem menuItem_8 = new MenuItem(menu_2, SWT.NONE);
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

		MenuItem menuItem_12 = new MenuItem(menu, SWT.CASCADE);
		menuItem_12.setText(Messages.getString("HMS.MenuFrame.menu.invoice"));

		Menu menu_3 = new Menu(menuItem_12);
		menuItem_12.setMenu(menu_3);

		MenuItem menuItem_13 = new MenuItem(menu_3, SWT.NONE);
		menuItem_13.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-invoice-icon.png"));
		menuItem_13.setText(Messages
				.getString("HMS.MenuFrame.menu.invoice.medicine_service"));

		MenuItem menuItem_14 = new MenuItem(menu_3, SWT.NONE);
		menuItem_14.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-invoice-io-icon.png"));
		menuItem_14.setText(Messages
				.getString("HMS.MenuFrame.menu.invoice.import"));

		MenuItem menuItem_15 = new MenuItem(menu_3, SWT.NONE);
		menuItem_15.setImage(SWTResourceManager.getImage(MenuShell.class,
				"/com/hms/icon/hms-invoice-io-icon.png"));
		menuItem_15.setText(Messages
				.getString("HMS.MenuFrame.menu.invoice.export"));

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
				MSSearchShell searchShell = new MSSearchShell(getDisplay());
				searchShell.setLocation(250, 50);
				searchShell.open();
				searchShell.layout();
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

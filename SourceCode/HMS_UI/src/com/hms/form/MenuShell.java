package com.hms.form;

import org.eclipse.swt.SWT;
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MenuShell extends Shell {

	/**
	 * Launch the application.
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
	 * @param display
	 */
	public MenuShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-hospital-icon.png"));
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setText(Messages.getString("HMS.MenuFrame.menu.admin"));
		
		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);
		
		MenuItem menuItem_2 = new MenuItem(menu_1, SWT.NONE);
		menuItem_2.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-information-icon.png"));
		menuItem_2.setText(Messages.getString("HMS.MenuFrame.menu.admin.hospital_info"));
		
		MenuItem menuItem_3 = new MenuItem(menu_1, SWT.NONE);
		menuItem_3.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-admin-icon.png"));
		menuItem_3.setText(Messages.getString("HMS.MenuFrame.menu.admin.admin"));
		
		MenuItem menuItem_4 = new MenuItem(menu_1, SWT.NONE);
		menuItem_4.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-history-icon.png"));
		menuItem_4.setText(Messages.getString("HMS.MenuFrame.menu.admin.history"));
		
		MenuItem menuItem_5 = new MenuItem(menu_1, SWT.NONE);
		menuItem_5.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-backup-icon.png"));
		menuItem_5.setText(Messages.getString("HMS.MenuFrame.menu.admin.backup"));
		
		MenuItem menuItem_6 = new MenuItem(menu_1, SWT.NONE);
		menuItem_6.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-restore-icon.png"));
		menuItem_6.setText(Messages.getString("HMS.MenuFrame.menu.admin.restore"));
		
		MenuItem menuItem_7 = new MenuItem(menu_1, SWT.NONE);
		menuItem_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		menuItem_7.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-exit-button-icon.png"));
		menuItem_7.setText(Messages.getString("HMS.MenuFrame.menu.admin.exit"));
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.CASCADE);
		menuItem_1.setText(Messages.getString("HMS.MenuFrame.menu.doctor"));
		
		Menu menu_2 = new Menu(menuItem_1);
		menuItem_1.setMenu(menu_2);
		
		MenuItem menuItem_8 = new MenuItem(menu_2, SWT.NONE);
		menuItem_8.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-prescription-icon.png"));
		menuItem_8.setText(Messages.getString("HMS.MenuFrame.menu.doctor.prescription"));
		
		MenuItem menuItem_9 = new MenuItem(menu, SWT.NONE);
		menuItem_9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		menuItem_9.setText(Messages.getString("HMS.MenuFrame.menu.logout"));
		
		CoolBar coolBar = new CoolBar(this, SWT.FLAT);
		coolBar.setBounds(0, 0, 330, 30);
		
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
		toolItem.setToolTipText(Messages.getString("HMS.MenuFrame.menu.admin.hospital_info"));
		toolItem.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-information-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setToolTipText(Messages.getString("HMS.MenuFrame.menu.admin.admin"));
		toolItem_1.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-admin-icon.png"));
		
		ToolItem toolItem_2 = new ToolItem(toolBar, SWT.NONE);
		toolItem_2.setToolTipText(Messages.getString("HMS.MenuFrame.menu.admin.history"));
		toolItem_2.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-history-icon.png"));
		
		ToolItem toolItem_3 = new ToolItem(toolBar, SWT.NONE);
		toolItem_3.setToolTipText(Messages.getString("HMS.MenuFrame.menu.admin.backup"));
		toolItem_3.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-backup-icon.png"));
		
		ToolItem toolItem_4 = new ToolItem(toolBar, SWT.NONE);
		toolItem_4.setToolTipText(Messages.getString("HMS.MenuFrame.menu.admin.restore"));
		toolItem_4.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-restore-icon.png"));
		
		CoolItem coolItem_1 = new CoolItem(coolBar, SWT.NONE);
		coolItem_1.setSize(new Point(150, 30));
		
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
		toolItem_5.setToolTipText(Messages.getString("HMS.MenuFrame.menu.doctor.prescription"));
		toolItem_5.setImage(SWTResourceManager.getImage(MenuShell.class, "/com/hms/icon/imx-prescription-icon.png"));
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

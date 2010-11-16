package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HistoryShell extends Shell {
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			HistoryShell shell = new HistoryShell(display);
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
	public HistoryShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(HistoryShell.class, "/com/hms/icon/hms-history-icon.png"));
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(10, 10, 572, 89);
		
		Label lblTNgy = new Label(composite, SWT.NONE);
		lblTNgy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTNgy.setBounds(10, 10, 100, 21);
		lblTNgy.setText(Messages.getString("HMS.HistoryShell.label.from"));
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(116, 10, 125, 21);
		
		Label lblnNgy = new Label(composite, SWT.NONE);
		lblnNgy.setText(Messages.getString("HMS.HistoryShell.label.to"));
		lblnNgy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblnNgy.setBounds(10, 37, 100, 21);
		
		DateTime dateTime_1 = new DateTime(composite, SWT.BORDER);
		dateTime_1.setBounds(116, 37, 125, 21);
		
		Label lblNgiSDng = new Label(composite, SWT.NONE);
		lblNgiSDng.setText(Messages.getString("HMS.HistoryShell.label.user"));
		lblNgiSDng.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNgiSDng.setBounds(247, 10, 100, 21);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setBounds(247, 37, 180, 21);
		
		Button btnHinTh = new Button(composite, SWT.NONE);
		btnHinTh.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnHinTh.setBounds(450, 10, 108, 30);
		btnHinTh.setText(Messages.getString("HMS.HistoryShell.button.display"));
		
		Button btnThot = new Button(composite, SWT.NONE);
		btnThot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
		btnThot.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnThot.setText(Messages.getString("HMS.HistoryShell.button.exit"));
		btnThot.setBounds(450, 45, 108, 30);
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBounds(10, 105, 572, 355);
		
		table = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(0, 0, 572, 355);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(0);
		
		TableColumn tblclmnNgiSDng = new TableColumn(table, SWT.CENTER);
		tblclmnNgiSDng.setWidth(142);
		tblclmnNgiSDng.setText(Messages.getString("HMS.HistoryShell.header.user"));
		
		TableColumn tblclmnThiGian = new TableColumn(table, SWT.CENTER);
		tblclmnThiGian.setWidth(115);
		tblclmnThiGian.setText(Messages.getString("HMS.HistoryShell.header.time"));
		
		TableColumn tblclmnHnhng = new TableColumn(table, SWT.CENTER);
		tblclmnHnhng.setWidth(311);
		tblclmnHnhng.setText(Messages.getString("HMS.HistoryShell.header.action"));
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(1, "admin");
		tableItem.setText(2, "22/22/1000");
		tableItem.setText(3, "Create user");
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText(1, "admin");
		tableItem_1.setText(2, "22/22/1000");
		tableItem_1.setText(3, "Create user");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem mntmDeleteSelectedRows = new MenuItem(menu, SWT.NONE);
		mntmDeleteSelectedRows.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.remove(table.getSelectionIndices());
			}
		});
		mntmDeleteSelectedRows.setText(Messages.getString("HMS.HistoryShell.table.menu.delete_selected_rows"));
		
		MenuItem mntmDeleteAll = new MenuItem(menu, SWT.NONE);
		mntmDeleteAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
			}
		});
		mntmDeleteAll.setText(Messages.getString("HMS.HistoryShell.table.menu.delete_all"));
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.HistoryShell.title"));
		setSize(600, 500);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

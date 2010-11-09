package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InformationShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			InformationShell shell = new InformationShell(display);
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
	public InformationShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		Label label = new Label(this, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(8, 29, 89, 21);
		label.setText(Messages.getString("HMS.InformationShell.label.name"));
		
		text = new Text(this, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text.setBounds(103, 29, 338, 21);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText(Messages.getString("HMS.InformationShell.label.address"));
		label_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_1.setBounds(8, 56, 89, 21);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_1.setBounds(103, 56, 338, 21);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText(Messages.getString("HMS.InformationShell.label.phone_number"));
		label_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_2.setBounds(8, 83, 89, 21);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_2.setBounds(103, 83, 338, 21);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText(Messages.getString("HMS.InformationShell.label.fax_number"));
		label_3.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_3.setBounds(8, 110, 89, 21);
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_3.setBounds(103, 110, 338, 21);
		
		Label label_4 = new Label(this, SWT.NONE);
		label_4.setText(Messages.getString("HMS.InformationShell.label.tax_code"));
		label_4.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_4.setBounds(8, 137, 89, 21);
		
		text_4 = new Text(this, SWT.BORDER);
		text_4.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_4.setBounds(103, 137, 338, 21);
		
		Label label_5 = new Label(this, SWT.NONE);
		label_5.setText(Messages.getString("HMS.InformationShell.label.account"));
		label_5.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_5.setBounds(8, 164, 89, 21);
		
		text_5 = new Text(this, SWT.BORDER);
		text_5.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_5.setBounds(103, 164, 338, 21);
		
		Label label_6 = new Label(this, SWT.NONE);
		label_6.setText(Messages.getString("HMS.InformationShell.label.email"));
		label_6.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_6.setBounds(8, 191, 89, 21);
		
		text_6 = new Text(this, SWT.BORDER);
		text_6.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_6.setBounds(103, 191, 338, 21);
		
		Label label_7 = new Label(this, SWT.NONE);
		label_7.setText(Messages.getString("HMS.InformationShell.label.website"));
		label_7.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_7.setBounds(8, 218, 89, 21);
		
		text_7 = new Text(this, SWT.BORDER);
		text_7.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_7.setBounds(103, 218, 338, 21);
		
		Label label_8 = new Label(this, SWT.NONE);
		label_8.setText(Messages.getString("HMS.InformationShell.label.director"));
		label_8.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_8.setBounds(8, 245, 89, 21);
		
		text_8 = new Text(this, SWT.BORDER);
		text_8.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_8.setBounds(103, 245, 338, 21);
		
		Label label_9 = new Label(this, SWT.NONE);
		label_9.setText(Messages.getString("HMS.InformationShell.label.accountancy"));
		label_9.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_9.setBounds(8, 272, 89, 21);
		
		text_9 = new Text(this, SWT.BORDER);
		text_9.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		text_9.setBounds(103, 272, 338, 21);
		
		final Label label_10 = new Label(this, SWT.BORDER | SWT.WRAP);
		label_10.setImage(SWTResourceManager.getImage(InformationShell.class, "/com/hms/image/hospital21.png"));
		label_10.setBounds(447, 29, 130, 183);
		
		Menu menu = new Menu(label_10);
		label_10.setMenu(menu);
		
		final FileDialog fd = new FileDialog(this, SWT.OPEN);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		        fd.setText("Open");
		        fd.setFilterPath("C:/");
		        String[] filterExt = { "*.png", "*.jpg", "*.*" };
		        fd.setFilterExtensions(filterExt);
		        String selected = fd.open();
		        System.out.println(selected);
		        if (selected != null) {
		        	label_10.setImage(SWTResourceManager.getImage(selected));
		        }
			}
		});
		menuItem.setText(Messages.getString("HMS.InformationShell.menu.change_picture"));
		
		Button button = new Button(this, SWT.NONE);
		button.setImage(SWTResourceManager.getImage(InformationShell.class, "/com/hms/icon/hms-save-icon.png"));
		button.setBounds(447, 216, 130, 77);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.InformationShell.title"));
		setSize(592, 350);
		
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

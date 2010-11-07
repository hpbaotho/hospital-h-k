package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.hms.bundle.Messages;
import com.hms.main.SWTApplication;
import com.swtdesigner.SWTResourceManager;

public class LoginShell extends Shell {
	
	private static Text text;
	private static Text text_1;
	private static Text text_2;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			LoginShell shell = new LoginShell(display);
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
	public LoginShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setImage(SWTResourceManager.getImage(SWTApplication.class, "/com/hms/icon/hms-login-icon.png"));
		setSize(450, 300);
		setText(Messages.getString("HMS.LoginFrame.title"));
		setLocation(400, 200);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_1.setBounds(44, 74, 115, 21);
		label_1.setText(Messages.getString("HMS.LoginFrame.label.user_name"));
		
		text = new Text(this, SWT.BORDER);
		text.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		text.setBounds(165, 68, 221, 27);
		
		text_1 = new Text(this, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Times New Roman", 10, SWT.NORMAL));
		text_1.setBounds(165, 101, 221, 27);
		text_1.setEchoChar('*');
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText(Messages.getString("HMS.LoginFrame.label.password"));
		label_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_2.setBounds(44, 107, 115, 21);
		
		text_2 = new Text(this, SWT.BORDER);
		text_2.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		text_2.setBounds(165, 134, 221, 27);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText(Messages.getString("HMS.LoginFrame.label.server"));
		label_3.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label_3.setBounds(44, 140, 115, 21);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MenuShell menuShell = new MenuShell(Display.getDefault());
				menuShell.setLocation(250, 50);
				menuShell.open();
				menuShell.layout();
			}
		});
		button.setAlignment(SWT.LEFT);
		button.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button.setImage(SWTResourceManager.getImage(SWTApplication.class, "/com/hms/icon/hms-login-button-icon.png"));
		button.setBounds(82, 194, 134, 34);
		button.setText(Messages.getString("HMS.LoginFrame.button.login"));
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		button_1.setAlignment(SWT.LEFT);
		button_1.setText(Messages.getString("HMS.LoginFrame.button.exit"));
		button_1.setImage(SWTResourceManager.getImage(SWTApplication.class, "/com/hms/icon/hms-exit-button-icon.png"));
		button_1.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		button_1.setBounds(237, 194, 134, 34);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}

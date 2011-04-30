package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hms.bundle.Messages;
import com.hms.main.SWTApplication;
import com.hms.model.dao.UserDao;
import com.hms.model.entity.User;
import com.swtdesigner.SWTResourceManager;

public class LoginShell extends Shell {
	
	private static Text txtUserID;
	private static Text txtPassword;
	private static Text txtServer;
	
	private ApplicationContext appContext = null;
	
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
		// -------------------------Get beans------------------------------------
		this.appContext = 
    		new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml");
	
    	final UserDao userDao = (UserDao)appContext.getBean("userDao");
		// -----------------------------------------------------------------------
		
		setImage(SWTResourceManager.getImage(SWTApplication.class, "/com/hms/icon/hms-login-icon.png"));
		setSize(450, 260);
		setText(Messages.getString("HMS.LoginFrame.title"));
		setLocation(400, 200);
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_1.setBounds(44, 71, 115, 18);
		label_1.setText(Messages.getString("HMS.LoginFrame.label.user_name"));
		
		txtUserID = new Text(this, SWT.BORDER);
		txtUserID.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.NORMAL));
		txtUserID.setBounds(165, 68, 221, 24);
		
		txtPassword = new Text(this, SWT.BORDER | SWT.PASSWORD);
		txtPassword.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.NORMAL));
		txtPassword.setBounds(165, 101, 221, 24);
		
		Label label_2 = new Label(this, SWT.NONE);
		label_2.setText(Messages.getString("HMS.LoginFrame.label.password"));
		label_2.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_2.setBounds(44, 104, 115, 18);
		
		txtServer = new Text(this, SWT.BORDER);
		txtServer.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.NORMAL));
		txtServer.setBounds(165, 134, 221, 24);
		
		Label label_3 = new Label(this, SWT.NONE);
		label_3.setText(Messages.getString("HMS.LoginFrame.label.server"));
		label_3.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		label_3.setBounds(44, 137, 115, 18);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				User user = userDao.findByIdAndPass(txtUserID.getText().trim(), txtPassword.getText().trim());
				
				if ( user != null) {
					MenuShell menuShell = new MenuShell(getDisplay(), SWT.SHELL_TRIM, appContext);
					menuShell.setLocation(250, 50);
					menuShell.open();
					menuShell.layout();
				}
			}
		});
		button.setAlignment(SWT.LEFT);
		button.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		button.setImage(SWTResourceManager.getImage(SWTApplication.class, "/com/hms/icon/hms-login-button-icon.png"));
		button.setBounds(108, 189, 103, 24);
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
		button_1.setFont(SWTResourceManager.getFont("Tahoma", 9, SWT.BOLD));
		button_1.setBounds(249, 189, 103, 24);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}

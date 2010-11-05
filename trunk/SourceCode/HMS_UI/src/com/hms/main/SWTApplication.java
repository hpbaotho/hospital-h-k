package com.hms.main;

import java.util.Locale;

import org.eclipse.swt.widgets.Display;
import com.hms.form.LoginShell;

public class SWTApplication {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Locale.setDefault(new Locale("vi", "VN"));
		Display display = Display.getDefault();
		LoginShell shell = new LoginShell(display);

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}

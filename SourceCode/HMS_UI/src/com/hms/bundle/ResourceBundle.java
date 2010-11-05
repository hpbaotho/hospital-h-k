package com.hms.bundle;

import java.util.*;

public class ResourceBundle extends ListResourceBundle {

	public Object[][] getContents() {

		return contents;

	}

	private Object[][] contents = {
	{ "LoginFrame.title", "Login" },
	
	{ "MainWin.button.ok", "OK" },

	{ "MainWin.button.cancel", "Cancel" },

	{ "MainWin.label.hello_world", "Hello World!" },

	};

}
package com.hms.form;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

public class BasicExamShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Table table;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			BasicExamShell shell = new BasicExamShell(display);
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
	public BasicExamShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLocation(-28, -63);
		setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-subclinical-icon.png"));
		setLayout(null);
		
		Group grpBasicExamine = new Group(this, SWT.NONE);
		grpBasicExamine.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		grpBasicExamine.setText("Basic examine");
		grpBasicExamine.setBounds(10, 37, 572, 79);
		
		text_1 = new Text(grpBasicExamine, SWT.BORDER);
		text_1.setBounds(105, 23, 79, 21);
		
		Label lblPulse = new Label(grpBasicExamine, SWT.NONE);
		lblPulse.setText("Pulse");
		lblPulse.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPulse.setBounds(10, 22, 89, 21);
		
		text_2 = new Text(grpBasicExamine, SWT.BORDER);
		text_2.setBounds(105, 50, 79, 21);
		
		Label lblTemperature = new Label(grpBasicExamine, SWT.NONE);
		lblTemperature.setText("Temperature");
		lblTemperature.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTemperature.setBounds(10, 49, 92, 21);
		
		text_3 = new Text(grpBasicExamine, SWT.BORDER);
		text_3.setBounds(285, 24, 79, 21);
		
		Label lblBreathing = new Label(grpBasicExamine, SWT.NONE);
		lblBreathing.setText("Breathing");
		lblBreathing.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblBreathing.setBounds(190, 23, 89, 21);
		
		Label lblBloodPressure = new Label(grpBasicExamine, SWT.NONE);
		lblBloodPressure.setText("Blood pressure");
		lblBloodPressure.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblBloodPressure.setBounds(190, 50, 92, 21);
		
		text_4 = new Text(grpBasicExamine, SWT.BORDER);
		text_4.setBounds(285, 51, 79, 21);
		
		text_5 = new Text(grpBasicExamine, SWT.BORDER);
		text_5.setBounds(483, 23, 79, 21);
		
		Label lblHeight = new Label(grpBasicExamine, SWT.NONE);
		lblHeight.setText("Height");
		lblHeight.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblHeight.setBounds(388, 22, 89, 21);
		
		Label lblWeight = new Label(grpBasicExamine, SWT.NONE);
		lblWeight.setText("Weight");
		lblWeight.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblWeight.setBounds(388, 49, 92, 21);
		
		text_6 = new Text(grpBasicExamine, SWT.BORDER);
		text_6.setBounds(483, 50, 79, 21);
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(136, 10, 200, 21);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Name");
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(10, 10, 120, 21);
		
		Button button = new Button(this, SWT.NONE);
		button.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-search-icon.png"));
		button.setBounds(336, 8, 24, 24);
		
		
		CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 122, 672, 338);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmList = new CTabItem(tabFolder, SWT.NONE);
		tbtmList.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tbtmList.setText("Examination list");
		
		tabFolder.setSelection(tbtmList);
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmList.setControl(composite);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(10, 10, 622, 279);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(0);
		
		TableColumn tblclmnServices = new TableColumn(table, SWT.LEFT);
		tblclmnServices.setWidth(143);
		tblclmnServices.setText("Date");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(81);
		tblclmnPrice.setText("Pulse");
		
		TableColumn tblclmnTemperature = new TableColumn(table, SWT.CENTER);
		tblclmnTemperature.setWidth(98);
		tblclmnTemperature.setText("Temperature");
		
		TableColumn tblclmnBreathing = new TableColumn(table, SWT.CENTER);
		tblclmnBreathing.setWidth(88);
		tblclmnBreathing.setText("Breathing");
		
		TableColumn tblclmnBpressure = new TableColumn(table, SWT.CENTER);
		tblclmnBpressure.setWidth(88);
		tblclmnBpressure.setText("B.Pressure");
		
		TableColumn tblclmnHeight = new TableColumn(table, SWT.CENTER);
		tblclmnHeight.setWidth(56);
		tblclmnHeight.setText("Height");
		
		TableColumn tblclmnWeight = new TableColumn(table, SWT.CENTER);
		tblclmnWeight.setWidth(62);
		tblclmnWeight.setText("Weight");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {"", "03/03/2011", "0", "0", "0", "0", "0", "0"});
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText(new String[] {"", "04/03/2011", "0", "0", "0", "0", "0", "0"});
		
		
		ToolBar toolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setBounds(638, 10, 24, 44);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-delete-icon.png"));
	    
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Basic examination");
		setSize(700, 500);
		setLocation(50, 200);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

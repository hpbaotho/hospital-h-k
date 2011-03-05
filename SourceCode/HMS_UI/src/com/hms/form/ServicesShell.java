package com.hms.form;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ServicesShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Table table;
	private List<Control> selectedRowEditor = null;
	private int selectedRowIndex = -1;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ServicesShell shell = new ServicesShell(display);
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
	public ServicesShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setLocation(-28, -63);
		setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-subclinical-icon.png"));
		setLayout(null);
		
		Group grpBasicExamine = new Group(this, SWT.NONE);
		grpBasicExamine.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.BOLD));
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
		button.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-search-icon.png"));
		button.setBounds(336, 8, 24, 24);
		
		Group grpServices = new Group(this, SWT.NONE);
		grpServices.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.BOLD));
		grpServices.setText("Services");
		grpServices.setBounds(10, 122, 572, 338);
		
		Label lblMedicineId = new Label(grpServices, SWT.NONE);
		lblMedicineId.setText("Services");
		lblMedicineId.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMedicineId.setBounds(10, 23, 89, 21);
		
		Combo combo = new Combo(grpServices, SWT.NONE);
		combo.setBounds(10, 50, 215, 21);
		
		text_7 = new Text(grpServices, SWT.BORDER);
		text_7.setBounds(260, 50, 156, 21);
		
		Label lblPrice = new Label(grpServices, SWT.NONE);
		lblPrice.setText("Price");
		lblPrice.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblPrice.setBounds(260, 22, 92, 21);
		
		table = new Table(grpServices, SWT.BORDER | SWT.FULL_SELECTION);

		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if (selectedRowIndex != -1) {
					disableTableEditor((Table) e.widget, selectedRowIndex);
				}
				
				selectedRowIndex = ((Table) e.widget).getSelectionIndex();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				enableTableEditor((Table) e.widget);
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					enableTableEditor((Table) e.widget);
				}
			}
		});
		table.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		table.setBounds(10, 77, 538, 251);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(0);
		
		TableColumn tblclmnServices = new TableColumn(table, SWT.CENTER);
		tblclmnServices.setWidth(287);
		tblclmnServices.setText("Services");
		
		TableColumn tblclmnPrice = new TableColumn(table, SWT.CENTER);
		tblclmnPrice.setWidth(245);
		tblclmnPrice.setText("Price");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] {"", "Kham mat", "15.000"});
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText(new String[] {"", "Kham tai - mui - hong", "20.000"});
		
		ToolBar toolBar = new ToolBar(grpServices, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setBounds(548, 77, 24, 44);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-delete-icon.png"));

		//Table editor
		/*TableItem[] items = table.getItems();
	    for (int i = 0; i < items.length; i++) {
	      TableEditor editor = new TableEditor(table);
	      CCombo comboEditor = new CCombo(table, SWT.NONE);
	      comboEditor.setItems(new String[] {"Kham mat", "Kham tai - mui - hong"});
	      comboEditor.setText(items[i].getText(0));
	      comboEditor.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
	      editor.grabHorizontal = true;
	      editor.setEditor(comboEditor, items[i], 0);
	      editor = new TableEditor(table);
	      Text text = new Text(table, SWT.CENTER);
	      text.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
	      text.setText(items[i].getText(1));
	      editor.grabHorizontal = true;
	      editor.minimumWidth = text.getSize().x;
	      editor.setEditor(text, items[i], 1);
	    }*/
	    
		createContents();
	}

	protected void enableTableEditor(final Table table) {
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ESC) {
					disableTableEditor(table, table.getSelectionIndex());
				}
			}
		};
		
		if (this.selectedRowEditor == null) {
			this.selectedRowEditor = new LinkedList<Control>();
		} else {
			this.selectedRowEditor.clear();
		}

		TableEditor editor = new TableEditor(table);
	    CCombo comboEditor = new CCombo(table, SWT.CENTER);
		comboEditor.setItems(new String[] {"Kham mat", "Kham tai - mui - hong"});
		comboEditor.setText(table.getSelection()[0].getText(1));
		comboEditor.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		comboEditor.addKeyListener(keyAdapter);		
		editor.grabHorizontal = true;
		editor.setEditor(comboEditor, table.getSelection()[0], 1);
		this.selectedRowEditor.add(comboEditor);
		
		editor = new TableEditor(table);
		Text text = new Text(table, SWT.CENTER);
		text.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		text.setText(table.getSelection()[0].getText(2));
		editor.grabHorizontal = true;
		editor.minimumWidth = text.getSize().x;
		editor.setEditor(text, table.getSelection()[0], 2);
		this.selectedRowEditor.add(text);
		
		comboEditor.setFocus();
	}
	
	protected void disableTableEditor(Table table, int indexEditor) {
		TableItem selectedItem = null;
		Control editor = null;
		
		if (table == null) {
			return;
		}
		
		if (indexEditor != -1) {
			selectedItem = table.getItem(indexEditor);
		} else {
			return;
		}

		if (selectedRowEditor != null && (selectedRowEditor.size() == table.getColumnCount() - 1)) {
			for (int i = 1; i < table.getColumnCount(); i++) {
				editor = selectedRowEditor.get(i - 1);
				
				if ( editor!= null) {
					if (editor.getClass().toString().equalsIgnoreCase("class org.eclipse.swt.custom.CCombo")) {
						selectedItem.setText(i, ((CCombo) editor).getText());
					} else if (editor.getClass().toString().equalsIgnoreCase("class org.eclipse.swt.widgets.Text")) {
						selectedItem.setText(i, ((Text) editor).getText());
					}
					editor.dispose();
				}
			}
			
//			for (Control control: selectedRowEditor) {
//				System.out.println(control.getClass().toString());
//				control.dispose();
//			}
			selectedRowEditor.clear();
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Services");
		setSize(600, 500);
		setLocation(50, 200);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

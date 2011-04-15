package com.hms.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.form.lov.PatientLOV;
import com.hms.model.dao.BasicMedicalRecordDao;
import com.hms.model.entity.BasicMedicalRecord;
import com.hms.model.entity.Item;
import com.hms.util.calendar.SWTCalendarDialog;
import com.hms.util.calendar.SWTCalendarEvent;
import com.hms.util.calendar.SWTCalendarListener;
import com.swtdesigner.SWTResourceManager;
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
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class BasicExamShell extends Shell {
	private Text txtPatient;
	private Text txtPulse;
	private Text txtTemperature;
	private Text txtBreathing;
	private Text txtBloodPressure;
	private Text txtHeight;
	private Text txtWeight;
	private Table tblExam;
	private Text txtServiceDate;
	private Button btnServiceDate;
	private Composite compPatient = null;
	private CTabFolder tabFolder;
	
	private String patientID = "";
	private KeyAdapter keyAdapter = null;
	private TableItem tblitemEditing = null;
	private SWTCalendarDialog calendarDialog = null;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	// DAO
	private ApplicationContext appContext = null;
	private BasicMedicalRecordDao basicMedicalRecordDao = null;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			BasicExamShell shell = new BasicExamShell(display, SWT.SHELL_TRIM, new ClassPathXmlApplicationContext("com/hms/model/config/Beans.xml"));
			shell.setLocation(50, 50);
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
	public BasicExamShell(Display display, int style, ApplicationContext appContext) {
		super(display, style);
	    
		this.appContext = appContext;
		
		//Get beans
		basicMedicalRecordDao = (BasicMedicalRecordDao) appContext.getBean("basicMedicalRecordDao");
		
		this.createContents();
		
		this.initial();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Basic examination");
		setSize(700, 500);
		setLocation(50, 200);
		setLocation(-28, -63);
		setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-subclinical-icon.png"));
		setLayout(null);
		
		txtPatient = new Text(this, SWT.BORDER);
		txtPatient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F1) {
					openPatientLOV();
				}
			}
		});
		txtPatient.setBounds(136, 10, 200, 21);
		
		Label label = new Label(this, SWT.NONE);
		label.setText("Name");
		label.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		label.setBounds(10, 10, 120, 21);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openPatientLOV();
			}
		});
		button.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-search-icon.png"));
		button.setBounds(336, 8, 24, 24);
		
		
		tabFolder = new CTabFolder(this, SWT.BORDER);
		tabFolder.setSimple(false);
		tabFolder.setBounds(10, 37, 672, 423);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		CTabItem tbtmList = new CTabItem(tabFolder, SWT.NONE);
		tbtmList.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
		tbtmList.setText("Examination list");
		
		tabFolder.setSelection(tbtmList);
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmList.setControl(composite);
		
		tblExam = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		
		tblExam.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		tblExam.setBounds(10, 10, 631, 377);
		tblExam.setHeaderVisible(true);
		tblExam.setLinesVisible(true);
		
		TableColumn tblclmnRecordID = new TableColumn(tblExam, SWT.NONE);
		tblclmnRecordID.setWidth(0);
		
		TableColumn tblclmnServices = new TableColumn(tblExam, SWT.LEFT);
		tblclmnServices.setWidth(145);
		tblclmnServices.setText("Date");
		
		TableColumn tblclmnPrice = new TableColumn(tblExam, SWT.CENTER);
		tblclmnPrice.setWidth(81);
		tblclmnPrice.setText("Pulse");
		
		TableColumn tblclmnTemperature = new TableColumn(tblExam, SWT.CENTER);
		tblclmnTemperature.setWidth(98);
		tblclmnTemperature.setText("Temperature");
		
		TableColumn tblclmnBreathing = new TableColumn(tblExam, SWT.CENTER);
		tblclmnBreathing.setWidth(88);
		tblclmnBreathing.setText("Breathing");
		
		TableColumn tblclmnBpressure = new TableColumn(tblExam, SWT.CENTER);
		tblclmnBpressure.setWidth(88);
		tblclmnBpressure.setText("B.Pressure");
		
		TableColumn tblclmnHeight = new TableColumn(tblExam, SWT.CENTER);
		tblclmnHeight.setWidth(56);
		tblclmnHeight.setText("Height");
		
		TableColumn tblclmnWeight = new TableColumn(tblExam, SWT.CENTER);
		tblclmnWeight.setWidth(70);
		tblclmnWeight.setText("Weight");
		
		
		ToolBar toolBar = new ToolBar(composite, SWT.FLAT | SWT.RIGHT | SWT.VERTICAL);
		toolBar.setBounds(642, 10, 24, 66);
		
		ToolItem toolItem = new ToolItem(toolBar, SWT.NONE);
		toolItem.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-add-icon.png"));
		
		ToolItem toolItem_2 = new ToolItem(toolBar, SWT.NONE);
		toolItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tblitemEditing == null) {
					tblitemEditing = tblExam.getSelection()[0];
					setTableItemEditor(tblitemEditing);
				} else {
					unsetTableItemEditor(tblitemEditing);
					tblitemEditing = null;
				}
			}
		});
		toolItem_2.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-edit-icon.png"));
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.setImage(SWTResourceManager.getImage(BasicExamShell.class, "/com/hms/icon/hms-delete-icon.png"));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void initial() {
		//Initialize KeyAdapter
    	keyAdapter = new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent e) {
    			if (e.keyCode == SWT.F1) {

    			}
    		}
    	};
	}
	
	protected void fillTable(Table table, List<BasicMedicalRecord> lstBasicMedic) {
		TableItem tableItem = null;
		String[] rowData = null;
		
		if (lstBasicMedic != null) {
			for (BasicMedicalRecord basicMedic : lstBasicMedic) {
				tableItem = new TableItem(table, SWT.NONE);
				rowData = new String[table.getColumnCount()];
				
				if (basicMedic.getBasicRecordID() != null) {
					rowData[0] = basicMedic.getBasicRecordID();
				} else {
					rowData[0] = "";
				}
				
				if (basicMedic.getRecordDate() != null) {
					rowData[1] = basicMedic.getRecordDate().toString();
				} else {
					rowData[1] = "";
				}
				try {
					rowData[2] = String.valueOf(basicMedic.getPulse());
				} catch (Exception e) {
					rowData[2] = "";
				}
				try {
					rowData[3] = String.valueOf(basicMedic.getTemperature());
				} catch (Exception e) {
					rowData[3] = "";
				}
				try {
					rowData[4] = String.valueOf(basicMedic.getBreathing());
				} catch (Exception e) {
					rowData[4] = "";
				}
				try {
					rowData[5] = String.valueOf(basicMedic.getBloodPressure());
				} catch (Exception e) {
					rowData[5] = "";
				}
				try {
					rowData[6] = String.valueOf(basicMedic.getHeight());
				} catch (Exception e) {
					rowData[6] = "";
				}
				try {
					rowData[7] = String.valueOf(basicMedic.getWeight());
				} catch (Exception e) {
					rowData[7] = "";
				}
				
				tableItem.setText(rowData);
			}
		}
	}
	
	private void openPatientLOV() {
		PatientLOV patientLOV = new PatientLOV(getShell(), SWT.DIALOG_TRIM, appContext);
		patientLOV.setLocation(250, 50);
		Item result = (Item) patientLOV.open();
		
		if (result != null) {
			txtPatient.setText(result.getValue());
			patientID = result.getLabel();
			
			tblExam.removeAll();
			
			List<BasicMedicalRecord> listBasicMedic = basicMedicalRecordDao.findByPatientId(patientID);
			
			if (listBasicMedic != null) {
				fillTable(tblExam, listBasicMedic);
			}
		}
	}

	private void setTableItemEditor(final TableItem item) {
		TableEditor editor = new TableEditor(item.getParent());
	    
		compPatient = new Composite(item.getParent(), SWT.NONE);
	    txtServiceDate = new Text(compPatient, SWT.CENTER);
	    txtServiceDate.setBounds(0, 0, 120, 21);
	    txtServiceDate.setText(item.getText(1));
	    txtServiceDate.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
	    txtServiceDate.addKeyListener(keyAdapter);
		btnServiceDate = new Button(compPatient, SWT.CENTER);
		btnServiceDate.setBounds(121, 0, 24, 20);
		btnServiceDate.setImage(SWTResourceManager.getImage(ServicesShell.class, "/com/hms/icon/hms-calendar-icon.png"));
		btnServiceDate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showCalendar(getDisplay(), txtServiceDate);
			}
		});
		editor.grabHorizontal = true;
		editor.setEditor(compPatient, item, 1);
		
		editor = new TableEditor(item.getParent());
		txtPulse = new Text(item.getParent(), SWT.CENTER);
		txtPulse.setText(item.getText(2));
		txtPulse.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));	
		txtPulse.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.setEditor(txtPulse, item, 2);
		
		editor = new TableEditor(item.getParent());
		txtTemperature = new Text(item.getParent(), SWT.CENTER);
		txtTemperature.setFont(SWTResourceManager.getFont("Tahoma",10, SWT.NORMAL));
		txtTemperature.setText(item.getText(3));
		txtTemperature.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.setEditor(txtTemperature, item, 3);
		
		editor = new TableEditor(item.getParent());
		txtBreathing = new Text(item.getParent(), SWT.CENTER);
		txtBreathing.setText(item.getText(4));
		txtBreathing.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));	
		txtBreathing.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.setEditor(txtBreathing, item, 4);
		
		editor = new TableEditor(item.getParent());
		txtBloodPressure = new Text(item.getParent(), SWT.CENTER);
		txtBloodPressure.setFont(SWTResourceManager.getFont("Tahoma",10, SWT.NORMAL));
		txtBloodPressure.setText(item.getText(5));
		txtBloodPressure.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.setEditor(txtBloodPressure, item, 5);
		
		editor = new TableEditor(item.getParent());
		txtHeight = new Text(item.getParent(), SWT.CENTER);
		txtHeight.setText(item.getText(6));
		txtHeight.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));	
		txtHeight.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.setEditor(txtHeight, item, 6);
		
		editor = new TableEditor(item.getParent());
		txtWeight = new Text(item.getParent(), SWT.CENTER);
		txtWeight.setFont(SWTResourceManager.getFont("Tahoma",10, SWT.NORMAL));
		txtWeight.setText(item.getText(7));
		txtWeight.addKeyListener(keyAdapter);
		editor.grabHorizontal = true;
		editor.setEditor(txtWeight, item, 7);
		
		txtServiceDate.setFocus();
	}

	private void unsetTableItemEditor(TableItem item) {
		//Return if item is null
		if (item == null) {
			return;
		}
		
		if (txtServiceDate != null && txtPulse != null && txtTemperature != null && txtBreathing != null
			&& txtBloodPressure != null && txtHeight != null && txtWeight != null) {
			item.setText(1, txtServiceDate.getText());
			item.setText(2, txtPulse.getText());
			item.setText(3, txtTemperature.getText());
			item.setText(4, txtBreathing.getText());
			item.setText(5, txtBloodPressure.getText());
			item.setText(6, txtHeight.getText());
			item.setText(7, txtWeight.getText());
			
			BasicMedicalRecord curBasicMedicRecord = basicMedicalRecordDao.findById(item.getText(0));
			
			if (curBasicMedicRecord != null) {
				curBasicMedicRecord.setRecordDate(java.sql.Date.valueOf(item.getText(1)));
				curBasicMedicRecord.setPulse(Double.valueOf(item.getText(2)));
				curBasicMedicRecord.setTemperature(Double.valueOf(item.getText(3)));
				curBasicMedicRecord.setBreathing(Double.valueOf(item.getText(4)));
				curBasicMedicRecord.setBloodPressure(Double.valueOf(item.getText(5)));
				curBasicMedicRecord.setHeight(Double.valueOf(item.getText(6)));
				curBasicMedicRecord.setWeight(Double.valueOf(item.getText(7)));
				basicMedicalRecordDao.update(curBasicMedicRecord);
			} else {
				String bmrID = "BMR_";
				String[] strDate = null;
				
				try {
					strDate = formatter.format(new Date()).split("/");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return;
				}
				
				if (strDate.length == 3) {
					bmrID += strDate[2] + strDate[1] + strDate[0];
				} else {
					return;
				}

				curBasicMedicRecord = new BasicMedicalRecord();
				curBasicMedicRecord.setBasicRecordID(bmrID);
				curBasicMedicRecord.setPatientID(patientID);
				curBasicMedicRecord.setRecordDate(java.sql.Date.valueOf(item.getText(1)));
				curBasicMedicRecord.setPulse(Double.valueOf(item.getText(2)));
				curBasicMedicRecord.setTemperature(Double.valueOf(item.getText(3)));
				curBasicMedicRecord.setBreathing(Double.valueOf(item.getText(4)));
				curBasicMedicRecord.setBloodPressure(Double.valueOf(item.getText(5)));
				curBasicMedicRecord.setHeight(Double.valueOf(item.getText(6)));
				curBasicMedicRecord.setWeight(Double.valueOf(item.getText(7)));
				basicMedicalRecordDao.save(curBasicMedicRecord);
				item.setText(0, bmrID);
			}
			
			//Destroy row editor
			txtServiceDate.dispose();
			btnServiceDate.dispose();
			compPatient.dispose();
			txtPulse.dispose();
			txtTemperature.dispose();
			txtBreathing.dispose();
			txtBloodPressure.dispose();
			txtHeight.dispose();
			txtWeight.dispose();
			
			txtServiceDate = null;
			btnServiceDate = null;
			compPatient = null;
			txtPulse = null;
			txtTemperature = null;
			txtBreathing = null;
			txtBloodPressure = null;
			txtHeight = null;
			txtWeight = null;
		}
	}
	
	//Calendar
	private void showCalendar(Display display, final Text calendarField) {
		calendarDialog = new SWTCalendarDialog(getDisplay());
		
        calendarDialog.addDateChangedListener(new SWTCalendarListener() {

            public void dateChanged(SWTCalendarEvent calendarEvent) {

                calendarField.setText(formatter.format(calendarEvent.getCalendar().getTime()));

            }

        });
        
        calendarDialog.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent event) {
        		if (event.keyCode == 13 || event.keyCode == SWT.F1) {
        			calendarField.setText(formatter.format(calendarDialog.getCalendar().getTime()));
        			calendarDialog.close();
        		} else if (event.keyCode == SWT.F4 || event.keyCode == SWT.ESC) {
        			calendarDialog.close();
        		}
        	}
        });
        
        calendarDialog.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDoubleClick(MouseEvent event) {
        			calendarField.setText(formatter.format(calendarDialog.getCalendar().getTime()));
        			calendarDialog.close();
        	}
        });
        
        if (calendarField.getText() != null && calendarField.getText().length() > 0) {

            try {

                Date d = formatter.parse(calendarField.getText());

                calendarDialog.setDate(d);

            } catch (ParseException pe) {
            	
            }

        }
        
        int selectedIndex = tblExam.getSelectionIndex();
        
        calendarDialog.open(getShell().getBounds().x + tabFolder.getBounds().x + tblExam.getBounds().x + compPatient.getBounds().x + calendarField.getBounds().x, 
        		50 + getShell().getBounds().y + tabFolder.getBounds().y + tblExam.getBounds().y + compPatient.getBounds().y + calendarField.getBounds().y + (selectedIndex + 1) * 10);
	}
}

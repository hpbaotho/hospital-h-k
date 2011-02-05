package com.hms.form;

import net.sf.swtaddons.autocomplete.combo.AutocompleteComboSelector;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.hms.model.table.sort.TableTextSortModel;
import com.hms.util.calendar.SWTCalendarDialog;
import com.hms.util.calendar.SWTCalendarEvent;
import com.hms.util.calendar.SWTCalendarListener;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.TypedEvent;

import java.awt.Event;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class HistoryShell extends Shell {
	private Table table;
	private Text text;
	private SWTCalendarDialog calendarDialog = null;
	final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private Composite composite = null;
	private Button btnCalendarTo = null;
	private Composite composite2 = null;
	private Text text_1;
	private Combo combo = null;
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
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.F4) {
					close();
				}
			}
		});
		setImage(SWTResourceManager.getImage(HistoryShell.class, "/com/hms/icon/hms-history-icon.png"));
		
		this.getComposite();
		
		table = new Table(this.getComposite2(), SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.keyCode);
				
				if (e.keyCode == SWT.F4) {
					close();
				} else if (e.keyCode == SWT.TAB) {
					System.out.println("Tab on table");
					text_1.setFocus();
				}
			}
		});
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
		tableItem.setText(1, "admin1");
		tableItem.setText(2, "22/12/1000");
		tableItem.setText(3, "Create user2");
		
		TableItem tableItem_1 = new TableItem(table, SWT.NONE);
		tableItem_1.setText(1, "admin2");
		tableItem_1.setText(2, "19/11/1000");
		tableItem_1.setText(3, "Create user1");
		
		//Add sort function
		Listener textSortListener = new TableTextSortModel(this.table);
		
		tblclmnNgiSDng.addListener(SWT.Selection, textSortListener);
		tblclmnThiGian.addListener(SWT.Selection, textSortListener);
		tblclmnHnhng.addListener(SWT.Selection, textSortListener);
		
		table.setSortColumn(tblclmnNgiSDng);
		
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
        
        calendarDialog.open(getShell().getBounds().x + getComposite().getBounds().x + calendarField.getBounds().x, 50 + getShell().getBounds().y + getComposite().getBounds().y + calendarField.getBounds().y);
	}
	
	private Composite getComposite() {
		if (composite == null) {
			composite = new Composite(this, SWT.BORDER);
			composite.setBounds(10, 10, 572, 89);
			
			//From date
			Label lblTNgy = new Label(this.getComposite(), SWT.NONE);
			lblTNgy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
			lblTNgy.setBounds(10, 10, 100, 21);
			lblTNgy.setText(Messages.getString("HMS.HistoryShell.label.from"));
			
			text_1 = new Text(composite, SWT.BORDER);
			text_1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					text_1.selectAll();
				}
			});
			text_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if ((e.keyCode >= ' ' && e.keyCode <= '.')
							|| (e.keyCode >= ':' && e.keyCode <= '~')) {
							e.doit = false;
					} else if (e.keyCode == SWT.F1) {
						showCalendar(getDisplay(), text_1);
					} else if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			text_1.setTextLimit(10);
			text_1.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
			text_1.setBounds(116, 9, 100, 21);
			text_1.setTabs(0);
			
			Button button = new Button(composite, SWT.NONE);
			button.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					showCalendar(getDisplay(), text_1);
				}
			});
			button.setImage(SWTResourceManager.getImage(HistoryShell.class, "/com/hms/icon/calendar-copy-icon4.png"));
			button.setBounds(215, 8, 26, 23);
			
			//To date
			Label lblnNgy = new Label(this.getComposite(), SWT.NONE);
			lblnNgy.setText(Messages.getString("HMS.HistoryShell.label.to"));
			lblnNgy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
			lblnNgy.setBounds(10, 37, 100, 21);
			
			text = new Text(this.getComposite(), SWT.BORDER);
			text.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					text.selectAll();
				}
			});
			text.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if ((e.keyCode >= ' ' && e.keyCode <= '.')
						|| (e.keyCode >= ':' && e.keyCode <= '~')) {
						e.doit = false;
					} else if (e.keyCode == SWT.F1) {
						showCalendar(getDisplay(), text);
					} else if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			text.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
			text.setBounds(116, 37, 100, 21);
			text.setTextLimit(10);
			
			btnCalendarTo = new Button(composite, SWT.NONE);
			btnCalendarTo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			
			btnCalendarTo.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					showCalendar(getDisplay(), text);
				}
			});
			btnCalendarTo.setImage(SWTResourceManager.getImage(HistoryShell.class, "/com/hms/icon/hms-calendar-icon.png"));
			btnCalendarTo.setBounds(215, 36, 26, 23);
			
			// User
			Label lblNgiSDng = new Label(this.getComposite(), SWT.NONE);
			lblNgiSDng.setText(Messages.getString("HMS.HistoryShell.label.user"));
			lblNgiSDng.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
			lblNgiSDng.setBounds(257, 10, 100, 21);
			
			combo = new Combo(this.getComposite(), SWT.NONE);
			combo.setFont(SWTResourceManager.getFont("Tahoma", 10, SWT.NORMAL));
			combo.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.keyCode == SWT.F1) {
						combo.setListVisible(true);
					} else if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			combo.setVisibleItemCount(5);
			combo.setItems(new String[] {"admin1", "admin2", "admin3", "doctor1", "doctor2", "doctor3", "doctor4", "casher1", "casher2", "casher3", "casher4", "casher5"});
			combo.setBounds(257, 37, 170, 21);
			
			//Autocomplete function for combobox
			new AutocompleteComboSelector(combo);
			
			Button btnHinTh = new Button(this.getComposite(), SWT.NONE);
			btnHinTh.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			btnHinTh.setImage(SWTResourceManager.getImage(HistoryShell.class, "/com/hms/icon/hms-search-icon.png"));
			btnHinTh.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
			btnHinTh.setBounds(450, 10, 108, 30);
			btnHinTh.setText(Messages.getString("HMS.HistoryShell.button.display"));
			
			Button btnThot = new Button(this.getComposite(), SWT.NONE);
			btnThot.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.keyCode == SWT.F4) {
						close();
					}
				}
			});
			btnThot.setImage(SWTResourceManager.getImage(HistoryShell.class, "/com/hms/icon/hms-cancel-icon.png"));
			btnThot.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					dispose();
				}
			});
			btnThot.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
			btnThot.setText(Messages.getString("HMS.HistoryShell.button.exit"));
			btnThot.setBounds(450, 45, 108, 30);
		}
		
		return composite;
	}
	
	private Composite getComposite2() {
		if (composite2 == null) {
			composite2 = new Composite(this, SWT.NONE);
			composite2.setBounds(10, 105, 572, 355);
		}
		
		return composite2;
	}
	
}

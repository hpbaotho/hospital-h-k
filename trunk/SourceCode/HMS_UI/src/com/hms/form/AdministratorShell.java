package com.hms.form;

import java.util.LinkedList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.hms.bundle.Messages;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AdministratorShell extends Shell {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			AdministratorShell shell = new AdministratorShell(display);
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
	public AdministratorShell(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage(AdministratorShell.class, "/com/hms/icon/hms-admin-icon.png"));
		
		Group grpNgiSDng = new Group(this, SWT.NONE);
		grpNgiSDng.setText(Messages.getString("HMS.AdministratorShell.group.user"));
		grpNgiSDng.setBounds(10, 10, 216, 319);
		
		List list = new List(grpNgiSDng, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.NORMAL));
		list.setItems(new String[] {"Nguyễn Văn A0", "Nguyễn Văn B0", "Nguyễn Văn C0", "Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", "Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", "Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", "Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C1", "Nguyễn Văn A1", "Nguyễn Văn B2", "Nguyễn Văn C2"});
		list.setBounds(10, 20, 196, 289);
		
		Group grpThngTinNgi = new Group(this, SWT.NONE);
		grpThngTinNgi.setText(Messages.getString("HMS.AdministratorShell.group.user_info"));
		grpThngTinNgi.setBounds(232, 10, 650, 213);
		
		Label lblTnngNhp = new Label(grpThngTinNgi, SWT.NONE);
		lblTnngNhp.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTnngNhp.setBounds(10, 33, 136, 21);
		lblTnngNhp.setText(Messages.getString("HMS.AdministratorShell.group.user_info.label.username"));
		
		text = new Text(grpThngTinNgi, SWT.BORDER);
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				text.selectAll();
			}
		});
		text.setBounds(152, 33, 251, 21);
		text.setFocus();
		text.setTopIndex(0);
		
		Label lblMtKhu = new Label(grpThngTinNgi, SWT.NONE);
		lblMtKhu.setText(Messages.getString("HMS.AdministratorShell.group.user_info.label.password"));
		lblMtKhu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblMtKhu.setBounds(10, 60, 136, 21);
		
		text_1 = new Text(grpThngTinNgi, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(152, 60, 251, 21);
		text_1.setTopIndex(1);
		
		Label lblXcNhnMt = new Label(grpThngTinNgi, SWT.NONE);
		lblXcNhnMt.setText(Messages.getString("HMS.AdministratorShell.group.user_info.label.confirm_password"));
		lblXcNhnMt.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblXcNhnMt.setBounds(10, 87, 136, 21);
		
		text_2 = new Text(grpThngTinNgi, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(152, 87, 251, 21);
		text_2.setTopIndex(2);
		
		Label label = new Label(grpThngTinNgi, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(0, 114, 650, 2);
		
		Label lblTny = new Label(grpThngTinNgi, SWT.NONE);
		lblTny.setText(Messages.getString("HMS.AdministratorShell.group.user_info.label.fullname"));
		lblTny.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblTny.setBounds(10, 122, 136, 21);
		
		text_3 = new Text(grpThngTinNgi, SWT.BORDER);
		text_3.setBounds(152, 122, 251, 21);
		text_3.setTopIndex(3);
		
		Label lblEmail = new Label(grpThngTinNgi, SWT.NONE);
		lblEmail.setText(Messages.getString("HMS.AdministratorShell.group.user_info.label.email"));
		lblEmail.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblEmail.setBounds(10, 149, 136, 21);
		
		text_4 = new Text(grpThngTinNgi, SWT.BORDER);
		text_4.setBounds(152, 149, 251, 21);
		text_4.setTopIndex(4);
		
		Label lblHnhnh = new Label(grpThngTinNgi, SWT.NONE);
		lblHnhnh.setText(Messages.getString("HMS.AdministratorShell.group.user_info.label.picture"));
		lblHnhnh.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblHnhnh.setBounds(10, 176, 136, 21);
		
		text_5 = new Text(grpThngTinNgi, SWT.BORDER);
		text_5.setBounds(152, 176, 251, 21);
		text_5.setTopIndex(5);
		
		Group grpQuynSDng = new Group(this, SWT.NONE);
		grpQuynSDng.setText(Messages.getString("HMS.AdministratorShell.group.user_privileges"));
		grpQuynSDng.setBounds(232, 229, 650, 370);
		
		Label lblNhmChcNng = new Label(grpQuynSDng, SWT.NONE);
		lblNhmChcNng.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblNhmChcNng.setBounds(10, 27, 120, 21);
		lblNhmChcNng.setText(Messages.getString("HMS.AdministratorShell.group.user_privileges.label.group_function"));
		
		final List list_1 = new List(grpQuynSDng, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		list_1.setTopIndex(6);
		
		final java.util.List<LinkedList<String>> list_2_model = new LinkedList<LinkedList<String>>();
		LinkedList<String> tempList = new LinkedList<String>();
		tempList.add("Sử dụng CN 1");
		tempList.add("Thêm CN 1");
		tempList.add("Xóa CN 1");
		
		list_2_model.add(tempList);
		
		tempList = new LinkedList<String>();
		tempList.add("Thêm CN 2");
		tempList.add("Xóa CN 2");
		
		list_2_model.add(tempList);
		
		final java.util.List<LinkedList<String>> list_3_model = new LinkedList<LinkedList<String>>();
		list_3_model.add(new LinkedList<String>());
		list_3_model.add(new LinkedList<String>());
		
		final List list_2 = new List(grpQuynSDng, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		list_2.setTopIndex(7);
		final List list_3 = new List(grpQuynSDng, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		list_3.setTopIndex(12);
		
		list_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List list = (List) e.widget;
				int [] selectedItems = list.getSelectionIndices();
				list_2.removeAll();
				list_3.removeAll();
				
				if (selectedItems.length == 1) {
					switch (selectedItems[0]) {
					case 0:
						for (String item : list_2_model.get(0)) {
							list_2.add(item);
						}
						
						for (String item : list_3_model.get(0)) {
							list_3.add(item);
						}
						
						break;
					case 1:
						for (String item : list_2_model.get(1)) {
							list_2.add(item);
						}
						
						for (String item : list_3_model.get(1)) {
							list_3.add(item);
						}
						
						break;
					}
				}
			}
		});
		list_1.setItems(new String[] {"Chức năng 1", "Chức năng 2"});
		list_1.setBounds(10, 54, 178, 306);
		
		Label label_2 = new Label(grpQuynSDng, SWT.SEPARATOR | SWT.VERTICAL);
		label_2.setBounds(204, 10, 2, 357);
		
		Label lblCcQuynSn = new Label(grpQuynSDng, SWT.NONE);
		lblCcQuynSn.setText(Messages.getString("HMS.AdministratorShell.group.user_privileges.label.privileges"));
		lblCcQuynSn.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblCcQuynSn.setBounds(220, 27, 120, 21);
		
		
		list_2.setBounds(220, 54, 178, 306);
		
		Label lblCcQuync = new Label(grpQuynSDng, SWT.NONE);
		lblCcQuync.setText(Messages.getString("HMS.AdministratorShell.group.user_privileges.label.used_privileges"));
		lblCcQuync.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		lblCcQuync.setBounds(462, 27, 165, 21);
		
		Button button = new Button(grpQuynSDng, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LinkedList<String> temp = new LinkedList<String>();
				
				for (int selectedIndex : list_2.getSelectionIndices()) {
					list_3_model.get(list_1.getSelectionIndex()).add(list_2.getItem(selectedIndex));
					list_3.add(list_2.getItem(selectedIndex));
				
					temp.add(list_2_model.get(list_1.getSelectionIndex()).get(selectedIndex));
				}
				
				//Set selected items on destination list
				list_3.setSelection(list_3.getItemCount() - list_2.getSelectionCount(), list_3.getItemCount());
				
				//Remove on source list
				list_2.remove(list_2.getSelectionIndices());
				
				for (String removedItem: temp) {
					list_2_model.get(list_1.getSelectionIndex()).remove(removedItem);
				}
				
				
			}
		});
		button.setText(">");
		button.setBounds(411, 125, 37, 30);
		
		Button button_1 = new Button(grpQuynSDng, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LinkedList<String> temp = new LinkedList<String>();
				
				for (int selectedIndex : list_3.getSelectionIndices()) {
					list_2_model.get(list_1.getSelectionIndex()).add(list_3.getItem(selectedIndex));
					list_2.add(list_3.getItem(selectedIndex));
					
					temp.add(list_3_model.get(list_1.getSelectionIndex()).get(selectedIndex));
				}
				
				//Set selected items on destination list
				list_2.setSelection(list_2.getItemCount() - list_3.getSelectionCount(), list_2.getItemCount());
				
				//Remove on source list
				list_3.remove(list_3.getSelectionIndices());
				
				for (String removedItem: temp) {
					list_3_model.get(list_1.getSelectionIndex()).remove(removedItem);
				}
			}
		});
		button_1.setText("<");
		button_1.setBounds(411, 170, 37, 30);
		
		Button button_2 = new Button(grpQuynSDng, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i = 0; i < list_2.getItemCount(); i++) {
					list_3_model.get(list_1.getSelectionIndex()).add(list_2.getItem(i));
					list_3.add(list_2.getItem(i));
				}
				
				//Select all items of destination list
				list_3.selectAll();
				
				//Remove source list
				list_2.removeAll();
				list_2_model.get(list_1.getSelectionIndex()).clear();
			}
		});
		button_2.setText(">>");
		button_2.setBounds(411, 215, 37, 30);
		
		Button button_3 = new Button(grpQuynSDng, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				for (int i = 0; i < list_3.getItemCount(); i++) {
					list_2_model.get(list_1.getSelectionIndex()).add(list_3.getItem(i));
					list_2.add(list_3.getItem(i));
				}
				
				//Select all items of destination list
				list_2.selectAll();
				
				//Remove source list
				list_3.removeAll();
				list_3_model.get(list_1.getSelectionIndex()).clear();
			}
		});
		button_3.setToolTipText("");
		button_3.setText("<<");
		button_3.setBounds(411, 260, 37, 30);
		
		list_3.setBounds(462, 54, 178, 306);
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setBounds(232, 605, 650, 55);
		
		Button btnLu = new Button(composite, SWT.NONE);
		btnLu.setImage(SWTResourceManager.getImage(AdministratorShell.class, "/com/hms/icon/hms-save-icon.png"));
		btnLu.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnLu.setText(Messages.getString("HMS.AdministratorShell.button.save"));
		btnLu.setBounds(350, 10, 110, 30);
		
		Button btnHy = new Button(composite, SWT.NONE);
		btnHy.setImage(SWTResourceManager.getImage(AdministratorShell.class, "/com/hms/icon/hms-cancel-icon.png"));
		btnHy.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnHy.setBounds(500, 10, 110, 30);
		btnHy.setText(Messages.getString("HMS.AdministratorShell.button.cancel"));
		
		Button btnThmMi = new Button(composite, SWT.NONE);
		btnThmMi.setImage(SWTResourceManager.getImage(AdministratorShell.class, "/com/hms/icon/hms-add-icon.png"));
		btnThmMi.setEnabled(false);
		btnThmMi.setFont(SWTResourceManager.getFont("Times New Roman", 12, SWT.BOLD));
		btnThmMi.setText(Messages.getString("HMS.AdministratorShell.button.add"));
		btnThmMi.setBounds(200, 10, 110, 30);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText(Messages.getString("HMS.AdministratorShell.title"));
		setSize(900, 700);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}

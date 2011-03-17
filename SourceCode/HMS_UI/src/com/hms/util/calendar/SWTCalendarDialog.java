package com.hms.util.calendar;

import org.eclipse.swt.SWT;import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.hms.util.calendar.SWTCalendar;
import com.hms.util.calendar.SWTCalendarListener;

import java.util.Calendar;
import java.util.Date;
import com.swtdesigner.SWTResourceManager;
import org.eclipse.swt.events.KeyAdapter;import org.eclipse.swt.events.MouseAdapter;

public class SWTCalendarDialog {
    private Shell shell;
    private SWTCalendar swtcal;
    private Display display;

    public SWTCalendarDialog(Display display) {
        this.display = display;
        shell = new Shell(display, SWT.APPLICATION_MODAL);
        shell.setImage(SWTResourceManager.getImage(SWTCalendarDialog.class, "/com/hms/icon/hms-calendar-icon.png"));
        shell.setLayout(new RowLayout());        
        swtcal = new SWTCalendar(shell);
    }

    public void open(int x, int y) {
        shell.pack();        shell.setLocation(x, y);        
        shell.open();        
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) display.sleep();
        }
    }
    public void close() {    	this.shell.close();    }
    public Calendar getCalendar() {
        return swtcal.getCalendar();
    }

    public void setDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        swtcal.setCalendar(calendar);
    }

    public void addDateChangedListener(SWTCalendarListener listener) {
        swtcal.addSWTCalendarListener(listener);
    }    public void addKeyListener(KeyAdapter keyListener) {        swtcal.addSWTCalendarKeyListener(keyListener);    }        public void addMouseListener(MouseAdapter mouseListener) {        swtcal.addSWTCalendarMouseListener(mouseListener);    }
}

package gui.menu;

import model.Spreadsheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private Spreadsheet sheet;

    public ClearAllMenuItem(Spreadsheet sheet) {
        super("Clear all");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clear();
    }
}
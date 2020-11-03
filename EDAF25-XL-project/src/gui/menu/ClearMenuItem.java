package gui.menu;

import model.Spreadsheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private Spreadsheet sheet;

    public ClearMenuItem(Spreadsheet sheet) {
        super("Clear");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearCell(sheet.getSelectedCoordinate());
    }
}
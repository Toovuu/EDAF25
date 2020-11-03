package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Spreadsheet;
import model.XLBufferedReader;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
	private Spreadsheet sheet;
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
        sheet = xl.getSpreadsheet();
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.clear();
        new XLBufferedReader(path).load(sheet);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}
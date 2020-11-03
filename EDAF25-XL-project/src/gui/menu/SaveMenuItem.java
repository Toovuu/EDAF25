package gui.menu;

import gui.StatusLabel;
import gui.XL;
import model.Spreadsheet;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {
	private Spreadsheet sheet;
	
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
        sheet = xl.getSpreadsheet();
    }

    protected void action(String path) throws FileNotFoundException {
        sheet.save(path + ".xl");
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}
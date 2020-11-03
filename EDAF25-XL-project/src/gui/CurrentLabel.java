package gui;

import model.Spreadsheet;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class CurrentLabel extends ColoredLabel implements Observer {

    private Spreadsheet sheet;
    public CurrentLabel(Spreadsheet sheet) {
        super("", Color.WHITE);
        this.sheet = sheet;
        sheet.addObserver(this);
        update(null,null);
    }

    @Override
    public void update(Observable o, Object arg) {
        setText(sheet.getSelectedCoordinate());
    }

}
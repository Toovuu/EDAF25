package gui;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Cell;
import model.Spreadsheet;

public class Editor extends JTextField implements Observer{
	private Spreadsheet sheet;
	
    public Editor(Spreadsheet sheet) {
    	this.sheet = sheet;
    	sheet.addObserver(this);
    	update(null, null);
        setBackground(Color.WHITE);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    sheet.parseString(((JTextField)e.getSource()).getText());
                }
            }

        });
    }

	@Override
	public void update(Observable o, Object arg1) {
		String coordinate = sheet.getSelectedCoordinate();
		Cell cell = sheet.getCell(coordinate);
		this.setText(cell.inputValue());
	}

}
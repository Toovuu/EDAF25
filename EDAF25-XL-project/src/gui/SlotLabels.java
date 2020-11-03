package gui;

import model.Cell;
import model.Spreadsheet;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel implements Observer {
    private Spreadsheet sheet;
    private Map<String, SlotLabel> labelMap;

    public SlotLabels(int rows, int cols, Spreadsheet sheet) {
        super(rows + 1, cols);
        this.sheet = sheet;
        sheet.addObserver(this);

        labelMap = new HashMap<>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(
                new ColoredLabel(Character.toString(ch),
                Color.LIGHT_GRAY,
                SwingConstants.CENTER)
            );
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel();
                add(label);
                String coordinate = "" + ch + row; 
                labelMap.put(coordinate, label);
                label.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                    	sheet.setSelectedCoordinate(coordinate);
                    }
                });
            }
        }

        update(null, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        labelMap.forEach((coordinate, slotLabel) -> {
        	slotLabel.setBackground(Color.WHITE);
            Cell cell = sheet.getCell(coordinate);
            String cellString = cell.cellValue(sheet);

            while (cellString.length() < 20) { // TODO: Maybe use size instead?
                cellString += " ";
            }

            slotLabel.setText(cellString);
        });

        labelMap
            .get(sheet.getSelectedCoordinate())
            .setBackground(Color.YELLOW);
    }
}

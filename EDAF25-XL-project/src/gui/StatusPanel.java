package gui;

import model.Spreadsheet;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, Spreadsheet sheet) {
        add(WEST, new CurrentLabel(sheet));
        add(CENTER, statusLabel);
    }
}
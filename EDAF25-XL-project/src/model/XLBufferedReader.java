package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Spreadsheet sheet) {
        try {
            while (ready()) {
                String string = readLine();
                String[] keyValue = string.split("=");
                sheet.setSelectedCoordinate(keyValue[0]);
                sheet.parseString(keyValue[1]);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}

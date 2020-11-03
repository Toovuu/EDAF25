package model;

import expr.Environment;
import expr.Expr;
import expr.ExprParser;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Spreadsheet extends Observable implements Environment {
    private Map<String, Cell> cells = new HashMap<>();
    private String selectedCoordinate = "A1";
    private ExprParser exprParser = new ExprParser();
    private Status status;
    private Cell nullCell = new NullCell();

    public Spreadsheet(Status status) {
        this.status = status;
    }

    @Override
    public double value(String name) {
        return ((ExpressionCell) getCell(name)).value(this);
    }

    public void clear() {
        cells.clear();
        changed();
    }

    public void clearCell(String coordinate) {
        cells.remove(coordinate);
        changed();
    }

    public Cell getCell(String coordinate) {
        return cells.getOrDefault(coordinate, nullCell);
    }

    public void setCell(String coordinate, Cell cell) {
        if (cell instanceof NullCell) {
            clearCell(coordinate);
        } else {
            cells.put(coordinate, cell);
        }
        changed();
    }

    public String getSelectedCoordinate() {
        return selectedCoordinate;
    }

    public void setSelectedCoordinate(String selectedCoordinate) {
        this.selectedCoordinate = selectedCoordinate;
        changed();
    }

    private void changed() {
        super.setChanged();
        notifyObservers();
    }
    
    public void parseString(String input) {
        status.setMessage(""); // Assume valid parsing

        if(input.length() == 0){
    		clearCell(selectedCoordinate);
        }
    	
    	else if(input.charAt(0) == '#') {
    		Cell cell = new CommentCell(input);
            setCell(selectedCoordinate, cell);
    	}
    	
    	else {
    		Cell temp = getCell(selectedCoordinate);
    		cells.remove(selectedCoordinate);
    		try {
    			Expr expr = exprParser.build(input);
    			expr.value(this);
    			Cell cell = new ExpressionCell(expr);
    			setCell(selectedCoordinate, cell);
    		}
    		catch(Exception e) {
                setCell(selectedCoordinate, temp);
    			status.setMessage("Felaktig inmatning!");
    		}
    	}
    	
    	changed();
    }
    
    public void save(String path) {
    	try {
			new XLPrintStream(path).save(cells.entrySet());
			status.setMessage(path + " sparades!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			status.setMessage("Kunde inte spara fil");
		}
		
    }


}

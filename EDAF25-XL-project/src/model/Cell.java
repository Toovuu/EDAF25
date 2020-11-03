package model;

import expr.Environment;

public interface Cell {
    String cellValue(Environment e);
    String inputValue();
}

package model;

import expr.Environment;

public class NullCell implements Cell {
    @Override
    public String cellValue(Environment e) {
        return "";
    }

    @Override
    public String inputValue() {
        return "";
    }
}

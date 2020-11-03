package model;

import expr.Environment;
import expr.Expr;

public class ExpressionCell implements Cell {
    private Expr expression;

    public ExpressionCell(Expr expression) {
        this.expression = expression;
    }

    public double value(Environment e) {
        return expression.value(e);
    }

    @Override
    public String cellValue(Environment e) {
        return expression.value(e) + "";
    }

    @Override
    public String inputValue() {
        return expression.toString();
    }
}

package model;

import expr.Environment;

public class CommentCell implements Cell {
    private String rawComment;

    public CommentCell(String rawComment) {
        this.rawComment = rawComment;
    }

    @Override
    public String cellValue(Environment e) {
        return rawComment.replace("#", "");
    }

    @Override
    public String inputValue() {
        return rawComment;
    }
}

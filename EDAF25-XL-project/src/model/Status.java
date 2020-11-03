package model;

import java.util.Observable;

public class Status extends Observable {

    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        super.setChanged();
        notifyObservers();
    }
}

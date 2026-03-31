package models;

import enums.SeatType;

public class Seat {
    private String id;
    private int row;
    private int col;
    private SeatType type;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public SeatType getType() {
        return type;
    }
    public void setType(SeatType type) {
        this.type = type;
    }
}

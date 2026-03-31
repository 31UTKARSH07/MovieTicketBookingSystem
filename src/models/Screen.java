package models;

import enums.ScreenType;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String id;
    private String theatreId;
    private ScreenType type;
    private List<Seat> seats = new ArrayList<>();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTheatreId(){
        return theatreId;
    }
    public void setTheatreId(String theatreId){
        this.theatreId = theatreId;
    }
    public ScreenType getType() {
        return type;
    }
    public void setType(ScreenType type) {
        this.type = type;
    }
    public List<Seat> getSeats() {
        return seats;
    }
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}

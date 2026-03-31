package models;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private String id;
    private Movie movie;
    private Screen screen;
    private long startTime;
    private List<ShowSeats> showSeats = new ArrayList<>();

    public String getId() {
        return id;
    }
    public Movie getMovie() {
        return movie;
    }
    public Screen getScreen() {
        return screen;
    }
    public long getStartTime() {
        return startTime;
    }
    public List<ShowSeats> getShowSeats() {
        return showSeats;
    }
}

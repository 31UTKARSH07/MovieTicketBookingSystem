package models;

import enums.BookingStatus;

import java.util.Date;
import java.util.List;

public class Booking {
    private String id;
    private User user;
    private Show show;
    private List<ShowSeats> seats;
    private BookingStatus status;
    private Date bookingTime;

    public Booking(String id, User user, Show show, List<ShowSeats> seats, BookingStatus status) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public User getUser() {
        return user;
    }
    public Show getShow() {
        return show;
    }
    public List<ShowSeats> getSeats() {
        return seats;
    }
    public BookingStatus getStatus() {
        return status;
    }
    public Date getBookingTime() {
        return bookingTime;
    }

    public void setStatus(BookingStatus status){
        this.status = status;
    }
}

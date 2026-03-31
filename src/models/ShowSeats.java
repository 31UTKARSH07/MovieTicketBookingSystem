package models;

import enums.SeatStatus;

public class ShowSeats {
    private String id;
    private Seat seat;
    private Show show;
    private double price;
    private SeatStatus status;

    public ShowSeats(Seat seat , Show show , double price ){
        this.seat = seat;
        this.show = show;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }
    public synchronized boolean lockSeat(){
        if (this.status == SeatStatus.AVAILABLE){
            this.status = SeatStatus.LOCKED;
            return true;
        }
        return false;
    }
    public void bookSeat() {
        this.status = SeatStatus.BOOKED;
    }
    public void releaseSeat() {
        this.status = SeatStatus.AVAILABLE;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public SeatStatus getStatus() {
        return status;
    }
}

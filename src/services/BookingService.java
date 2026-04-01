package services;

import enums.BookingStatus;
import models.Booking;
import models.Show;
import models.ShowSeats;
import models.User;
import strategies.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {
    public synchronized Booking bookTickets(User user , Show show , List<ShowSeats>selectedSeats , PaymentStrategy paymentMethod){
        List<ShowSeats> lockedSeats = new ArrayList<>();
        for (ShowSeats seat : selectedSeats) {
            if (seat.lockSeat()){
                lockedSeats.add(seat);
            }else {
                System.out.println("Seat " + seat.getId() + " is already taken!");
                rollbackLocks(lockedSeats);
                throw new RuntimeException("Selected seats are no longer available.");
            }
        }

        double totalAmount = lockedSeats.stream().mapToDouble(ShowSeats::getPrice).sum();
        boolean paymentSuccess = paymentMethod.processPayment(totalAmount);

        if (paymentSuccess){
            for (ShowSeats seats : lockedSeats){
                seats.bookSeat();
            }
            System.out.println("Booking Comfirmed for user: "+ user.getId());
            return new Booking(UUID.randomUUID().toString() , user,show,lockedSeats, BookingStatus.CONFIRMED);

        }else {
            rollbackLocks(lockedSeats);
            throw new RuntimeException("Payment Failed");
        }
    }
    private void rollbackLocks(List<ShowSeats>lockedSeats){
        for (ShowSeats seats : lockedSeats){
            seats.releaseSeat();
        }
    }
    public void cancelBooking(Booking booking){
        if (booking.getStatus() == BookingStatus.CONFIRMED){
            booking.setStatus(BookingStatus.CANCELLED);
            for (ShowSeats seat : booking.getSeats()){
                seat.releaseSeat();
            }
            System.out.println("Booking " + booking.getId() + " cancelled. Refund initiated.");
        }
    }
}

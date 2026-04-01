package strategies;

import models.*;

import java.util.List;

public interface AdminOperationsStrategy {
    void addTheatre(User actingUser, Theatre theatre);
    void addMovie(User actingUser ,Movie movie);
    void updateBasePrice(User actingUser , List<ShowSeats> seats, double newPrice);
}

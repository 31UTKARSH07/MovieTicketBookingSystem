package strategies.AdminStrategiesImpl;

import enums.UserRole;
import models.Movie;
import models.ShowSeats;
import models.Theatre;
import models.User;
import strategies.AdminOperationsStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminManager implements AdminOperationsStrategy {
    private Map<String , Theatre> theatreDB = new HashMap<>();
    private Map<String , Movie> movieDB = new HashMap<>();

    private void verifyAdmin(User user) {
        if (user.getRole() != UserRole.ADMIN) {
            throw new SecurityException("Access Denied! User " + user.getName() + " is not an Admin.");
        }
    }
    public void addTheatre(User actingUser, Theatre theatre) {
        verifyAdmin(actingUser);

        if (theatreDB.containsKey(theatre.getId())) {
            System.out.println("Theater already exists!");
            return;
        }
        theatreDB.put(theatre.getId(), theatre);
        System.out.println("Admin " + actingUser.getName() + " successfully added Theater: " + theatre.getName());
    }
    public void addMovie(User actingUser, Movie movie) {
        verifyAdmin(actingUser);
        movieDB.put(movie.getId(), movie);
        System.out.println("Admin " + actingUser.getName() + " successfully added Movie: " + movie.getTitle());
    }
    @Override
    public void updateBasePrice(User actingUser, List<ShowSeats> seats, double newPrice) {
        verifyAdmin(actingUser);
        if (newPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        for (ShowSeats seat : seats) {
            seat.setPrice(newPrice);
        }
        System.out.println("Success! Admin " + actingUser.getName() +
                " updated the base price for " + seats.size() +
                " seats to: Rs." + newPrice);
    }
}

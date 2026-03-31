package strategies.PricingImpl;

import models.Show;
import models.ShowSeats;
import strategies.PricingRule;

public class WeekendSurgePricing implements PricingRule {
    @Override
    public double calculatePricing(ShowSeats seat, Show show) {
        return seat.getPrice() * 1.20;
    }
}

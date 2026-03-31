package strategies;

import models.Show;
import models.ShowSeats;

public interface PricingRule {
    double calculatePricing(ShowSeats seats , Show show);
}

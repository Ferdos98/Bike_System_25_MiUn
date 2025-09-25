package com.bikeshare.lab3;

import com.bikeshare.model.BikeType;
import com.bikeshare.model.User;
import com.bikeshare.model.MembershipType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Lab 3 Template: Integration Testing for BikeType and User.MembershipType
 * 
 * TODO for students:
 * - Test methods that use both classes: Calculate ride costs with different
 * combinations
 * - Test business logic between classes: Compare membership benefits (free
 * minutes)
 * - Test error scenarios involving both classes: Edge cases (rides exactly
 * matching free minutes)
 * - Test different input values: Expensive bike types with different
 * memberships
 * - Optional: Create helper methods to calculate costs and compare results
 */

// This test is just an example to get you started. You will need to add more
// tests as per the challenges.
@DisplayName("Lab 3: BikeType + MembershipType Integration Testing")
public class BikeTypeMembershipBasicTest {

    @Test
    @DisplayName("Should calculate zero cost for short ride with BASIC membership")
    void shouldCalculateZeroCostForShortRideWithBasicMembership() {
        // Arrange - Set up test data
        User.MembershipType basicMembership = User.MembershipType.BASIC;
        BikeType standardBike = BikeType.STANDARD;
        int rideMinutes = 30; // Short ride within free minutes

        // Act - Calculate cost using both classes
        int freeMinutes = basicMembership.getFreeMinutesPerRide();
        double bikeRate = standardBike.getPricePerMinute();
        int chargeableMinutes = Math.max(0, rideMinutes - freeMinutes);
        double actualCost = chargeableMinutes * bikeRate;

        // Assert - Verify the integration works correctly
        assertEquals(0.0, actualCost, 0.01, "Short ride should be free with BASIC membership");
        assertTrue(rideMinutes <= freeMinutes, "Ride minutes should be within free minutes");
    }

    // TODO: Test methods that use both classes - Add tests for calculating ride
    // costs with different combinations
    // Hint: Test PREMIUM membership with ELECTRIC bike, STUDENT membership with
    // CARGO bike, etc.
    @Test
    @DisplayName("Should calculate cost for a ride with PREMIUM membership and ELECTRIC bike")
    void shouldCalculateCostForRideWithBasicMembership() {
        // Arrange - Set up test data
        MembershipType premiumMembership = MembershipType.PREMIUM;
        // User.MembershipType premiumMembership = User.MembershipType.PREMIUM;
        BikeType electricBike = BikeType.ELECTRIC;
        int rideMinutes = 120; // Short ride within free minutes

        // Act - Calculate cost using both classes
        int freeMinutes = premiumMembership.getFreeMinutesPerMonth(); // 60 free minutes for PREMIUM
        double bikeRate = electricBike.getPricePerMinute(); // 1.00 per minute for ELECTRIC
        int chargeableMinutes = Math.max(0, rideMinutes - freeMinutes); // 120-60=60
        double actualCost = chargeableMinutes * bikeRate; // 60*1.00
        double discount = actualCost * premiumMembership.getDiscountRate(); // 15% discount
        double finalCost = actualCost - discount;
        // Assert - Verify the integration w orks correctly

        assertEquals(51.00, finalCost, 0.01,
                "Ride cost should be correctly calculated with PREMIUM membership and ELECTRIC bike");
    }

    @Test
    @DisplayName("Should calculate cost for a ride with STUDENT membership on CARGO bike")
    void shouldCalculateCostForRideWithStudentMembershipAndCargoBike() {
        // Arrange - Set up test data
        MembershipType studentMembership = MembershipType.STUDENT;
        // User.MembershipType premiumMembership = User.MembershipType.PREMIUM;
        BikeType cargoBike = BikeType.CARGO;
        int rideMinutes = 46; // Short ride within free minutes

        // Act - Calculate cost using both classes
        int freeMinutes = studentMembership.getFreeMinutesPerMonth(); // 60 free minutes for PREMIUM
        double bikeRate = cargoBike.getPricePerMinute(); // 1.00 per minute for ELECTRIC
        int chargeableMinutes = Math.max(0, rideMinutes - freeMinutes); // 120-60=60
        double actualCost = chargeableMinutes * bikeRate; // 60*1.00
        double discount = actualCost * studentMembership.getDiscountRate(); // 15% discount
        double finalCost = actualCost - discount;
        // Assert - Verify the integration w orks correctly

        assertEquals(0.96, finalCost, 0.01,
                "Ride cost should be correctly calculated with STUDENT membership and CARGO bike");

    }

    @Test
    @DisplayName("Should calculate cost for a ride with VIP membership on MOUNTAIN bike")
    void shouldCalculateCostForRideWithVIPMembershipAndMountainBike() {
        // Arrange - Set up test data
        MembershipType VIPMembership = MembershipType.VIP;
        // User.MembershipType premiumMembership = User.MembershipType.PREMIUM;
        BikeType mountainBike = BikeType.MOUNTAIN;
        int rideMinutes = 100; // Short ride within free minutes

        // Act - Calculate cost using both classes
        int freeMinutes = VIPMembership.getFreeMinutesPerMonth();
        double bikeRate = mountainBike.getPricePerMinute();
        int chargeableMinutes = Math.max(0, rideMinutes - freeMinutes);
        double actualCost = chargeableMinutes * bikeRate;
        double discount = actualCost * VIPMembership.getDiscountRate();
        double finalCost = actualCost - discount;

        // Assert - Verify the integration w orks correctly

        assertEquals(0.00, finalCost, 0.01,
                "Ride cost should be correctly calculated with STUDENT membership and CARGO bike");
        assertTrue(rideMinutes <= freeMinutes, "Ride minutes should be within free minutes");
    }

    // TODO: Test business logic between classes - Add tests comparing membership
    // benefits
    // Hint: Test that PREMIUM has more free minutes than BASIC, CORPORATE has most
    // free minutes

    @Test
    // this test doesn't pass, VIP has the most free minutes
    @DisplayName("Should verify CORPORATE membership has the most free minutes")
    void shouldVerifyCorporateMembershipHasMostFreeMinutes() {
        MembershipType corporateMembership = MembershipType.CORPORATE;
        MembershipType VIPMembership = MembershipType.VIP;
        MembershipType premiumMembership = MembershipType.PREMIUM;
        MembershipType studentMembership = MembershipType.STUDENT;
        MembershipType basicMembership = MembershipType.BASIC;

        Integer corporateFreeMins = corporateMembership.getFreeMinutesPerMonth();
        // assertTrue(corporateFreeMins > VIPMembership.getFreeMinutesPerMonth());
        assertTrue(corporateFreeMins > premiumMembership.getFreeMinutesPerMonth());
        assertTrue(corporateFreeMins > studentMembership.getFreeMinutesPerMonth());
        assertTrue(corporateFreeMins > basicMembership.getFreeMinutesPerMonth());

    }

    // TODO: Test error scenarios involving both classes - Add tests for edge cases
    // Hint: Test rides that are exactly the same length as free minutes, rides just
    // over free minutes
    @Test
    @DisplayName("Should calculate cost for a ride with VIP membership and STANDARD bike")
    void edgeCasesCalculateCostForRideWithVipMembership() {
        // Arrange - Set up test data
        MembershipType basicMembership = MembershipType.VIP;
        // User.MembershipType premiumMembership = User.MembershipType.PREMIUM;
        BikeType standardBike = BikeType.STANDARD;
        int exactFreeRideMinutes = 120; //

        // Act - Calculate cost using both classes
        int freeMinutes = basicMembership.getFreeMinutesPerMonth();
        double bikeRate = standardBike.getPricePerMinute();
        int chargeableMinutes = Math.max(0, exactFreeRideMinutes - freeMinutes);
        double actualCost = chargeableMinutes * bikeRate;
        double discount = actualCost * basicMembership.getDiscountRate();
        double finalCost = actualCost - discount;

        assertEquals(0, finalCost, 0.01,
                "Ride cost should be correctly calculated with VIP membership and STANDARD bike");
    }

    @Test
    @DisplayName ("calculate cost")
    void edgeCasesCalculateCostForRideWithPremiumMembership() {
       // Arrange - Set up test data
        MembershipType basicMembership = MembershipType.PREMIUM;
        BikeType standardBike = BikeType.STANDARD;
        int exactFreeRideMinutes = 60;

        // Act - Calculate cost using both classes
        int freeMinutes = basicMembership.getFreeMinutesPerMonth();
        double bikeRate = standardBike.getPricePerMinute();
        int chargeableMinutes = Math.max(0, exactFreeRideMinutes - freeMinutes);
        double actualCost = chargeableMinutes * bikeRate;
         double discount = actualCost * basicMembership.getDiscountRate();
        double finalCost = actualCost - discount;

        assertEquals(0, finalCost, 0.01,
                "Ride cost should be correctly calculated with PREMIUM membership and STANDARD bike");
    }
    
   
    @Test
    @DisplayName ("calculate cost")
    void edgeCasesCalculateCostRightOverPremium(){

        // Arrange - Set up test data
        MembershipType basicMembership = MembershipType.PREMIUM;
        BikeType standardBike = BikeType.STANDARD;
        int exactFreeRideMinutes = 61;

        // Act - Calculate cost using both classes
        int freeMinutes = basicMembership.getFreeMinutesPerMonth();
        double bikeRate = standardBike.getPricePerMinute();
        int chargeableMinutes = Math.max(0, exactFreeRideMinutes - freeMinutes);
        double actualCost = chargeableMinutes * bikeRate;
         double discount = actualCost * basicMembership.getDiscountRate();
        double finalCost = actualCost - discount;

        assertEquals(0.425, finalCost, 0.01,
        "Ride cost should be right over 0 with PREMIUM membership and STANDARD bike");
    }

@Test
    @DisplayName ("calculate cost")
    void edgeCasesCalculateCostRightOverVip(){

        // Arrange - Set up test data
        MembershipType basicMembership = MembershipType.VIP;
        BikeType standardBike = BikeType.STANDARD;
        int exactFreeRideMinutes = 121;

        // Act - Calculate cost using both classes
        int freeMinutes = basicMembership.getFreeMinutesPerMonth();
        double bikeRate = standardBike.getPricePerMinute();
        int chargeableMinutes = Math.max(0, exactFreeRideMinutes - freeMinutes);
        double actualCost = chargeableMinutes * bikeRate;
         double discount = actualCost * basicMembership.getDiscountRate();
        double finalCost = actualCost - discount;

        assertEquals(0.375, finalCost, 0.01,
        "Ride cost should be right over 0");
    }

    
    
    
    
    // TODO: Test different input values - Add tests for expensive bike types with
    // different memberships
    // Hint: Test how CARGO bike (most expensive) costs differ across membership
    // types
    @ParameterizedTest(name = "Cargo")
    @CsvSource({
    "BASIC,     30, 36.00",
    "PREMIUM,   30, 30.60",
    "VIP,       30, 27.00",
    "STUDENT,   30, 28.80",
    "CORPORATE, 30, 32.40"
    })

    void cargoPricingAcrossMemberships(MembershipType type, int minutes, double expected) {
    double pricePerMinute = BikeType.CARGO.getPricePerMinute(); 
    double actual = pricePerMinute * minutes * (1 - type.getDiscountRate());
    assertEquals(expected, actual, 0.0001);
}

}
   
    
    

    // TODO: Optional - Create helper method to calculate ride costs
    // Hint: private double calculateRideCost(MembershipType membership, BikeType
    // bikeType, int minutes)

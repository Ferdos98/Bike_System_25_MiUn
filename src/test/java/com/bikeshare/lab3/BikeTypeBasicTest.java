package com.bikeshare.lab3;

import com.bikeshare.model.BikeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Lab 3 Template: Structural Testing for BikeType enum
 * 
 * TODO for students:
 * - Test all public methods: getDisplayName(), getPricePerMinute(),
 * isElectric(), getMaxSpeedKmh()
 * - Test different input values: All enum values (STANDARD, ELECTRIC, MOUNTAIN,
 * CARGO)
 * - Test if/else branches: isElectric() method (branch coverage)
 * - Test switch statement: getMaxSpeedKmh() method (all branches)
 * - Optional: Add parameterized tests for testing all enum values efficiently
 */

// This test is just an example to get you started. You will need to add more
// tests as per the challenges.
@DisplayName("Lab 3: BikeType Structural Testing")
public class BikeTypeBasicTest {

    @Test
    @DisplayName("Should return correct display name for STANDARD bike type")
    void shouldReturnCorrectDisplayNameForStandardBike() {
        // Arrange - Set up test data
        BikeType standardBike = BikeType.STANDARD;

        // Act - Execute the method under test
        String displayName = standardBike.getDisplayName();

        // Assert - Verify the expected outcome
        assertNotNull(displayName, "Display name should not be null");
        assertEquals("Standard Bike", displayName, "Display name should match expected value");
    }

    // TODO: Test all public methods - Add tests for getDisplayName() for all enum
    // values
    // Hint: Test ELECTRIC, MOUNTAIN, CARGO bike types
    @Test
    @DisplayName("Should return correct display name for ELECTRIC bike type")
    void shouldReturnCorrectDisplayNameForElectricBike() {
        BikeType electricBike = BikeType.ELECTRIC;

        String displayName = electricBike.getDisplayName();

        assertNotNull(displayName, "Display name should not be null");
        assertEquals("Electric Bike", displayName, "Display name should match expected value");
    }

    @Test
    @DisplayName("Should return correct display name for CARGO bike type")
    void shouldReturnCorrectDisplayNameForCargoBike() {
        BikeType cargoBike = BikeType.CARGO;

        String displayName = cargoBike.getDisplayName();

        assertNotNull(displayName, "Display name should not be null");
        assertEquals("Cargo Bike", displayName, "Display name should match expected value");
    }

    @Test
    @DisplayName("Should return correct display name for MOUNTAIN bike type")
    void shouldReturnCorrectDisplayNameForMountainBike() {
        BikeType mountainBike = BikeType.MOUNTAIN;

        String displayName = mountainBike.getDisplayName();

        assertNotNull(displayName, "Display name should not be null");
        assertEquals("Mountain Bike", displayName, "Display name should match expected value");
    }

    // TODO: Test different input values - Add tests for getPricePerMinute() method
    // Hint: Test that each bike type returns the correct price (STANDARD: 0.50,
    // ELECTRIC: 1.00, etc.)

    @Test
    @DisplayName("Should return correct price per minute for STANDARD bike type")
    void shouldReturnCorrectPriceForStandardBike() {
        BikeType standardBike = BikeType.STANDARD;

        Double pricePerMinute = standardBike.getPricePerMinute();

        assertNotNull(pricePerMinute, "Price per minute should not be null");
        assertEquals(0.50, pricePerMinute, "Price per minute should match expected value");
    }

    @Test
    @DisplayName("Should return correct price per minute for ELECTRIC bike type")
    void shouldReturnCorrectPriceForElectricBike() {
        BikeType electricBike = BikeType.ELECTRIC;

        Double pricePerMinute = electricBike.getPricePerMinute();

        assertNotNull(pricePerMinute, "Price per minute should not be null");
        assertEquals(1.00, pricePerMinute, "Price per minute should match expected value");
    }

    @Test
    @DisplayName("Should return correct price per minute for CARGO bike type")
    void shouldReturnCorrectPriceForCargoBike() {
        BikeType cargoBike = BikeType.CARGO;

        Double pricePerMinute = cargoBike.getPricePerMinute();

        assertNotNull(pricePerMinute, "Price per minute should not be null");
        assertEquals(1.20, pricePerMinute, "Price per minute should match expected value");
    }

    @Test
    @DisplayName("Should return correct price per minute for MOUNTAIN bike type")
    void shouldReturnCorrectPriceForMountainBike() {
        BikeType mountainBike = BikeType.MOUNTAIN;

        Double pricePerMinute = mountainBike.getPricePerMinute();

        assertNotNull(pricePerMinute, "Price per minute should not be null");
        assertEquals(0.70, pricePerMinute, "Price per minute should match expected value");
    }

    // TODO: Test if/else branches - Add tests for isElectric() method (branch
    // coverage)
    // Hint: Only ELECTRIC should return true, others should return false

    @Test
    @DisplayName("Should return true for ELECTRIC bike type and false for not electric")
    void shouldReturnTrueForIsElectricAndFalseForNotElectric() {
        for (BikeType bikeTypes : BikeType.values()) {
            if (bikeTypes == BikeType.ELECTRIC) {

                assertTrue(bikeTypes.isElectric(), "ELECTRIC bike should return true");
                System.out.println("EL");
            } else {
                assertFalse(bikeTypes.isElectric(), "Bike should not be electric");
                System.out.println("inte EL");

            }
        }

    }

    // @Test
    // @DisplayName("Should return CARGO bike type")
    // void shouldNotReturnIsElectric() {
    // BikeType cargoBike = BikeType.CARGO;

    // assertFalse(cargoBike.isElectric(), "CARGO bike should not be electric");

    // }

    // TODO: Test switch statement - Add tests for getMaxSpeedKmh() method (all
    // branches)
    // Hint: Test each bike type returns correct max speed (STANDARD: 25, MOUNTAIN:
    // 30, etc.)

    @Test
    @DisplayName("Should return correct max speed for Standard bike type")
    void shouldReturnCorrectMaxSpeedForStandardBike() {
        BikeType standardBike = BikeType.STANDARD;

        Integer maxSpeedKmh = standardBike.getMaxSpeedKmh();

        assertNotNull(maxSpeedKmh, "Max speed should not be null");
        assertEquals(25, maxSpeedKmh, "Max speed should match expected value");

    }

    @Test
    @DisplayName("Should return correct max speed for Electric bike type")
    void shouldReturnCorrectMaxSpeedForElectricBike() {
        BikeType electricBike = BikeType.ELECTRIC;

        Integer maxSpeedKmh = electricBike.getMaxSpeedKmh();

        assertNotNull(maxSpeedKmh, "Max speed should not be null");
        assertEquals(25, maxSpeedKmh, "Max speed should match expected value");

    }

    @Test
    @DisplayName("Should return correct max speed for CARGO bike type")
    void shouldReturnCorrectMaxSpeedForCargoBike() {
        BikeType cargoBike = BikeType.CARGO;

        Integer maxSpeedKmh = cargoBike.getMaxSpeedKmh();

        assertNotNull(maxSpeedKmh, "Max speed should not be null");
        assertEquals(20, maxSpeedKmh, "Max speed should match expected value");

    }

    @Test
    @DisplayName("Should return correct max speed for MOUNTAIN bike type")
    void shouldReturnCorrectMaxSpeedForMountainBike() {
        BikeType mountainBike = BikeType.MOUNTAIN;

        Integer maxSpeedKmh = mountainBike.getMaxSpeedKmh();

        assertNotNull(maxSpeedKmh, "Max speed should not be null");
        assertEquals(30, maxSpeedKmh, "Max speed should match expected value");

    }

    // TODO: Optional - Add parameterized tests using @ParameterizedTest and
    // @EnumSource
    // Hint: Test that all bike types have non-null display names and positive
    // prices

    @Test
    @DisplayName("Should return correct weight for MOUNTAIN bike type")
    void shouldReturnCorrectWeightForMountainBike() {
        BikeType mountainBike = BikeType.MOUNTAIN;

        String weightCategory = mountainBike.getWeightCategory();

        assertNotNull(weightCategory, "weight category should not be null");
        assertEquals("Medium-Heavy", weightCategory, "weight category should match expected value");

    }

    @Test
    @DisplayName("Should return correct weight for all bike types")
    void shouldReturnCorrectWeight() {
        for (BikeType bikeTypes : BikeType.values()) {
            String weight = bikeTypes.getWeightCategory();
            if (bikeTypes == BikeType.ELECTRIC) {

                assertEquals("Heavy", weight, "weight category should match expected value");

            } else if (bikeTypes == BikeType.CARGO) {

                assertEquals("Very Heavy", weight, "weight category should match expected value");

            } else if (bikeTypes == BikeType.MOUNTAIN) {
                assertEquals("Medium-Heavy", weight, "weight category should match expected value");

            } else {
                assertEquals("Light", weight, "weight category should match expected value");
            }

        }
    }
}

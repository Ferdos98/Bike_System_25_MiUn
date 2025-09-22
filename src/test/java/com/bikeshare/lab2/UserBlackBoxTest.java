package com.bikeshare.lab2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bikeshare.model.User;


/**
 * Lab 2 Template: Black Box Testing for User class
 * 
 
 * 
 * TODO for students:
 * - Challenge 2.1: Add Equivalence Partitioning tests for email validation, name, telephone number (With GenAI help), and fund addition
 * - Challenge 2.2: Add Boundary Value Analysis tests for fund addition
 * - Challenge 2.3: Add Decision Table tests for phone number validation
 * - Optional Challenge 2.4: Add error scenario tests
 */

// This test is just an example to get you started. You will need to add more tests as per the challenges.
@DisplayName("Verify name handling in User class")
class UserBlackBoxTest {
    
    @Test
    @DisplayName("Should store and retrieve user names correctly")
    void shouldStoreAndRetrieveUserNamesCorrectly() {
        // Arrange - Set up test data
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String validEmail = "john.doe@example.com";
        String validPersonnummer = "901101-1237"; // Valid Swedish personnummer
       
        // Act - Execute the method under test
        User user = new User(validPersonnummer, validEmail, expectedFirstName, expectedLastName);
        String actualFirstName = user.getFirstName();
        String actualLastName = user.getLastName();
        String actualFullName = user.getFullName();
        
        // Assert - Verify the expected outcome
        assertNotNull(user, "User should be created successfully");
        assertEquals(expectedFirstName, actualFirstName, "First name should match");
        assertEquals(expectedLastName, actualLastName, "Last name should match");
        assertEquals("John Doe", actualFullName, "Full name should be formatted correctly");
    }
    
    // TODO: Challenge 2.1 - Add Equivalence Partitioning tests for email validation
    // Hint: Test valid emails (user@domain.com) and invalid emails (missing @, empty, etc.)
    

   @Test
    @DisplayName("is email format valid")
        void isEmailFormatValid() {
              User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        // Arrange
    String validEmail = "john.doe@example.com";

    // Act
    boolean result = user.isValidEmail(validEmail);
    //  User user = new User("901101-1237", validEmail, "John", "Doe");

    // Assert
    assertTrue(result, "Email should be valid");
}


 @Test
 @DisplayName("Emails with two or more @ are invalid")
 void isEmailUsingMoreThanOneAt() {
      User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
    //Arrange
    String email = "john@@example.com";
    //Act
    boolean result = user.isValidEmail(email);
    //Assert
    assertFalse(result, "Email with two @ should be invalid");

 }
 @Test
    @DisplayName("Should be invalid if spaces is making it fail")
        void isEmailFormatInvalid() {
              User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        // Arrange      
        String email = "john.doe example.com"; 

        // Act     
        boolean result =  user.isValidEmail(email);  
           // Assert
        assertFalse(result, "Email without spaces should be invalid");
        
}
 @Test
    @DisplayName("Should be invalid if there is no dot before com")
        void isEmailUsingNumbers() {
              User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        // Arrange      
        String email = "1234567@hotmailcom"; 

        // Act     
        boolean result =  user.isValidEmail(email);  
           // Assert
        assertFalse(result, "Emails should always have a dot before com");
        
}
        

    // TODO: Challenge 2.2 - Add Boundary Value Analysis tests for fund addition
    // Hint: Test minimum (0.01), maximum (1000.00), and invalid amounts (0, negative, > 1000)
  @Test
  @DisplayName("Should accept maximum fund addition")
  void shouldAcceptMaximumFundAddition() {
 User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
    //Arrange
        double money = 1000.00;
        //act
        //  user.addFunds(money);
        //assert
        assertDoesNotThrow(() -> user.addFunds(money));
  }
    @Test
   @DisplayName("Should accept minimum fund addition")
   void shouldAcceptMinimumFundAddition() {
     User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
     //Arrange
        double money = 0.01;
        //act
    //    user.addFunds(money);
        //assert
        assertDoesNotThrow(() -> user.addFunds(money));
    
   
   }
   
    @Test
    @DisplayName("Should not accept zero or negative fund addition")
    void shouldNotAcceptZeroOrNegativeFundAddition() {
        User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        //Arrange
        int money = 0;
        //act
    //    user.addFunds(money);
        //assert
         assertThrows(IllegalArgumentException.class,
            () -> user.addFunds(money));        
    }
  
    
    
    @Test
    @DisplayName("Should not exceed maximum fund addition")
    void shouldNotExceedMaximumFundAddition() {
            User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        //Arrange
           int money = 1001; // Arrange
            
       assertThrows(IllegalArgumentException.class,
            () -> user.addFunds(money));       
        

    }
    @Test
    @DisplayName("Should not accept negative fund addition")
    void shouldNotAcceptNegativeFundAddition() {  
          User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        //Arrange
           int money = -100; // Arrange
      
       assertThrows(IllegalArgumentException.class,
            () -> user.addFunds(money));       

    }

    // TODO: Challenge 2.3 - Add Decision Table tests for phone number validation
    // Hint: Test Swedish phone formats (+46701234567, 0701234567) and invalid formats
    @Test
    void basicShouldNotGetDiscount() {
          User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
  
        // user.getMembershipType();   

        assertEquals(0.0, user.calculateDiscount(), "Basic ska inte ge rabatt");
    }
    
    // TODO: Challenge 2.4 - Add error scenario tests
    // Hint: Test insufficient balance, invalid inputs, state violations
}

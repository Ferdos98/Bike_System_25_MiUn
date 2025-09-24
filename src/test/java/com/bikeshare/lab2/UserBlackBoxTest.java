package com.bikeshare.lab2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.bikeshare.model.User;
// import com.bikeshare.model.User.MembershipType;
import com.bikeshare.model.MembershipType; 


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
@DisplayName("Name should not be null or empty")
    void nameShouldNotContainNull() {
        //Arrange
        // String name = " ";
      User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        
        //Act
        // user.getFirstName();
        //Assert        
         assertThrows(IllegalArgumentException.class,
            () -> user.setFirstName(" "));        
    }
        
@Test
@DisplayName("Name should not be null or empty")
    void lastNameShouldNotContainNull() {
        //Arrange        
      User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        
        //Act
        // user.getFirstName();
        //Assert        
         assertThrows(IllegalArgumentException.class,
            () -> user.setLastName(" "));        
    }

    //AI generated for phone number
@Test
    void shouldAcceptValidSwedishMobileWithCountryCode() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        assertDoesNotThrow(() -> user.setPhoneNumber("+46701234567"));
        assertEquals("+46701234567", user.getPhoneNumber());
        assertFalse(user.isPhoneVerified(), "Phone should not be verified after setting");
    }
 
    @Test
    void shouldAcceptValidSwedishMobileWithoutCountryCode() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        assertDoesNotThrow(() -> user.setPhoneNumber("0701234567"));
        assertEquals("0701234567", user.getPhoneNumber());
    }
 
    @Test
    void shouldCleanPhoneNumberWithSpacesAndDashes() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        user.setPhoneNumber("(070) 123-45 67");
        assertEquals("0701234567", user.getPhoneNumber());
    }
 
    @Test
    void shouldRejectInvalidTooShortNumber() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        assertThrows(IllegalArgumentException.class,
                () -> user.setPhoneNumber("12345"));
    }
 
    @Test
    void shouldRejectInvalidCharacters() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        assertThrows(IllegalArgumentException.class,
                () -> user.setPhoneNumber("07012ABCD"));
    }
 
    @Test
    void shouldAllowNullPhoneNumber() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        assertDoesNotThrow(() -> user.setPhoneNumber(null));
        assertNull(user.getPhoneNumber());
    }
 
    @Test
    void shouldAllowEmptyPhoneNumber() {
        User user = new User("901101-1237", "anna@example.com", "Anna", "Jonsson");
 
        user.setPhoneNumber("   ");
        assertNull(user.getPhoneNumber());
    }

    @Test
    @DisplayName("should not be able to withdraw more than balance")
    void shouldNotBeAbleToWithdrawMoreThanBalance() {
        User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
        
        //Arrange
        
            double balance = user.getAccountBalance(); 
            double money = 300;   
            double newBalance = balance - money;

            //  = balance + money; // Arrange   

        //Assert
        assertThrows(IllegalArgumentException.class,
            () -> user.deductFunds(newBalance));

     
    }
    // @Test
    // @DisplayName("Should not be able to add fund null")
    // void shouldNotBeAbleToAddFundNull() {
    //       User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
    //       //act
    //         double money = 0;    
          
   
    //     //Assert        
    //     assertNull(user.addFunds(money));   
        
       
 
    // }
     

    // @Test
    // @DisplayName("Name should not contain numbers")
    // void nameShouldNotContainNumbers() {
    //      User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");

    //      assertThrows(IllegalArgumentException.class,
    //         () -> user.setFirstName("f12324"));
    // }
   
      

    

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
  
        //  user.updateMembership(User.MembershipType.BASIC);

        assertEquals(0.0, user.calculateDiscount(), "Basic ska inte ge rabatt");
    }

//   @Test
//     void basicShouldNotGetFreeMinutes() {
//         // User user = new User("901101-1237", "ferdos_98@hotmail.se", "ferdos", "khalili");
//         MembershipType membershipType = MembershipType.BASIC;


//         // user.getMembershipType();
//         int freeMinutes = membershipType.BASIC.getFreeMinutesPerRide();        

 
//         assertEquals(60, freeMinutes, "Basic ska inte ge gratis minuter");
//         //Rapport
//     }
    
    @Test
    @DisplayName("Basic should give 0% discount")
    void basic_hasZeroDiscount() {
           
        Double discount = MembershipType.BASIC.getDiscountRate(); 
        assertEquals(0, discount);
    }
     @Test
    @DisplayName("Premium should give 15% discount")
    void premiumDiscount() {
           
        Double discount = MembershipType.PREMIUM.getDiscountRate(); 
        assertEquals(0.15, discount);
    }
     @Test
    @DisplayName("vip should give 25% discount")
    void vipDiscount() {
           
        Double discount = MembershipType.VIP.getDiscountRate(); 
        assertEquals(0.25, discount);
    }
     @Test
    @DisplayName("Student should give 20% discount")
    void studentDiscount() {
           
        Double discount = MembershipType.STUDENT.getDiscountRate(); 
        assertEquals(0.20, discount);
    }
     @Test
    @DisplayName("corporate should give 10% discount")
    void corporateDiscount() {
           
        Double discount = MembershipType.CORPORATE.getDiscountRate(); 
        assertEquals(0.10, discount);
    }


    @ParameterizedTest(name = "{0} should give {1} discount")
    @CsvSource({
        "BASIC, 0.00",
        "PREMIUM, 0.15",
        "VIP, 0.25",
        "STUDENT, 0.20",
        "CORPORATE, 0.10"
    })
    void membershipDiscounts(MembershipType type, double expected) {
        assertEquals(expected, type.getDiscountRate(), 0.0001);
    }
}


//     // TODO: Challenge 2.4 - Add error scenario tests
//     // Hint: Test insufficient balance, invalid inputs, state violations
// }

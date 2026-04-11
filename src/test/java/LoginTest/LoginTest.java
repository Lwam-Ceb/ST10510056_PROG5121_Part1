/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package LoginTest;

import com.mycompany.chatapppart1.LogIn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Admin
 */
public class LoginTest {
    @Test
    
    
    public void UsernameTestValid() {//Testing if the username entered is valid
        LogIn userA = new LogIn(); //Adds a test user and connects the test to the login file
        boolean result = userA.checkUserName("kyl_1");
        assertTrue(result);//Checking if the username is fake
    }
    
    @Test
    
    public void UsernameTestInValid() {//Testing if the username entered is invalid
        LogIn userB = new LogIn(); //Adds a test user and connects the test to the login file
        boolean result = userB.checkUserName("kyle!!!!!!!");
        assertFalse(result);//Checking to see if the username is true
    }
    
    @Test
    
    public void PasswordTestValid() {//Testing if the password entered is valid
        LogIn KeyA = new LogIn(); //Adds a test password and connects the test to the login file
        boolean result = KeyA.checkPasswordCompatability("Ch&&sec@ke99!");
        assertTrue(result);//Checking to see if the password is valid
    }
    
    @Test
    
    public void PasswordTestInValid() {//Testing if the password entered is invalid
        LogIn KeyB = new LogIn(); //Adds a test password and connects the test to the login file
        boolean result = KeyB.checkPasswordCompatability("password");
        assertFalse(result);//Checking to see if the password is invalid
    }
    
    @Test
    
    public void CellphoneTestValid() {//Testing if the Phone number entered is valid
        LogIn NumberA = new LogIn(); //Adds a test number and connects the test to the login file
        boolean result = NumberA.checkCellPhoneNumber("+27838968976");
        assertTrue(result);//Checking to see if the Number is valid
    }
    
    @Test
    
    public void CellphoneTestInValid() {//Testing if the Phone number entered is invalid
        LogIn NumberB = new LogIn(); //Adds a test number and connects the test to the login file
        boolean result = NumberB.checkCellPhoneNumber("08966553");
        assertFalse(result);//Checking to see if the Number is valid
    }
    @Test
    public void RegisterUserValid() { //Testing if the register entered is valid
        LogIn userA = new LogIn(); //Adds a test user and connects the test to the login file
        String result = userA.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976" );
        assertEquals("User registered successfully", result);//Gives back the result that youve been registered
    }
    
    @Test
    
    public void RegisterUserInValidUsername() { //Testing if the user registered an invalid username
        LogIn userA = new LogIn(); //Adds a test user and connects the test to the login file
        String result = userA.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976" );
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);//Gives back the result that your username is incorrect
    }
    
    @Test
    
    public void RegisterUserInValidPassword() { //Testing if the user registered an invalid password
        LogIn userA = new LogIn(); //Adds a test user and connects the test to the login file
        String result = userA.registerUser("kyl_1", "password", "+27838968976" );
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);//Gives back the result that your password is incorrect
    }
    
     @Test
    
    public void RegisterUserInValidPhoneNumber() { //Testing if the user registered an invalid phone number
        LogIn userA = new LogIn(); //Adds a test user and connects the test to the login file
        String result = userA.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553" );
        assertEquals("Cell phone number is incorrectly formatted or does not contain international code.", result);//Gives back the result that your phone number is incorrect
    }
}

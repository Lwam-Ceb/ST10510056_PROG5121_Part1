/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package MessageTest;

import org.junit.jupiter.api.Test;
import com.mycompany.chatapppart1.Messages;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Unit tests for the Messages class
 * 
 * These tests verify:
 *  Message length validation
 *  Recipient number validation
 *  Message hash creation
 *  Message ID generation
 *  Functionality of Save, Store and Discard
 * 
 * @author lcebi
 */
public class MessageTest {
    
    
    @Test
    public void testMessageLengthValid() { //Testing messages under 250 characters
        
        Messages msg = new Messages( 1,"+27718693002", "Hi Mike, can you join us for dinner tonight?" );//Creating a message with characters under 250

        String result = msg.checkMessageLength(); //Checks message length
        
        assertEquals("Message ready to send.", result); // Asks user to verify result
        
    }
    
    
    @Test
    public void testMessageLengthInvalid() { //Testing messages over 250 characters
        
        String longMessage = "a".repeat(260); // Repeating "a" to create a message with 260 characters
        
        Messages msg = new Messages( 1, "+27718693002", longMessage); //Test message creation
        
        String result = msg.checkMessageLength();//Checks message length
        
        assertEquals( "Message exceeds 250 characters by 10, please reduce the size.",result); // Tells user that message is over the character limit
                
    }
    
    @Test
    public void testRecipientNumberValid() { //Test for when the recipents number is valid
        
        
        Messages msg = new Messages( 1,"+27718693002","Hi Mike, can you join us for dinner tonight?" );//Valid Recipeint number given with a message
        
        String result = msg.checkRecipientCell();//Checks recipient cellphone
        
         assertEquals( "Cell phone number successfully captured.",result);//Produces a success message for the cellphone capture
         
    }
    
    @Test
    public void testRecipientNumberInvalid() { //Test for when the recipents number is invalid
        
        Messages msg = new Messages( 2,"08575975889", "Hi Keegan, did you receive the payment?"); //Invalid Recipeint number given with a message
        
        String result = msg.checkRecipientCell();//Checks recipients cellphone
        
        assertEquals("Cell phone number incorrectly formatted or does not contain international code. Please correct the number and try again.", result);//Produces a unsuccessful message for the cellphone capture
        
    }
    
    @Test
    public void testMessageHashCreated() { //Test for when Message Hash is made correctly
        
        Messages msg = new Messages(0, "+27718693002", "Hi Mike, can you join us for dinner tonight?");//Text message created
        
        String hash = msg.getMessageHash();//Generates Hash 
        
        assertTrue(hash.contains("HITONIGHT?"));// Checks if Hash contains needed text
                
    }
    
    @Test
    public void testMessageIDCreated() { //Test for the creation of a Message ID
        
        Messages msg = new Messages(1, "+27718693002", "Test message");
        
        String id = msg.getMessageID();//Generates random numbers for ID
        
        assertNotNull(id);//Checks if the ID isnt null
        
        assertEquals(10, id.length());//Checks if ID is the set 10 digits
    }
    
    @Test
    public void testSentMessageOptionSend() { //Test when selecting the send option
        
        Messages msg = new Messages(1, "+27718693002","Hello");//Creates test scenerio
        
        String result = msg.sentMessage("send");//Simulating the send option
        
        assertEquals("Message successfully sent.", result);//Shows the results of the message sending
        
    }
    
    @Test
    public void testSentMessageOptionDisregard() { //Test when selecting the disgard option
        
        Messages msg = new Messages(1, "+27718693002","Hello");//Creates test scenerio
        
        String result = msg.sentMessage("disregard");//Simulating the delete option
        
        assertEquals( "Press 0 to delete the message.", result);//Shows the results of the message being deleted and how to delete it
      
    }
    
    @Test
    public void testSentMessageOptionStore() { //Test when selecting the store option
        
        Messages msg = new Messages(1, "+27718693002","Hello");//Creates test scenerio
        
        String result = msg.sentMessage("store");//Simulating the store option
        
        assertEquals("Message successfully stored.", result);//Shows the results of the message being stored
        
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package MessageTest;

import org.junit.jupiter.api.Test;
import com.mycompany.chatapppart1.Messages;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

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
    
    //===== Part 3 =====
    @BeforeEach
    public void setup() {
        
         Messages.clearArrays();
         
         Messages msg1 = new Messages(1, "+27834557896", "Did you get the cake?");
         msg1.sentMessage("send");
         
         Messages msg2 = new Messages(2, "+27838884567", "Where are you? You are late! I have asked you to be on time.");
         msg2.sentMessage("store");
         
         Messages msg3 = new Messages(3, "+27834484567", "Yohoooo, I am at your gate.");
         msg3.sentMessage("disregard");
         
         Messages msg4 = new Messages(4, "0838884567", "It is dinner time!");
         msg4.sentMessage("send");
         
         Messages msg5 = new Messages(5, "+27838884567", "Ok, I am leaving without you.");
         msg5.sentMessage("store");
    }
    
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
        
        assertTrue(hash.endsWith(":0:HITONIGHT"));// Checks if Hash contains needed text
                
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
    
    @Test
    public void testSentMessagesArray_correctlyPopulated() {
        
        assertEquals(2, Messages.getSentMessages().size());
        
        assertTrue(Messages.getSentMessages().contains("Did you get the cake?"));
        
        assertTrue(Messages.getSentMessages().contains("It is dinner time!"));
        
    }
    
    @Test
    public void testDisplayLongestMessage_returnsCorrectMessage() {
        
        String result = Messages.displayLongestMessage();
        
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        
    }
    
    @Test
    public void testSearchByMessageID_returnsCorrectMessage() {
        
        String messageFourID = Messages.getMessageIDs().get(2);
        
        String result = Messages.searchByMessageID(messageFourID);
        
        assertEquals("It is dinner time!", result);
        
    }
    
    @Test
    public void testSearchByRecipient_returnsAllMatchingMessages() {
        
        String result = Messages.searchByRecipient("+27838884567");
        
        assertTrue(result.contains("Where are you? You are late! I have asked you to be on time."));
        
        assertTrue(result.contains("Ok, I am leaving without you."));

    }
    
    @Test
    public void testDeleteByHash_removesCorrectMessage() {
        
        String messageTwoHash = Messages.getMessageHashes().get(1);
        
        String result = Messages.deleteByMessageHash(messageTwoHash);
        
        assertEquals("Message: Where are you? You are late! I have asked you to be on time. successfully deleted.", result);
        
    }
    
    @Test
    public void testDisplayReport_containsRequiredFields() {
        
        String report = Messages.displayFullReport();
        
        assertTrue(report.contains("Message Hash:"));
        assertTrue(report.contains("Recipient:"));
        assertTrue(report.contains("Message:"));
        assertTrue(report.contains("Did you get the cake?"));
        assertTrue(report.contains("It is dinner time!"));
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

import java.util.Scanner;
/**
 *
 * @author Student
 */
//Updated Part 2
public class MainApp {
      public static void main(String[] args) { 
          
          //Scanner allows for information to be typed in
          Scanner input = new Scanner(System.in);
          //Creating an login class to call it later
          LogIn login = new LogIn();
        
          
          String response;
          boolean running = true;
          int loginFail = 1;
          
          // Part 1: Registation Point
          System.out.println("=== USER REGISTRATION ===");
          
          do{
          System.out.print("Enter a username ");
          String username = input.nextLine();
          
          System.out.print("Enter a password ");
          String password = input.nextLine();
          
          //Calls up the registerUser method and stores message it returns
          System.out.print("Enter your South African phone number (+27...): ");
          String phone = input.nextLine();
          
          response = login.registerUser(username, password, phone);
          
          // Shows the registraion message
          System.out.println(response);
          
          //Shows when registry is successful
          } while (!response.equals("User registered successfully"));
              
          
          // Part 1: Login Point
          System.out.println("\n=== USER LOGIN ===");
          
          boolean loggedIn = false;
          
          //You have 3 attempts to enter the right login details
          while(loginFail <= 3){
         
          
          System.out.print("Enter a username ");
          String loginUsername = input.nextLine();
          
          System.out.print("Enter a password ");
          String loginPassword = input.nextLine();
          
          
          //Calls in LoginUser which checks if details match with anyone whos registered
          loggedIn = login.loginUser(loginUsername, loginPassword);
          
          System.out.println(login.returnLoginStatus(loggedIn));
          //Part 2: Messaging (If you logged in)
          // Open if the user if login is sucessful
          if (loggedIn) {
              
            
          
              //Show a Welcome Message
              
              System.out.println("\n==============================");
              System.out.println("Welcome to ChatApp.");
              System.out.println("==============================");
              
              break;
        
          } else{
              //Counts the attempts you made in trying to login if you get something wrong
              
              System.out.println("Attempts used: " + loginFail + " / 3");

              loginFail++;
          } 
          } 
          if (!loggedIn) {
              System.out.println("Too many failed login attempts.");
              System.exit(0);
          }
          
            // Load stored messages from JSON before showing menu
            // It is currently commented out so only messages from the current run are shown
            //Messages.loadStoredMessages();
            
            
              //================Main Menu=========================
               //The menu loops till 3 is chosen (Ends loop)
            while (running) {
                
                //Shows the Menu
                System.out.println("\n=== CHAT APP MENU ===");
                
                System.out.println("1. Send Messages");
                
                System.out.println("2. Show Recently Sent Messages");
                
                System.out.println("3. Quit");
                
                System.out.println("4. Stored Messages");
                
                //User selects their choice
                System.out.print("Choose an option: ");
                
                //Allows for the user to pick a option
                int choice = input.nextInt();
                input.nextLine();
                
                
               //Implements a switch option and shows these options based on your choice 
                switch (choice) {
                    
                    //Picking 1:
                    case 1:
                        
                        //Picking option 1 will show this message
                        System.out.print("How many messages would you like to send? ");
                        
                        // Store number of messages
                        int numMessages = input.nextInt();
                        
                        //Prevents number of messages from going below zero
                        if (numMessages <= 0) {
                            
                            System.out.println("Please enter a number greater than 0.");
                            
                            break; 
                            
                        }
                        
                        // Clear scanner buffer
                        input.nextLine();
                        
                        // For loop runs exactly the amount of Message times
                        for (int i = 0; i < numMessages; i++) {
                            
                            // Message number shown to the user
                            int messageNumber = i + 1;
                            
                            // Display message heading
                            System.out.println("\n--- Message " + messageNumber + " ---");
                            String recipient;
                            Messages msg;

                            // Keep asking until recipient is valid
                        while (true) {

                        System.out.print("Enter recipient cellphone number: ");
                        recipient = input.nextLine();

                        msg = new Messages(messageNumber, recipient, "");

                        String recipientResult = msg.checkRecipientCell();
                        System.out.println(recipientResult);

                        if (recipientResult.equals("Cell phone number successfully captured.")) {
                
                        break;
                    }
                }
                         
                          String messageText;

                        while (true) {
                        System.out.print("Enter your message: ");
                        messageText = input.nextLine();

                        msg = new Messages(messageNumber, recipient, messageText);

                        String lengthResult = msg.checkMessageLength();
                        System.out.println(lengthResult);

                        if (lengthResult.equals("Message ready to send.")) {
                            
                break;
        }
        }
                        
                        

                                 
                                 //Shows secondary menu
                                 System.out.println("\nChoose an option:");
                                 
                                 System.out.println("1. Send Message");
                                 
                                 System.out.println("2. Store Message");
                                 
                                 System.out.println("3. Disregard Message");
                                 
                                 System.out.print("Enter option: ");
                                 
                                 //Enter selected choice
                                 int sendChoice = input.nextInt();
                                 
                                 input.nextLine();
                                 
                                 //Stores the returned message from the message you write in sentMessage()
                                 String result;
                                 
                                 
                                 switch (sendChoice) {
                                     
                                     case 1:
                                         
                                         //Picking option 1: sends message
                                         result = msg.sentMessage("send");
                                         
                                         break;
                                     
                                     case 2:
                                         
                                         //Picking option 2: stores message
                                         result = msg.sentMessage("store");
                                         
                                         break;
                                         
                                     case 3:
                                         //Picking option 3: disgards message
                                         result = msg.sentMessage("disregard");
                                         
                                         break;
                                         
                                     default:
                                         // When an invalid option is selected
                                         result = "Invalid option selected.";
                                         
                                         break;
                                 }
                                 
                                 System.out.println(result);
                                 
                                
                                 //For when option 3 is selected to disregard the message
                                 if (!msg.getSendStatus().equals("Disregarded")) {
                                     
                                     System.out.println("\n=== MESSAGE DETAILS ===");
                                     
                                     System.out.println("Message ID: " + msg.getMessageID());//Show message ID
                                     
                                     System.out.println("Message Hash: " + msg.getMessageHash());//Show Message Hash
                                     
                                     System.out.println("Recipient: " + msg.getRecipientCell()); //Show recipent number
                                     
                                     System.out.println("Message: " + msg.getMessageText());//Display written message
                                 }
                             }
                            
                            
                            
                        
                        // Display total messages sent or stored
                        System.out.println("\nTotal messages sent/stored: " + Messages.returnTotalMessages());
                        
                        break;
                    
                    //Picking 2:    
                    case 2:
                        
                        //Picking option 2 will show that this is in development
                        System.out.println("\\n=== SENT MESSAGE HISTORY ===");
                       
                        System.out.println(Messages.printMessages());
                        
                        
                        break;
                    
                    //Picking 3:    
                    case 3:
                        
                        //Picking option 3 will show this message
                        System.out.println("Goodbye.");
                        
                        
                        // Clear JSON file when exiting
                        Messages.clearJsonFile();
                        Messages.clearArrays();
                        
                        // Stops the while loop
                        running = false;
                    
                        break;   
                        
                    // Picking 4:                       
                    case 4:
                        
                        // Shows the stored messages sub-menu
                        System.out.println("\n=== STORED MESSAGES MENU ===");
                        System.out.println("a. Display all stored messages");
                        System.out.println("b. Display longest message");
                        System.out.println("c. Search by message ID");
                        System.out.println("d. Search by recipient");
                        System.out.println("e. Delete by message hash");
                        System.out.println("f. Display full report");
                        
                        System.out.print("Choose an option: ");
                        
                        // Stores the user's sub-menu choice
                        String storedChoice = input.nextLine();
                        
                        switch (storedChoice.toLowerCase()) {
                            
                            case "a":
                                System.out.println(Messages.displayStoredMessages());// Option a: Displays all stored messages
                        break;
                        
                            case "b":
                                System.out.println(Messages.displayLongestMessage());// Option b: Displays the longest stored message
                        
                        break;
                        
                            case "c":
                                System.out.print("Enter message ID: ");
                                String searchID = input.nextLine();
                                System.out.println(Messages.searchByMessageID(searchID));// Option c: Searches for a message using its message ID
                        
                        break;
                        
                            case "d":
                                System.out.print("Enter recipient number: ");
                                String searchRecipient = input.nextLine();
                                System.out.println(Messages.searchByRecipient(searchRecipient));// Option d: Searches for messages by recipient number
                        break;
                        
                            case "e":
                                System.out.print("Enter message hash: ");
                                String deleteHash = input.nextLine();
                                System.out.println(Messages.deleteByMessageHash(deleteHash));// Option e: Deletes a message using its message hash
                        break;
                        
                            case "f":
                                System.out.println(Messages.displayFullReport());// Option f: Displays the full sent message report
                                
                        break;
                        
                            default:
                                System.out.println("Invalid stored message option.");
                                
                        break;
                        
                        }
                        
                        break;
                        
                        
                    default:
                        
                        //Pick an option not on the menu
                        System.out.println("Invalid option. Please choose 1, 2, 3, or 4.");
                       
                        break;
                        
                }
            }
          
          
                //Close scanner
                input.close();
     }
  
      }


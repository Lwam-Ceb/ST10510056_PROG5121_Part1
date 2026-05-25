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
          
          // Part 1: Registation Point
          System.out.println("=== USER REGISTRATION ===");
          
          System.out.print("Enter a username ");
          String username = input.nextLine();
          
          System.out.print("Enter a password ");
          String password = input.nextLine();
          
          //Calls up the registerUser method and stores message it returns
          System.out.print("Enter your South African phone number (+27...): ");
          String phone = input.nextLine();
          
          String response = login.registerUser(username, password, phone);
          
          // Shows the registraion message
          System.out.println(response);
          
          // Part 1: Login Point
          System.out.println("\n=== USER LOGIN ===");
          
          boolean loggedIn = false;
          
          while (!loggedIn) {
              
          
          System.out.print("Enter a username ");
          String loginUsername = input.nextLine();
          
          System.out.print("Enter a password ");
          String loginPassword = input.nextLine();
          
          //Calls in LoginUser which checks if details match
          loggedIn = login.loginUser(loginUsername, loginPassword);
          
          //Print out the correct login message
          String loginMessage = login.returnLoginStatus(loggedIn);
          System.out.println(loginMessage);
          
          //Part 2: Messaging (If you logged in)
          // Open if the user if login is sucessful
          if (loggedIn) {
              
              System.out.println("Incorrect login details. Please try again.\n");
              
          }
          }
              //Show a Welcome Message
              System.out.println("=====Welcome to ChatApp.=======");
              
              //Lets the user pick a number
              boolean running = true;
              
              
               //The menu loops till 3 is chosen (Ends loop)
            while (running) {
                
                //Shows the Menu
                System.out.println("\n=== CHAT APP MENU ===");
                
                System.out.println("1. Send Messages");
                
                System.out.println("2. Show Recently Sent Messages");
                
                System.out.println("3. Quit");
                
                //User selects their choice
                System.out.print("Choose an option: ");
                
                // Prevent crash if user types letters
            if (!input.hasNextInt()) {
                
                System.out.println("Invalid input. Please enter 1, 2, or 3.");
                
                // clears invalid input
                input.nextLine();
                
                continue;
            }

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
                        
                        // Clear scanner buffer
                        input.nextLine();
                        
                        // For loop runs exactly numMessages times
                        for (int i = 0; i < numMessages; i++) {
                            
                            // Message number shown to the user
                            int messageNumber = i + 1;
                            
                            // Display message heading
                            System.out.println("\n--- Message " + messageNumber + " ---");
                            
                            // Ask the user to type a message
                            System.out.print("Enter your message: ");
                            String message = input.nextLine();
                            
                            // Display sent message confirmation
                            System.out.println("Message sent: " + message);
                            
                        }
                        
                        
                        break;
                    
                    //Picking 2:    
                    case 2:
                        
                        //Picking option 2 will show that this is in development
                        System.out.println("Coming Soon.");
                       
                        break;
                    
                    //Picking 3:    
                    case 3:
                        
                        //Picking option 3 will show this message
                        System.out.println("Goodbye.");
                        
                        // Stops the while loop
                        running = false;
                    
                        break;   
                        
                    default:
                        
                        //Pick an option not on the menu
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                       
                        break;
                        
                }
            }
          
          
                //Close scanner
                input.close();
     }
  
      }

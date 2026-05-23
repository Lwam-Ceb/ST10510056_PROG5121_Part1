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
          
          System.out.print("Enter a username ");
          String loginUsername = input.nextLine();
          
          System.out.print("Enter a password ");
          String loginPassword = input.nextLine();
          
          //Calls in LoginUser which checks if details match
          boolean loggedIn = login.loginUser(loginUsername, loginPassword);
          
          //Print out the correct login message
          String loginMessage = login.returnLoginStatus(loggedIn);
          System.out.println(loginMessage);
          
         // Open if the user if login is sucessful
          if (loggedIn) {
              
              
              System.out.println("\nWelcome to ChatApp.");
              
              //Lets the user pick a number
              int choice = 0;
              
               //The menu loops till 3 is chosen (Ends loop)
            while (choice != 3) {
                
                //Shows the Menu
                System.out.println("\n=== CHAT APP MENU ===");
                
                System.out.println("1. Send Messages");
                
                System.out.println("2. Show Recently Sent Messages");
                
                System.out.println("3. Quit");
                
                //User selects their choice
                System.out.print("Choose an option: ");
                
                choice = input.nextInt();

                input.nextLine();
                
               //Implements a switch option and shows these options based on your choice 
                switch (choice) {
                    
                    case 1:
                        
                        //Picking option 1 will show this message
                        System.out.println("Send Messages selected.");
                        
                        break;
                    
                    case 2:
                        
                        //Picking option 1 will show this message
                        System.out.println("Recently Sent Messages selected.");
                        break;
                    
                    case 3:
                        
                        //Picking option 3 will show this message
                        System.out.println("Goodbye.");
                        
                        break;   
                        
                    default:
                        
                        //Pick an option not on the menu
                        System.out.println("Invalid option. Try again.");
                        
                }
            }
          }else{
                       //If login failed
                       System.out.println("Login failed. Exiting application.");
                       
          }
          
                //Close scanner
                input.close();
      }
  
}

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
public class MainApp {
      public static void main(String[] args) {
          //Scanner allows for information to be typed in
          Scanner input = new Scanner(System.in);
          //Creating an login class to call it later
          LogIn login = new LogIn();
          
          // Registation Point
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
          
          // Login Point
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
          
      }
  
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

/**
 *
 * @author Student
 */
public class LogIn {
    
    // These strings will store the user's details.
    // Once a user resgisters, their data is saved here.
    
    String username;
    String password;
    String phoneNumber;
    
    // - The written Username will contain an underscore "_"
    // - Username is less than 5 characters long. 
    
    public boolean checkUserName(String username) {
    
    // username.contains will check for an underscore ("_").
    // username.length() <= 5 will confirm the username is less than 5.
    
    return username.contains("_") && username.length() <=5;
    
    }
    // This string will validate the user's password
    // The password will have to be strong to be validated.
    
    public boolean checkPasswordCompatability(String password) {
        
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
    // Check through loops of each character in the password   
    
        for (int i = 0; i <password.length(); i++) {
        char c = password.charAt(i); // gets the current character in the password
        
        if (Character.isUpperCase(c)) {
            hasCapital = true; //There is a capital letter in the password
        }
        else if (Character.isDigit(c)) {
            hasNumber = true; //There is a Digit in the password  
        }    
        else if (!Character.isLetterOrDigit(c)) {
           hasSpecial = true; //There is a special character in the password
  
        }
    }
    //Checks if the password is at least 8 characters long and fits all password requirements
        return password.length() >=8 && hasCapital && hasNumber && hasSpecial; 
    }
    
    // This string will check the users phonenumber on the password being no more than 12 numbers long
    
    public boolean checkCellPhoneNumber(String phone){
        return phone.startsWith("+27") && phone.length() <=12;
       
    } 
    
    //Checking the users information in order to register the User
    public String registerUser(String username, String password, String phoneNumber) {
        
      
        if(!checkUserName(username)){ //Checks users Username, if inncorrect this text will be shown until the username fits the requirements
           return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
       }
        
        if(!checkPasswordCompatability(password)){ //Checks the users Password, if it doesnt comply with the format it'll require you to retry until its correct
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        if(!checkCellPhoneNumber(phoneNumber)){ //Checks users Phone Number, if the phone number does not contain the international code or isnt formatted correctly itll show incorrect until a valid number is written
            return "Cell phone number is incorrectly formatted or does not contain international code.";
        }
        //If all information entered is valid, register this applicant
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        
        return"User registered successfully";
        
    } 
    //Allows the user to log in with the details used to register with
    public boolean loginUser(String username, String password){
        
        if(this.username == null || this.password == null){
        return false;
        
        }

        return this.username.equals(username) && this.password.equals(password);
        
    }
   
    
    public String returnLoginStatus(boolean success){
            
           if(success){
            return "Welcome " + this.username + ", it is great to see you again.";
            }else{
            return "Username or password incorrect, please try again.";
        }    
    }
}
   

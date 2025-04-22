/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

/**
 *
 * @author njabu
 */
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Login {
    //declaring my variables
    // Instance variables to store user information
    String firstName;
    String lastName;
    String userName;
    String passWord;
    String cellPhoneNumber;
    Scanner scanner = new Scanner(System.in);// Scanner object to read input from the user
    
// Method to capture and validate the user's name and username
// then continuously prompts the user to enter a valid username.
public void checkUserName() {
    System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();
        
    System.out.println("Please enter your last name: ");
    lastName = scanner.nextLine();
    
    // Keep asking for a valid username until the correct format is entered
     while(true){
         System.out.println("Please enter your username: ");
         userName = scanner.nextLine();
         // Check if username meets the required format
         if(userName.contains("_") && userName.length()<= 5){
             System.out.println("Username successfully captured");
             break;// Exit the loop when a valid username is entered
         }else{
             System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more that five characters in length.");
         }
     } 
}
// Method to capture and validate password complexity
 public void checkPasswordComplexity(){
    while(true){
    System.out.println("Please enter a password: ");
    passWord = scanner.nextLine();
    // Check if the password meets all complexity requirements
    if (containsSpecialCharacter(passWord) && passWord.length()>= 8 && containsDigit(passWord) && containsUpperCase(passWord)){
        System.out.println("Password successfully captured");
        break;
         }else{
             System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
         }
}
 }
 
 // Method to validate a South African phone number with international code
 public void checkCellPhoneNumber(){
     while (true){
         System.out.println("Please enter your cell phone number, include international code, e.g, +27734664307: ");
         String cellPhone = scanner.nextLine();
         // Regex to match +27 followed by exactly 9 digits
         String regex = "^\\+27\\d{9}$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(cellPhone);
         // If the phone number matches the format, save and exit loop
         if (matcher.matches()){
             cellPhoneNumber = cellPhone;
             System.out.println("Cell phone number successfully added");
             break;
         }else{
             System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
         }
     }
 }
 
 // Helper method to check if a string contains at least one uppercase letter
  private boolean containsUpperCase(String str){
      for( char c: str.toCharArray()){
          if (Character.isUpperCase(c)){
              return true;
          }
      }
      return false;
  }
  
  // Helper method to check if a string contains at least one digit
  private boolean containsDigit(String str){
      for (char c: str.toCharArray()){
          if ( Character.isDigit(c)){
              return true;
          }
      }
      return false;
  }
  
  // Helper method to check if a string contains at least one special character
  private boolean containsSpecialCharacter(String str){
      for (char c: str.toCharArray()){
          if (!Character.isLetterOrDigit(c)){
              return true;
      }
  }
  return false;
}
  
  // Method to simulate login by checking entered credentials against registered ones
  // It prompts the user to enter their username and password and checks if it matches the stored credentials.
 // If correct, it displays a welcome message. If incorrect, it loops until the correct credentials are provided.
  public void loginUser(){
      System.out.println("\nLogin to you account using the same username and password");
      System.out.println("----------------------------------------------------------------");
    // Keep prompting for login until correct credentials are entered
      while (true) {
      System.out.println("Enter your user name: ");
      String loginUserName = scanner.nextLine();
      
      System.out.println("Enter your password: ");
      String loginPassWord = scanner.nextLine();
       // Check if the entered credentials match the stored ones
      if ((loginUserName.equals(userName)) && (loginPassWord.equals(passWord))){
          System.out.println("Welcome " + firstName + "  " + lastName + " It is great to see you!");
          break;
      }else{
          System.out.println("Username or password incorrect, please try again.");
      }
} 
  }
      /**
     * @param args the command line arguments
     */
  // Main method to run the entire login and registration system
    public static void main(String[] args) {
        Login user = new Login(); 
        user.checkUserName();            // Ask for name and validate username
        user.checkPasswordComplexity();  // Ask for and validate password
        user.checkCellPhoneNumber();     // Ask for and validate phone number
        user.loginUser();                // Prompt user to log in with the registered credentials
    }
}

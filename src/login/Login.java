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
    String firstName;
    String lastName;
    String userName;
    String passWord;
    String cellPhoneNumber;
    Scanner scanner = new Scanner(System.in);

public void checkUserName() {
    System.out.println("Enter your first name: ");
        firstName = scanner.nextLine();
        
    System.out.println("Please enter your last name: ");
    lastName = scanner.nextLine();
    
     while(true){
         System.out.println("Please enter your username: ");
         userName = scanner.nextLine();
         
         if(userName.contains("_") && userName.length()<= 5){
             System.out.println("Username successfully captured");
             break;
         }else{
             System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more that five characters in length.");
         }
     } 
}
 public void checkPasswordComplexity(){
    while(true){
    System.out.println("Please enter a password: ");
    passWord = scanner.nextLine();
    
    if (containsSpecialCharacter(passWord) && passWord.length()>= 8 && containsDigit(passWord) && containsUpperCase(passWord)){
        System.out.println("Password successfully captured");
        break;
         }else{
             System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
         }
}
 }
 public void checkCellPhoneNumber(){
     while (true){
         System.out.println("Please enter your cell phone number, include international code, e.g, +27734664307: ");
         String cellPhone = scanner.nextLine();
         String regex = "^\\+27\\d{9}$";
         Pattern pattern = Pattern.compile(regex);
         Matcher matcher = pattern.matcher(cellPhone);
         
         if (matcher.matches()){
             cellPhoneNumber = cellPhone;
             System.out.println("Cell phone number successfully added");
             break;
         }else{
             System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
         }
     }
 }
 
  private boolean containsUpperCase(String str){
      for( char c: str.toCharArray()){
          if (Character.isUpperCase(c)){
              return true;
          }
      }
      return false;
  }
  
  private boolean containsDigit(String str){
      for (char c: str.toCharArray()){
          if ( Character.isDigit(c)){
              return true;
          }
      }
      return false;
  }
  
  private boolean containsSpecialCharacter(String str){
      for (char c: str.toCharArray()){
          if (!Character.isLetterOrDigit(c)){
              return true;
      }
  }
  return false;
}
  public void loginUser(){
      System.out.println("\nLogin to you account using the same username and password");
      System.out.println("----------------------------------------------------------------");

      while (true) {
      System.out.println("Enter your user name: ");
      String loginUserName = scanner.nextLine();
      
      System.out.println("Enter your password: ");
      String loginPassWord = scanner.nextLine();
       
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
    public static void main(String[] args) {
        Login user = new Login(); 
        user.checkUserName();
        user.checkPasswordComplexity();
        user.checkCellPhoneNumber();
        user.loginUser();
    }
}

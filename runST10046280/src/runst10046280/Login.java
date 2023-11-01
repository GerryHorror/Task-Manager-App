package runst10046280;

/*
Student Number: ST10046280
Name & Surname: Gérard Blankenberg
Module Code: PR0G5121
I declare that the assignment here submitted is original except for source material explicitly acknowledged in the reference list provided.
 */

import java.util.*;

public class Login {

    public Login() {
    }

    public boolean checkUserName(String userName) {
        //This method ensures that any username contains one under score (_) and is no more than 5 characters long.
        //It returns true if the username is valid and false if it is not.
        int underscoreCount = 0;
        for (int cnt = 0; cnt < userName.length(); cnt++) {
            if (userName.charAt(cnt) == '_') {
                underscoreCount++;
                if (underscoreCount > 1) {
                    return false;
                }
            }
        }
        return userName.length() <= 5 && underscoreCount == 1;
    }

    public boolean checkPasswordComplexity(String passWord) {
        //This method ensures that any password contains at least one uppercase letter, one lowercase letter, one number, and one special character.
        //It returns true if the password is valid and false if it is not.
        return passWord.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]\\{\\};':\"\\\\|,.<>\\/?]).{8,}$");
    }

    public String registerUser(String userName, String passWord, String firstName, String lastName) {
        //This method registers a user and returns a message indicating whether the registration was successful or not.
        //It returns a message indicating whether the registration was successful or not.
        if (checkUserName(userName) && checkPasswordComplexity(passWord)) {
            return "User registered successfully";
        } else {
            return "Registration unsuccessful";
        }
    }

    public boolean loginUser(String userName, String passWord, ArrayList<Account> accounts) {
        // This method logs in a user and returns true if the login was successful and false if it was not.
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getUserName().equals(userName) && account.getPassWord().equals(passWord)) {
                return true;
            }
        }
        return false;
    }


    public String returnLoginStatus(boolean loginSuccessful, String userName, String passWord, String firstName, String lastName, ArrayList<Account> accounts) {
        //This method returns a message indicating whether the login was successful or not.
        if (loginSuccessful) {
            return String.format("Welcome %s %s, it is great to see you again.", firstName, lastName);
        } else {
            return "Username or password is incorrect. Please try again.";
        }
    }

} // End of class
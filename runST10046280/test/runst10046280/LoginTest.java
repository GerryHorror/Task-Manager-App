package runst10046280;

/*
Student Number: ST10046280
Name & Surname: Gérard Blankenberg
Module Code: PR0G5121
I declare that the assignment here submitted is original except for source material explicitly acknowledged in the reference list provided.
 */

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class LoginTest {

    Login newLogin = new Login();

    public LoginTest() {
    }

    @Test
    public void testCheckUserName() {
        boolean expected = false;
        String userName = "_who_";
        boolean actual = newLogin.checkUserName(userName);
        assertEquals(expected, actual);
    }

    @Test
    public void testCheckPassWordComplexity() {
        boolean expected = false;
        String passWord = "password";
        boolean actual = newLogin.checkPasswordComplexity(passWord);
        assertEquals(expected, actual);
    }

    @Test
    public void testRegisterUser() {
        String expected = "User registered successfully";
        String actual = newLogin.registerUser("who_", "Pa$sw0rd", "Seth", "Rollins");
        assertEquals(expected, actual);
    }

    @Test
    public void testLoginUser() {
        boolean expected = false;
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(new Account("_who", "Pa$sw0rd", "Peter", "Jackson"));
        boolean actual = newLogin.loginUser("_who", "hcggc", accountList);
        assertEquals(expected, actual);
    }
}

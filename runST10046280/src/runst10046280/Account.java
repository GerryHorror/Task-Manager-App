package runst10046280;

/*
Student Number: ST10046280
Name & Surname: Gérard Blankenberg
Module Code: PR0G5121
I declare that the assignment here submitted is original except for source material explicitly acknowledged in the reference list provided.
 */

public class Account {
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;

    // Parameterless constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(String userName, String passWord, String firstName, String lastName) {
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}


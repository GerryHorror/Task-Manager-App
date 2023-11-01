package runst10046280;

/*
Student Number: ST10046280
Name & Surname: Gérard Blankenberg
Module Code: PR0G5121
I declare that the assignment here submitted is original except for source material explicitly acknowledged in the reference list provided.
 */

import javax.swing.*;
import java.util.ArrayList;

public class RunST10046280 {

    public static void main(String[] args) {
        // Declare variables
        String userName = "";
        String passWord = "";
        String firstName = "";
        String lastName = "";
        String[] taskStatus = {"To Do", "Doing", "Done"};
        String taskName = "";
        String taskDescription = "";
        String developerDetails = "";
        String taskDetails;
        String taskSummary;

        // Declare error messages
        String userNameError = "Username is not correctly formatted. Please ensure that your username contains one underscore"
                + "( _ ) and is no more than 5 characters in length.";
        String passWordError = "Password is not correctly formatted. Please ensure that your password contains at least 8 characters, "
                + "a capital letter, a number, and a special character.";
        String descriptionError = "Task description cannot be blank or exceed 50 characters. Please try again.";

        // Declare menu options
        int taskMenuChoice = 0;
        int continueOption = 0;
        int numberOfTasks = 0;
        int taskNumber;
        int numberOfTasksAdded = 0;
        int taskDuration = 0;
        int totalHours = 0;

        // Declare boolean variables
        boolean exitApp = false;
        boolean loginSuccessful = false;
        boolean validInput;
        boolean validNumberOfTasks = false;
        boolean validUserName = false;
        boolean validPassword = false;
        boolean validFirstName = false;
        boolean validLastName = false;
        boolean validTaskName = false;
        boolean validDescription = false;
        boolean validDevDetails = false;
        boolean validTaskDuration = false;

        // Create an ArrayList of Account objects.
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account("john_", "Pa$$w0rd", "John", "Doe"));
        accounts.add(new Account("jane_", "Pa$$w0rd2", "Jane", "Doe"));
        accounts.add(new Account("jim_", "Pa$$w0rd3", "Jim", "Doe"));
        accounts.add(new Account("jill_", "Pa$$w0rd4", "Jill", "Doe"));

        // Create an instance of the Login class.
        Login login = new Login();
        // Create an instance of the Task class.
        Task newTask = new Task();

        // Create an ArrayList of Task objects.
        ArrayList<Task> tasks = new ArrayList<Task>();

        // While loop to keep the application running until the user chooses to exit.
        while (!exitApp) {
            int userChoice = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban\nPlease select an option below:", "EasyKanban",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Login", "Register", "Exit"}, "Login");
            if (userChoice == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
            switch (userChoice) {
                case 0:
                    while (!loginSuccessful) {
                        // Set the default values for the username and password fields for testing purposes.
                        userName = JOptionPane.showInputDialog(null, "Please enter your username:", "Username", JOptionPane.QUESTION_MESSAGE, null, null, "john_").toString();
                        passWord = JOptionPane.showInputDialog(null, "Please enter your password:", "Password", JOptionPane.QUESTION_MESSAGE, null, null, "Pa$$w0rd").toString();
                        loginSuccessful = login.loginUser(userName, passWord, accounts);
                        if (loginSuccessful) {
                            for (int i = 0; i < accounts.size(); i++) {
                                Account account = accounts.get(i);
                                if (account.getUserName().equals(userName) && account.getPassWord().equals(passWord)) {
                                    firstName = account.getFirstName();
                                    lastName = account.getLastName();
                                }
                            }
                            JOptionPane.showMessageDialog(null, login.returnLoginStatus(loginSuccessful, userName, passWord, firstName, lastName, accounts), "Login Status", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, login.returnLoginStatus(loginSuccessful, userName, passWord, firstName, lastName, accounts), "Login Status", JOptionPane.ERROR_MESSAGE);
                        }
                    } // End of login while loop
                    while (loginSuccessful) {
                        // Display the main menu and ask the user to choose an option.
                        String menuSelection = "What would you like to do today?\n" + ""
                                + "1. Add a task\n"
                                + "2. Show Report Menu\n"
                                + "3. Quit";
                        validInput = false;
                        // While loop to ensure that the user enters a valid menu option.
                        while (!validInput) {
                            try {
                                taskMenuChoice = Integer.parseInt(JOptionPane.showInputDialog(null, menuSelection, "Menu", JOptionPane.QUESTION_MESSAGE));
                                if (taskMenuChoice < 1 || taskMenuChoice > 3) {
                                    JOptionPane.showMessageDialog(null, "Please enter a valid menu option.", "Error", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    validInput = true;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid menu option.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        switch (taskMenuChoice) {
                            case 1:
                                validNumberOfTasks = false;
                                while (!validNumberOfTasks) {
                                    try {
                                        numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "How many tasks would you like to add?", "Number of Tasks", JOptionPane.QUESTION_MESSAGE));
                                        if (numberOfTasks < 1) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid number of tasks.", "Error", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            validNumberOfTasks = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Please enter a valid number of tasks.", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                for (int i = 0; i < numberOfTasks; i++) {
                                    taskNumber = numberOfTasksAdded + 1;
                                    numberOfTasksAdded++;
                                    validTaskName = false;
                                    while (!validTaskName) {
                                        taskName = JOptionPane.showInputDialog(null, "Please enter the name of the task " + taskNumber, "Task Name", JOptionPane.QUESTION_MESSAGE);
                                        if (taskName.trim().equals("")) {
                                            JOptionPane.showMessageDialog(null, "Task name cannot be blank. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            validTaskName = true;
                                        }
                                    }
                                    validDescription = false;
                                    while (!validDescription) {
                                        taskDescription = JOptionPane.showInputDialog(null, "Please enter the description of task " + numberOfTasksAdded, "Task Description", JOptionPane.QUESTION_MESSAGE);
                                        // An additional check to ensure that the task description is not blank.
                                        if (taskDescription != null && !taskDescription.isEmpty() && newTask.checkTaskDescription(taskDescription)) {
                                            validDescription = true;
                                        } else {
                                            JOptionPane.showMessageDialog(null, descriptionError, "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    validDevDetails = false;
                                    while (!validDevDetails) {
                                        developerDetails = JOptionPane.showInputDialog(null, "Please enter the developer details of task " + numberOfTasksAdded, "Developer Details", JOptionPane.QUESTION_MESSAGE);
                                        if (developerDetails.trim().equals("")) {
                                            JOptionPane.showMessageDialog(null, "Developer details cannot be blank. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            validDevDetails = true;
                                        }
                                    }
                                    // While loop to ensure that the user enters a valid task duration.
                                    validTaskDuration = false;
                                    while (!validTaskDuration) {
                                        try {
                                            taskDuration = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the duration of task " + numberOfTasksAdded, "Task Duration", JOptionPane.QUESTION_MESSAGE));
                                            if (taskDuration >= 1) {
                                                validTaskDuration = true;
                                            } else {
                                                JOptionPane.showMessageDialog(null, "The task duration cannot be less than 1. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "Please enter a valid task duration.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                    // Display a drop-down menu to allow the user to select the task status.
                                    String taskStatusSelection = (String) JOptionPane.showInputDialog(null, "Please select the status of task " + numberOfTasksAdded,
                                            "Task Status", JOptionPane.QUESTION_MESSAGE, null, taskStatus, taskStatus[0]);
                                    if (taskStatusSelection != null) {
                                        switch (taskStatusSelection) {
                                            case "To Do":
                                                JOptionPane.showMessageDialog(null, "Task status set to To Do.", "Task Status", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            case "Done":
                                                JOptionPane.showMessageDialog(null, "Task status set to Done.", "Task Status", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            case "Doing":
                                                JOptionPane.showMessageDialog(null, "Task status set to Doing.", "Task Status", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            default:
                                                JOptionPane.showMessageDialog(null, "Please select a valid task status", "Error", JOptionPane.ERROR_MESSAGE);
                                                break;
                                        }
                                    }
                                    newTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatusSelection, taskNumber);
                                    totalHours += newTask.getTaskDuration();
                                    tasks.add(newTask);
                                    JOptionPane.showMessageDialog(null, "Task Number: " + newTask.getTaskNumber() + " added successfully", "Task Added", JOptionPane.INFORMATION_MESSAGE);
                                }
                                taskDetails = "Task Details\n";
                                for (int cnt = 0; cnt < tasks.size(); cnt++) {
                                    taskDetails += tasks.get(cnt).toString() + "\n";
                                }
                                taskSummary = taskDetails + "\nTotal hours: " + totalHours;
                                // Display the task details to the user. This includes the task name, description, developer details, duration and status.
                                JOptionPane.showMessageDialog(null, taskSummary, "Task Summary", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case 2:
                                // Display a drop-down menu to allow the user to select the report option.
                                boolean backToMainMenu = false;
                                while (!backToMainMenu) {
                                    String[] reportOptions = {"Display All Tasks", "Display Completed Tasks", "Display Longest Task", "Search Task Name", "Search Developer Tasks", "Delete Task", "Back to Main Menu"};
                                    String selectedOption = (String) JOptionPane.showInputDialog(null, "Please select an option:", "Report Menu",
                                            JOptionPane.QUESTION_MESSAGE, null, reportOptions, null);
                                    if (selectedOption != null) {
                                        switch (selectedOption) {
                                            // Display all the tasks that have been captured.
                                            case "Display All Tasks":
                                                if (tasks.isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "No tasks have been captured yet.", "Error", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    String allTasks = "Task Details\n";
                                                    for (int cnt = 0; cnt < tasks.size(); cnt++) {
                                                        allTasks += tasks.get(cnt).toString() + "\n";
                                                    }
                                                    JOptionPane.showMessageDialog(null, allTasks, "All Tasks", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                                break;
                                            // Display all the tasks that have been marked as Done.
                                            case "Display Completed Tasks":
                                                String doneTasks = newTask.displayDoneTasks("Done", tasks);
                                                JOptionPane.showMessageDialog(null, doneTasks, "Completed Tasks", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            // Display the task with the longest duration.
                                            case "Display Longest Task":
                                                String longestTask = newTask.displayLongestTask(taskDuration, tasks);
                                                JOptionPane.showMessageDialog(null, longestTask, "Longest Task", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            // Search for a task by name.
                                            case "Search Task Name":
                                                // Check if there are any tasks captured.
                                                if (tasks.isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "No tasks have been captured yet.", "Error", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    // Create a drop-down menu with the task names.
                                                    String[] searchTaskList = new String[tasks.size()];
                                                    for (int cnt = 0; cnt < tasks.size(); cnt++) {
                                                        searchTaskList[cnt] = tasks.get(cnt).getTaskName();
                                                    }
                                                    // Display the drop-down menu to the user and allow them to select a task name.
                                                    JComboBox<String> taskNameBox = new JComboBox<>(searchTaskList);
                                                    // Set the default value of the drop-down menu to the first task name in the list.
                                                    String taskNameSearch = null;
                                                    int searchTask = JOptionPane.showConfirmDialog(null, taskNameBox, "Please select the task you wish to search for:", JOptionPane.OK_CANCEL_OPTION);
                                                    if (searchTask == JOptionPane.OK_OPTION) {
                                                        taskNameSearch = (String) taskNameBox.getSelectedItem();
                                                    }
                                                    String searchResult = newTask.searchTask(taskNameSearch, tasks);
                                                    if (searchResult.equals("")) {
                                                        JOptionPane.showMessageDialog(null, "No tasks have been captured.", "Search Result", JOptionPane.INFORMATION_MESSAGE);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, searchResult, "Search Result", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                                break;
                                            // Search for a task by developer name.
                                            case "Search Developer Tasks":
                                                // Create an array of developer names to avoid duplicates.
                                                if (tasks.isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "No tasks have been captured yet.", "Error", JOptionPane.ERROR_MESSAGE);
                                                } else {
                                                    ArrayList<String> developerNames = new ArrayList<>();
                                                    for (int cnt = 0; cnt < tasks.size(); cnt++) {
                                                        String developer = tasks.get(cnt).getDeveloperDetails();
                                                        if (!developerNames.contains(developer)) {
                                                            developerNames.add(developer);
                                                        }
                                                    }
                                                    String[] developerNamesArray = developerNames.toArray(new String[0]);
                                                    JComboBox<String> developerNameList = new JComboBox<>(developerNamesArray);
                                                    String developerName = null;
                                                    int searchDeveloper = JOptionPane.showConfirmDialog(null, developerNameList, "Please select the developer you wish to search for:", JOptionPane.OK_CANCEL_OPTION);
                                                    if (searchDeveloper == JOptionPane.OK_OPTION) {
                                                        developerName = (String) developerNameList.getSelectedItem();
                                                    }
                                                    String developerTasks = newTask.searchDeveloper(developerName, tasks);
                                                    if (developerTasks.equals("")) {
                                                        JOptionPane.showMessageDialog(null, "No tasks have been captured.", "Developer Tasks", JOptionPane.INFORMATION_MESSAGE);
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, developerTasks, "Developer Tasks", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                                break;
                                            // Delete a task.
                                            case "Delete Task":
                                                // Check if the tasks ArrayList is empty
                                                if (tasks.isEmpty()) {
                                                    JOptionPane.showMessageDialog(null, "No tasks have been captured.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                                                } else {
                                                    // Create an array to store task names
                                                    String[] taskNames = new String[tasks.size()];

                                                    // Populate the task names array
                                                    for (int cnt = 0; cnt < tasks.size(); cnt++) {
                                                        taskNames[cnt] = tasks.get(cnt).getTaskName();
                                                    }

                                                    // Create a JComboBox with the task names array
                                                    JComboBox<String> taskNameList = new JComboBox<>(taskNames);

                                                    // Display the dropdown menu
                                                    int deleteTask = JOptionPane.showConfirmDialog(null, taskNameList, "Please select the task you wish to delete:", JOptionPane.OK_CANCEL_OPTION);

                                                    if (deleteTask == JOptionPane.OK_OPTION) {
                                                        String selectedTask = (String) taskNameList.getSelectedItem();
                                                        newTask.deleteTask(selectedTask, tasks);
                                                        JOptionPane.showMessageDialog(null, "The task has been deleted.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                                                    } else if (deleteTask == JOptionPane.CANCEL_OPTION) {
                                                        JOptionPane.showMessageDialog(null, "No task has been deleted.", "Delete Task", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                                break;
                                            // Return to the main menu.
                                            case "Back to Main Menu":
                                                backToMainMenu = true;
                                                break;
                                        }
                                    }
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban. Goodbye.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                                System.exit(0);
                        }
                    } // End of loginSuccessful while loop
                    break;
                // Register
                case 1:
                    // While loop to ensure that the user enters valid username.
                    while (!validUserName) {
                        userName = JOptionPane.showInputDialog(null, "Please enter a username:", "Username", JOptionPane.QUESTION_MESSAGE);
                        if (login.checkUserName(userName)) {
                            validUserName = true;
                        } else {
                            JOptionPane.showMessageDialog(null, userNameError, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    // While loop to ensure that the user enters valid password.
                    while (!validPassword) {
                        passWord = JOptionPane.showInputDialog(null, "Please enter a password:", "Password", JOptionPane.QUESTION_MESSAGE);
                        if (login.checkPasswordComplexity(passWord)) {
                            validPassword = true;
                        } else {
                            JOptionPane.showMessageDialog(null, passWordError, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    // While loop to ensure that the user enters valid first name.
                    while (!validFirstName) {
                        firstName = JOptionPane.showInputDialog(null, "Please enter your first name:", "First Name", JOptionPane.QUESTION_MESSAGE);
                        if (firstName.trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid first name.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            validFirstName = true;
                        }
                    }
                    // While loop to ensure that the user enters valid last name.
                    while (!validLastName) {
                        lastName = JOptionPane.showInputDialog(null, "Please enter your last name:", "Last Name", JOptionPane.QUESTION_MESSAGE);
                        if (lastName.trim().equals("")) {
                            JOptionPane.showMessageDialog(null, "Please enter a valid last name.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            validLastName = true;
                        }
                    }
                    // Add the new account to the accounts ArrayList.
                    accounts.add(new Account(userName, passWord, firstName, lastName));
                    JOptionPane.showMessageDialog(null, login.registerUser(userName, passWord, firstName, lastName), "Registration Status", JOptionPane.INFORMATION_MESSAGE);
                    continueOption = JOptionPane.showOptionDialog(null, "Would you like to continue?", "Continue", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, "Yes");
                    if (continueOption == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban. Goodbye.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        exitApp = true;
                    }
                    break;
                // Exit
                case 2:
                    JOptionPane.showMessageDialog(null, "Thank you for using EasyKanban. Goodbye.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    exitApp = true;
                    break;
            } // End of userChoice switch statement
        } // End of exitApp while loop
    } // End of main method

} // End of class

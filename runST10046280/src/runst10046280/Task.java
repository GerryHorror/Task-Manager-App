package runst10046280;

import java.util.*;

/*
Student Number: ST10046280
Name & Surname: Gérard Blankenberg
Module Code: PR0G5121
I declare that the assignment here submitted is original except for source material explicitly acknowledged in the reference list provided.
 */
public class Task {

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private String taskStatus;
    private int taskDuration;
    private int taskNumber;

    // Parameterless constructor
    public Task() {
    }

    // Parameterised constructor
    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, String taskStatus, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskNumber;
    }

    //This method ensures that any task description is no more than 50 characters long.
    public boolean checkTaskDescription(String taskDescription) {
        return taskDescription.length() <= 50;
    }

    //This method creates a task ID using the first two letters of the task name, the task number, and the last three letters of the developer's name.
    public String createTaskID() {
        String developerName = developerDetails.split(" ")[0].substring(developerDetails.split(" ")[0].length() - 3).toUpperCase();
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerName;
    }

    // This method is used to display the details of a task object.
    @Override
    public String toString() {
        return String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nTask Duration: %d\n",
                taskStatus, developerDetails, taskNumber, taskName, taskDescription, createTaskID(), taskDuration);
    }

    // This method displays the Developer, Task Names and Task Duration for all tasks with the status of Done by checking the Array.
    public String displayDoneTasks(String taskStatus, ArrayList<Task> tasks) {
        String doneTasks = "";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskStatus().equals(taskStatus)) {
                doneTasks += String.format("Developer Details: %s\nTask Name: %s\nTask Duration: %d\n\n", task.getDeveloperDetails(), task.getTaskName(), task.getTaskDuration());
            }
        }
        if (doneTasks.equals("")) {
            doneTasks = "There are no completed tasks.";
        }
        return doneTasks;
    }

    // This method displays the Developer and Duration of the class with the longest duration in the Array.
    public String displayLongestTask(int taskDuration, ArrayList<Task> tasks) {
        int longestTaskDuration = 0;
        String longestTask = "";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskDuration() > longestTaskDuration) {
                longestTaskDuration = task.getTaskDuration();
                longestTask = String.format("Developer Details: %s\nTask Duration: %d\n", task.getDeveloperDetails(), task.getTaskDuration());
            }
        }
        if (longestTask.equals("")) {
            longestTask = "There are no tasks captured.";
        }
        return longestTask;
    }

    // This method allows the user to search for a task by task name and display the Task Name, Developer and Task Status in the Array.
    public String searchTask(String taskName, ArrayList<Task> tasks) {
        String searchTask = "";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskName().equals(taskName)) {
                searchTask += String.format("Task Name: %s\nDeveloper Details: %s\nTask Status: %s\n", task.getTaskName(), task.getDeveloperDetails(), task.getTaskStatus());
            }
        }
        if (searchTask.equals("")) {
            searchTask = "No task with that name has been captured yet.";
        }
        return searchTask;
    }

    // This method searches for all tasks assigned to a developer and display the Task Name and Task Status in the Array.
    public String searchDeveloper(String developerDetails, ArrayList<Task> tasks) {
        String searchDeveloper = "";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getDeveloperDetails().equals(developerDetails)) {
                searchDeveloper += String.format("Task Name: %s\nTask Status: %s\n\n", task.getTaskName(), task.getTaskStatus());
            }
        }
        return searchDeveloper;
    }

    // This method deletes a task from the Array by task name.
    public void deleteTask(String taskName, ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskName().equals(taskName)) {
                tasks.remove(i);
            }
        }
    }

    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

} // End of class

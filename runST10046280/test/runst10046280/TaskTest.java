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

public class TaskTest {

    Task newTask = new Task();
    ArrayList<Task> tasks = new ArrayList<>();

    public TaskTest() {
    }

    @Test
    public void testCheckTaskDescription() {
        boolean expected = true;
        String taskDescription = "Test Task Description";
        boolean actual = newTask.checkTaskDescription(taskDescription);
        assertEquals(expected, actual);
        
        boolean expected2 = false;
        String taskDescription2 = "This is a test task description that is longer than 50 characters.";
        boolean actual2 = newTask.checkTaskDescription(taskDescription2);
        assertEquals(expected2, actual2);
        
        boolean expected3 = true;
        String taskDescription3 = "This is a test task description that is 50 chars";
        boolean actual3 = newTask.checkTaskDescription(taskDescription3);
        assertEquals(expected3, actual3);

    }

    @Test
    public void testCreateTaskID() {
        String expected = "TE:1:IKE";
        newTask.setTaskName("Test Task");
        newTask.setTaskNumber(1);
        newTask.setDeveloperDetails("Mike Smith");
        String actual = newTask.createTaskID();
        assertEquals(expected, actual);
        
        String expected2 = "TE:2:VEY";
        newTask.setTaskName("Test Task 2");
        newTask.setTaskNumber(2);
        newTask.setDeveloperDetails("Davey Jones");
        String actual2 = newTask.createTaskID();
        assertEquals(expected2, actual2);

    }
    @Test
    public void toStringTest() {
        String expected = String.format("Task Status: %s\nDeveloper Details: %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nTask Duration: %d\n", 
                "Doing", "Mike Smith", 1, "Test Task", "Test Task Description", "TE:1:IKE", 10);
        newTask.setTaskStatus("Doing");
        newTask.setDeveloperDetails("Mike Smith");
        newTask.setTaskNumber(1);
        newTask.setTaskName("Test Task");
        newTask.setTaskDescription("Test Task Description");
        newTask.createTaskID();
        newTask.setTaskDuration(10);
        String actual = newTask.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testDisplayDoneTasks() {
        String expected = "Developer Details: Mike Smith\nTask Name: Test Task\nTask Duration: 10\n\n";
        newTask.setTaskStatus("Done");
        newTask.setDeveloperDetails("Mike Smith");
        newTask.setTaskName("Test Task");
        newTask.setTaskDuration(10);
        tasks.add(newTask);
        String actual = newTask.displayDoneTasks("Done", tasks);
        assertEquals(expected, actual);
    }

    @Test
    public void testDisplayLongestTask() {
        Task task1 = new Task();
        task1.setTaskStatus("Doing");
        task1.setDeveloperDetails("Adam Johnson");
        task1.setTaskName("Task 1");
        task1.setTaskDuration(10);
        tasks.add(task1);

        Task task2 = new Task();
        task2.setTaskStatus("Doing");
        task2.setDeveloperDetails("Mike Smith");
        task2.setTaskName("Task 2");
        task2.setTaskDuration(20);
        tasks.add(task2);

        Task task3 = new Task();
        task3.setTaskStatus("Doing");
        task3.setDeveloperDetails("Davey Jones");
        task3.setTaskName("Task 3");
        task3.setTaskDuration(30);
        tasks.add(task3);

        String expected = "Developer Details: Davey Jones\nTask Duration: 30\n";
        String actual = newTask.displayLongestTask(newTask.getTaskDuration(), tasks);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchTask() {
        Task task1 = new Task();
        task1.setTaskStatus("Doing");
        task1.setDeveloperDetails("Adam Johnson");
        task1.setTaskName("Task 1");
        tasks.add(task1);

        Task task2 = new Task();
        task2.setTaskStatus("Done");
        task2.setDeveloperDetails("Mike Smith");
        task2.setTaskName("Task 2");
        tasks.add(task2);

        Task task3 = new Task();
        task3.setTaskStatus("Doing");
        task3.setDeveloperDetails("Davey Jones");
        task3.setTaskName("Task 3");
        tasks.add(task3);

        String searchTaskName = "Task 2";
        String expected = "Task Name: Task 2\nDeveloper Details: Mike Smith\nTask Status: Done\n";
        String actual = newTask.searchTask(searchTaskName, tasks);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchDeveloper() {
        Task task1 = new Task();
        task1.setTaskStatus("Doing");
        task1.setDeveloperDetails("Adam Johnson");
        task1.setTaskName("Task 1");
        tasks.add(task1);

        Task task2 = new Task();
        task2.setTaskStatus("Done");
        task2.setDeveloperDetails("Mike Smith");
        task2.setTaskName("Task 2");
        tasks.add(task2);

        Task task3 = new Task();
        task3.setTaskStatus("Doing");
        task3.setDeveloperDetails("Davey Jones");
        task3.setTaskName("Task 3");
        tasks.add(task3);

        String searchDeveloperDetails = "Mike Smith";
        String expected = "Task Name: Task 2\nTask Status: Done\n\n";
        String actual = newTask.searchDeveloper(searchDeveloperDetails, tasks);
        assertEquals(expected, actual);
    }

    @Test
    public void testDeleteTask() {
        Task task1 = new Task();
        task1.setTaskStatus("Doing");
        task1.setDeveloperDetails("Adam Johnson");
        task1.setTaskName("Task 1");
        tasks.add(task1);

        Task task2 = new Task();
        task2.setTaskStatus("Done");
        task2.setDeveloperDetails("Mike Smith");
        task2.setTaskName("Task 2");
        tasks.add(task2);

        Task task3 = new Task();
        task3.setTaskStatus("Doing");
        task3.setDeveloperDetails("Davey Jones");
        task3.setTaskName("Task 3");
        tasks.add(task3);

        String deleteTaskName = "Task 2";
        newTask.deleteTask(deleteTaskName, tasks);

        boolean taskExists = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskName().equals(deleteTaskName)) {
                taskExists = true;
                break;
            }
        }
        assertFalse(taskExists);
    }

}

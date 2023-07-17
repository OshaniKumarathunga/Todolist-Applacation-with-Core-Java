import java.util.Date;
import java.util.Scanner;

public class MorningRoutine {

    public static void main(String[] args) {
        Todolist todo = new Todolist("My Morning Routine");
        Scanner sc = new Scanner(System.in);

        todo.createTask();
        //System.out.println("type a tast to make complete");
        String taskName = "Task 1";
        String employeeName = "John Doe";
        boolean taskAssigned = todo.assignTask(taskName, employeeName);

        if (taskAssigned) {
            System.out.println("Task assigned successfully.");
        } else {
            System.out.println("Task not found. Assignment failed.");
        }

        // Assign the deadline
        Date deadline = new Date(); // Replace this with the desired deadline date
        boolean deadlineAssigned = todo.assignDeadLine(taskName, deadline);

        if (deadlineAssigned) {
            System.out.println("Deadline assigned successfully.");
        } else {
            System.out.println("Task not found. Deadline assignment failed.");
        }


        // Remove the task
        boolean taskRemoved = todo.removeTask(taskName);

        if (taskRemoved) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found. Removal failed.");
        }

        // Rename the task
        String newTask = "Updated Task";
        boolean taskRenamed = todo.rename(taskName, newTask);

        if (taskRenamed) {
            System.out.println("Task renamed successfully.");
        } else {
            System.out.println("Task not found. Rename failed.");
        }

        // Mark the task as done
        boolean taskMarked = todo.markAsDone(taskName);

        if (taskMarked) {
            System.out.println("Task marked as done successfully.");
        } else {
            System.out.println("Task not found. Marking as done failed.");
        }
        todo.displayTask();
    }
}

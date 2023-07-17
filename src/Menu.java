import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {

    // ToDoList object
    private static List<Todolist> topicTodoList = new ArrayList<>();
    //declare  ToDoList topic
    private static Todolist currentTopic;

    public static void main(String[] args) {
        //The run function will start the menu on the output screen
        run();
    }

    private static void run() {

        boolean quit = false;
        String mainMenu = "" + "  1. Add a topic\n" +
                "  2. Select a topic\n" +
                "  3. Assign Task\n" +
                "  4. Assign deadline\n" +
                "  5. Create a task \n" +
                "  6. Mark as done\n" +
                "  7. Remove task \n" +
                "  8. Rename task\n" +
                "  9. Display\n\n" +
                "  10. Quit\n\n";

        while (!quit) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n Select your Choice to do: ");
            System.out.println(mainMenu);
            int choice = input.nextInt();

            //each case, will run the function
            switch (choice) {
                case 1:
                    addTopic();
                    break;
                case 2:
                    selectTopic();
                    break;
                case 3:
                    assignTask();
                    break;
                case 4:
                    assignDeadline();
                    break;
                case 5:
                    creatTask();
                    break;
                case 6:
                    markAsDone();
                    break;
                case 7:
                    removeTask();
                    break;
                case 8:
                    renameTask();
                    break;
                case 9:
                    displayTask();
                    break;
                default:
                    System.out.println("Invalid entry try again");
            }
        }
        System.exit(0);

    }

    private static void addTopic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter topic name");
        String topicName = sc.nextLine();

        for ( Todolist topic : topicTodoList) {
            if (topic.getTopic().equals(topicName)) {
                System.out.println("Topic already exists. Try again");
                return;
            }
        }
        topicTodoList.add(new Todolist(topicName));
        System.out.println("Topic added successfully");
    }

    private static void selectTopic(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter topic name");
        String topicName = sc.nextLine();

        for ( Todolist topic : topicTodoList) {
            if (topic.getTopic().equals(topicName)) {
                currentTopic = topic;
                System.out.println("Topic selected " + topicName);
                return;
            }
        }
        System.out.println("Topic was not found.Please create the topic first");
    }

    private static void assignTask(){
        if (currentTopic == null){
            System.out.println("No topic selected. Please select a topic first.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task:");
        String taskName = sc.nextLine();
        System.out.println("Please enter the Employee Name:");
        String employeeName = sc.nextLine();

        boolean taskAssigned = currentTopic.assignTask(taskName ,employeeName );
        if (taskAssigned) {
            System.out.println("Task assigned successfully.");
        } else {
            System.out.println("Task not found. Assignment failed.");
        }
    }

    private static void assignDeadline(){
        if (currentTopic == null){
            System.out.println("No topic selected. Please select a topic first.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task:");
        String taskName = sc.nextLine();
        System.out.println("Please enter the Due date (dd/MM/yyyy):");
        String dueDateString = sc.nextLine();

        Date dueDate = null;
        try {
            dueDate = new SimpleDateFormat("dd/MM/yyyy").parse(dueDateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Assignment failed.");
            return;
        }

        boolean taskAssigned = currentTopic.assignTask(taskName ,dueDateString );
        if (taskAssigned) {
            System.out.println("Task assigned successfully.");
        } else {
            System.out.println("Task not found. Assignment failed.");
        }
    }

    private static void creatTask(){
        if (currentTopic == null){
            System.out.println("No topic selected. Please select a topic first.");
            return;
        }

        currentTopic.createTask();
    }

    private static void markAsDone(){
        if (currentTopic == null){
            System.out.println("No topic selected. Please select a topic first.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task:");
        String taskName = sc.nextLine();
        boolean taskMarked = currentTopic.markAsDone(taskName);
        if (taskMarked) {
            System.out.println("Task marked as done successfully.");
        } else {
            System.out.println("Task not found. Marking as done failed.");
        }
    }

    private static void removeTask(){
        if (currentTopic == null){
            System.out.println("No topic selected. Please select a topic first.");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task:");
        String taskName = sc.nextLine();

        boolean taskRemoved = currentTopic.removeTask(taskName);
        if (taskRemoved) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task not found. Removal failed.");
        }

    }

    private static void renameTask(){
        if (currentTopic == null) {
            System.out.println("No topic selected. Please select a topic first.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter old task name");
        String oldTaskName = sc.nextLine();
        System.out.println("Please enter new task name");
        String newTaskName = sc.nextLine();

        boolean taskRenamed = currentTopic.rename(oldTaskName, newTaskName);
        if (taskRenamed) {
            System.out.println("Task renamed successfully.");
        } else {
            System.out.println("Task not found. Rename failed.");
        }
    }

    private static void displayTask(){ if (currentTopic == null) {
        System.out.println("No topic selected. Please select a topic first.");
        return;
    }

        currentTopic.displayTask();
    }
}

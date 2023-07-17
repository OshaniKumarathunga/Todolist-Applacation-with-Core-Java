import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Todolist {
    private String topic;
    List<Task> tasks = new ArrayList<>();

    public Todolist(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name");
        String name = sc.nextLine();
        System.out.println("Please enter employee name");
        String empname = sc.nextLine();
        System.out.println("Please enter due date");
        System.out.println("Please enter your date in the format dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        Date d = null;
        try {
            d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Task t = new Task();
        t.setName(name);
        t.setDeadLine(d);
        t.setEmployee(empname);
        tasks.add(t);
        System.out.println("Task added successfully.");

    }
    public boolean assignTask(String taskName , String employee){
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                task.setEmployee(employee);
                return true; // Task found and assigned successfully
            }
        }
        return false; // Task not found

    }

    public boolean assignDeadLine(String taskName , Date deadline ){
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                task.setDeadLine(deadline);
                return true; // Task found and deadline assigned successfully
            }
        }
        return false; // Task not found
    }

    public boolean removeTask(String taskName){
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                tasks.remove(task);
                System.out.println("Remove " + taskName + ".");
                return true; // Task found and removed successfully
            }
        }
        return false; // Task not found
    }

    public void displayTask(){
        if (tasks.size() == 0){
            System.out.println("Our Todo List for " + topic + "is currently empty");
        }else {
            System.out.println("Here is our Todo List for " + topic);
            if (tasks.isEmpty()) {
                System.out.println("No tasks found.");
            } else {
                System.out.println("Tasks in " + topic + ":");

                for (Task task : tasks) {
                    System.out.println(task.toString());
                }
            }
        }
    }

    public boolean rename(String oldTask, String newTask) {
        for (Task task : tasks) {
            if (task.getName().equals(oldTask)) {
                task.setName(newTask);
                return true; // Task found and renamed successfully
            }
        }
        return false; // Task not found
    }

    public boolean markAsDone(String taskName){
        for (Task task : tasks){
            if (task.getName().equals(taskName)){
                task.setDone(true);
                System.out.println("Marking " +taskName+ " as completed");
                return true;
            }
        }
        return false;
    }


}

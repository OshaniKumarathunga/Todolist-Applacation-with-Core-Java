import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Todolist {
    private String topic;
    private HashMap<String , Boolean> tasks;

    public Todolist(String topic) {
        this.topic = topic;
        this.tasks = new HashMap<String , Boolean>();
    }

    public void addTask(String taskName){
        this.tasks.put(taskName , false);
    }

    public void removeTask(String taskName){
//        try {
//            this.tasks.remove(taskNumber);
//        }catch (IndexOutOfBoundsException e){
//            System.out.println("Could not remove task, no task at this index!");
//        }
        if (this.tasks.containsKey(taskName)){
            System.out.println("Removing " + taskName);
            this.tasks.remove(taskName);
        }else {
            System.out.println("No such a task");
        }
    }

    public void displayTask(){
        if (tasks.size() == 0){
            System.out.println("Our Todo List for " + topic + "is currently empty");
        }else {
            System.out.println("Here is our Todo List for " + topic);
            for(Map.Entry<String, Boolean> task : this.tasks.entrySet()) {
                if (task.getValue()) {
                    System.out.println("Task " + task.getKey() + " is complete");
                }else {
                    System.out.println("Task " + task.getKey() + " is not done");
                }
            }
        }
    }

    public void rename(String oldTask, String newTask) {
//        try {
//            this.tasks.set(i,newTask);
//        }
//        catch (IndexOutOfBoundsException e) {
//            System.out.println("Could not rename task, no task at this index!");
//        }
        System.out.println("Renaming " + oldTask + " to " + newTask);
        if (this.tasks.containsKey(oldTask)){
            this.tasks.put(newTask , this.tasks.get(oldTask));
            this.tasks.remove(oldTask);
        }else {
            System.out.println("No such a task!");
        }
    }

    public void markAsDone(String taskName){
        System.out.println("Marking " +taskName+ " as completed");
        if (this.tasks.containsKey(taskName)){
            this.tasks.put(taskName , true);
        }else {
            System.out.println("No such a task!");
        }
    }

}

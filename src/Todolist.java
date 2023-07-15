import java.util.ArrayList;

public class Todolist {
    private String topic;
    private ArrayList<String> tasks;

    public Todolist(String topic) {
        this.topic = topic;
        this.tasks = new ArrayList<String>();
    }

    public void addTask(String taskName){
        this.tasks.add(taskName);
    }

    public void removeTask(int taskNumber){
        try {
            this.tasks.remove(taskNumber);
        }catch (IndexOutOfBoundsException e){
            System.out.println("Could not remove task, no task at this index!");
        }
    }

    public void displayTask(){
        if (tasks.size() == 0){
            System.out.println("Our Todo List for " + topic + "is currently empty");
        }else {
            System.out.println("Here is Todo List for " + topic);
            for (int i=0; tasks.size() >= i; i++){
                System.out.println("Task " + i + " is " + this.tasks.get(i));
            }
        }
    }

    public void rename(int i, String newTask) {
        try {
            this.tasks.set(i,newTask);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Could not rename task, no task at this index!");
        }
    }

}

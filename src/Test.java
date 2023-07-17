import java.util.Date;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
        // method that runs all the tests implement
        t.testAll();
    }

    private void testAll() {
        testCreateTask();
        testAssignTask();
        testAssignDeadline();
        testMarkAsDone();
        testRemoveTask();
        testRenameTask();
        testDisplayTasks();
    }

    private void testCreateTask() {
        Todolist todolist = new Todolist("Example Topic");
        todolist.createTask();

        List<Task> tasks = todolist.getTasks();
        if (tasks.size() == 1) {
            System.out.println("Create Task test is success!!");
        } else {
            System.out.println("Create Task test is fail!!");
        }
    }

    private void testAssignTask() {
        Todolist todoList = new Todolist("Example Topic");
        todoList.createTask();
        todoList.assignTask("Task 1", "John Doe");

        List<Task> tasks = todoList.getTasks();
        Task task = tasks.get(0);
        if (task.getEmployee().equals("John Doe")) {
            System.out.println("Assign Task test is successful!");
        } else {
            System.out.println("Assign Task test failed!");
        }
    }

    private void testAssignDeadline() {
        Todolist todoList = new Todolist("Example Topic");
        todoList.createTask();
        Date deadline = new Date();
        todoList.assignDeadLine("Task 1", deadline);

        List<Task> tasks = todoList.getTasks();
        Task task = tasks.get(0);
        if (task.getDeadLine().equals(deadline)) {
            System.out.println("Assign Deadline test is successful!");
        } else {
            System.out.println("Assign Deadline test failed!");
        }
    }

    private void testMarkAsDone() {
        Todolist todoList = new Todolist("Example Topic");
        todoList.createTask();
        todoList.markAsDone("Task 1");

        List<Task> tasks = todoList.getTasks();
        Task task = tasks.get(0);
        if (task.isDone()) {
            System.out.println("Mark As Done test is successful!");
        } else {
            System.out.println("Mark As Done test failed!");
        }
    }

    private void testRemoveTask() {
        Todolist todoList = new Todolist("Example Topic");
        todoList.createTask();
        todoList.removeTask("Task 1");

        List<Task> tasks = todoList.getTasks();
        if (tasks.isEmpty()) {
            System.out.println("Remove Task test is successful!");
        } else {
            System.out.println("Remove Task test failed!");
        }
    }

    private void testRenameTask() {
        Todolist todoList = new Todolist("Example Topic");
        todoList.createTask();
        todoList.rename("Task 1", "Updated Task");

        List<Task> tasks = todoList.getTasks();
        Task task = tasks.get(0);
        if (task.getName().equals("Updated Task")) {
            System.out.println("Rename Task test is successful!");
        } else {
            System.out.println("Rename Task test failed!");
        }
    }

    private void testDisplayTasks() {
        Todolist todoList = new Todolist("Example Topic");
        todoList.createTask();
        todoList.createTask();
        todoList.createTask();
        todoList.displayTask();

        System.out.println("Display Tasks test completed!");
    }


}

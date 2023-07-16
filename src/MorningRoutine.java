public class MorningRoutine {

    public static void main(String[] args) {
        Todolist todo = new Todolist("My Morning Routine");

        todo.addTask("Wake Up");
        todo.addTask("Shower");
        todo.addTask("Have Breakfast");
        todo.displayTask();
//        todo.removeTask(2);
//        todo.displayTask();
        todo.addTask("Do programming");
        todo.markAsDone("Wake Up");
        todo.displayTask();
        todo.rename("Shower", "Take bath");
        todo.rename("Have Breakfast", "Go for a run");
        todo.displayTask();

    }
}

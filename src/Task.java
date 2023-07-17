import java.util.Date;

public class Task {
    private String name;
    private Date deadLine;
    private String employee;
    private boolean isDone;

    @Override
    public String toString() {
        return "Task name = " + name + " , " +
                "employee = " + employee + " , " +
                "deadline = " + deadLine + ", " +
                "Done = " + isDone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadline) {
        this.deadLine = deadline;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

}

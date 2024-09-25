import java.time.LocalDate;

public class Task {
    private String title;
    private boolean isCompleted;
    private LocalDate dueDate;

    public Task(String title, LocalDate dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void completeTask() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task: " + title + " | Due: " + dueDate + " | Completed: " + isCompleted;
    }
}

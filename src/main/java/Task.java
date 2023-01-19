public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Task Marked as done");
    }

    public void markAsNotDone() {
        this.isDone = false;
        System.out.println("Task marked as not done");
    }

    @Override
    public String toString() {
       return "[" + this.getStatusIcon() + "] " + this.description;
    }
}

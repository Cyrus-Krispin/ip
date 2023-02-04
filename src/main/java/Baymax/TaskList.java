package Baymax;

import Tasks.Task;

import java.util.ArrayList;

public class TaskList {
    // contains the task list
    private ArrayList<Task> taskList;

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public TaskList() {
        this.taskList = null;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void updateList(ArrayList<Task> newList) {

        this.taskList = newList;
    }

}

package commands;

import baymax.Storage;
import baymax.TaskList;
import baymax.Ui;
import tasks.Event;

public class EventCommand implements Command {
    private String input;

    public EventCommand(String input) {
        this.input = input;
    }

    /**
     * Adds a new event to the task list.
     *
     * @param taskList The list of tasks.
     * @param ui The user interface.
     * @param storage The storage.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        Event event = new Event(getDescription(), getStartDateTime(), getEndDateTime());
        taskList.getTaskList().add(event);
        storage.store(taskList.getTaskList());
        ui.newEventMessage(event);
    }

    /**
     * Returns the description of the event.
     *
     * @return The description of the event.
     */
    public String getDescription() {
        return input.split(" ", 2)[1].split(" /from ", 2)[0];
    }

    /**
     * Returns the start date and time of the event.
     *
     * @return The start date and time of the event.
     */
    public String getStartDateTime() {
        return input.split(" /from ", 2)[1].split(" /to ", 2)[0];
    }

    /**
     * Returns the end date and time of the event.
     *
     * @return The end date and time of the event.
     */
    public String getEndDateTime() {
        return input.split(" /to ", 2)[1];
    }
}

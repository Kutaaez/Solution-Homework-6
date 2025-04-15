package smarthomeremote.invoker;
import smarthomeremote.commands.Command;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Map<Integer, Command> commandSlots;
    private Stack<Command> commandHistory;
    private Stack<Command> redoHistory;

    public SmartHomeRemoteControl() {
        this.commandSlots = new HashMap<>();
        this.commandHistory = new Stack<>();
        this.redoHistory = new Stack<>();
    }

    public void setCommand(int slot, Command command) {
        commandSlots.put(slot, command);
    }

    public void pressButton(int slot) {
        Command command = commandSlots.get(slot);
        if (command != null) {
            command.execute();
            commandHistory.push(command);
            redoHistory.clear();
        }
    }

    public void undoButton() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
            redoHistory.push(command);
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redoButton() {
        if (!redoHistory.isEmpty()) {
            Command command = redoHistory.pop();
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("Nothing to redo");
        }
    }
}